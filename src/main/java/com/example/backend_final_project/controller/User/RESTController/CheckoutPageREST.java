package com.example.backend_final_project.controller.User.RESTController;

import com.example.backend_final_project.Utils.HTMLTableBuilder;
import com.example.backend_final_project.Utils.MailSender;
import com.example.backend_final_project.model.*;
import com.example.backend_final_project.service.Impl.*;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutPageREST {
    @Autowired
    MailSender MailSender;
    @Autowired
    private CartServiceImpl cartService;
    @Autowired
    private UserServicelmpl userService;
    @Autowired
    private CartDetailServiceImpl cartDetailService;
    @Autowired
    private InvoiceServiceImpl invoiceService;
    @Autowired
    private InvoiceDetailServiceImpl invoiceDetailService;
    @Autowired
    private VoucherServiceImpl voucherService;
    @Autowired
    private ProductServiceImpl productService;
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    String randomString(int len){
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    @GetMapping("/getVoucherInfo/{code}")
    public ResponseEntity<?> checkVoucher(@PathVariable String code){
        List<Voucher> voucher = voucherService.getVoucherByCode(code);
        if(voucher.size()!=0){
            if(!voucher.get(0).isStatus()){
                if(voucher.get(0).getLimit_use()>0){
                    if(!(new Date()).after(voucher.get(0).getExpiration_date())){
                        return ResponseEntity.ok(voucher.get(0).getValue());
                    } else{
                        voucher.get(0).setStatus(true);
                        voucherService.updateVoucher(voucher.get(0));
                        return ResponseEntity.badRequest().body("Voucher hết hạn!");
                    }
                }else{
                    return ResponseEntity.badRequest().body("Voucher hết lượt sử dụng!");
                }
            }else{
                return ResponseEntity.badRequest().body("Voucher không hợp lệ!");
            }
        } else {
            return ResponseEntity.badRequest().body("Voucher không hợp lệ!");
        }
    }

    public Integer checkVc(String code){
        List<Voucher> voucher = voucherService.getVoucherByCode(code);
        if(voucher.size()!=0){
            if(!voucher.get(0).isStatus()){
                if(voucher.get(0).getLimit_use()>0){
                    if(!(new Date()).after(voucher.get(0).getExpiration_date())){
                        return voucher.get(0).getValue();
                    } else{
                        voucher.get(0).setStatus(true);
                        voucherService.updateVoucher(voucher.get(0));
                        return 0;
                    }
                }else{
                    return 0;
                }
            }else{
                return 0;
            }
        } else {
            return 0;
        }
    }

    @GetMapping("/getAddress/{userID}")
    public String getAddress(@PathVariable int userID){
        return userService.getUserById(userID).getAddress();
    }

    @PostMapping("/order/{userID}/{voucherCode}")
    public Boolean orderwithVoucher(@PathVariable int userID, @PathVariable String voucherCode, @RequestBody JsonNode json) throws MessagingException {
        int discountValue = checkVc(voucherCode);
        String receipt = null;
        float total;
        User user = userService.getUserById(userID);
        if(user!=null) {
            user.setFullname(json.get("name").asText());
            user.setPhone(String.valueOf(json.get("phone").asLong()));
            user.setAddress(json.get("address").asText());
            userService.updateUser(user);
            Cart cart = cartService.getCartByUserId(userID);
            List<Cart_Detail> cartDetail = cartDetailService.getCartDetailListByCardID(cart.getId());
            if(cartDetail.size()>0) {
                Invoice invoice = new Invoice();
                invoice.setUser(user);
                if(discountValue>100) {
                    total = cart.getTotal() - discountValue;
                    invoice.setTotal(total);
                } else{
                    total = cart.getTotal() * ((100 - discountValue) / 100);
                    invoice.setTotal(total);
                }
                invoice.setPayment("Trực tiếp");
                invoice.setVoucher(voucherService.getVoucherByCode(voucherCode).get(0));
                invoice.setUpdate_by("System");
                invoice.setCreated_date(new Date());
                invoice.setUpdate_Date(new Date());
                String code = randomString(5);
                List<Invoice> inv = invoiceService.getInvoiceListByCode(code);
                while(inv.size()>0){
                    code = randomString(5);
                }
                invoice.setCode(code);
                invoice.setIsdelete(false);
                invoice.setStatus(0);
                invoiceService.addInvoice(invoice);
                HTMLTableBuilder htmlBuilder = new HTMLTableBuilder(null, true, cartDetail.size(), 6);
                htmlBuilder.addTableHeader("Hình ảnh","Tên sản phẩm","Giá", "Số lượng","Thành Tiền","Link sản phẩm");
                for (int i = 0; i < cartDetail.size(); i++) {
                    Invoice_Detail invoiceD = new Invoice_Detail();
                    invoiceD.setInvoice(invoice);
                    invoiceD.setQuantity(cartDetail.get(i).getQuantity());
                    invoiceD.setProduct(cartDetail.get(i).getProduct());
                    if(cartDetail.get(i).getProduct().getPrice_sale()!=0){
                        invoiceD.setProduct_Price(cartDetail.get(i).getProduct().getPrice_sale());
                        invoiceD.setTotal(cartDetail.get(i).getProduct().getPrice_sale()*cartDetail.get(i).getQuantity());
                    } else{
                        invoiceD.setProduct_Price(cartDetail.get(i).getProduct().getPrice());
                        invoiceD.setTotal(cartDetail.get(i).getProduct().getPrice()*cartDetail.get(i).getQuantity());
                    }
                    invoiceD.setCreated_date(new Date());
                    invoiceD.setUpdate_Date(new Date());
                    Product p = productService.getProductById(cartDetail.get(i).getProduct().getID());
                    p.setQuantity(p.getQuantity()-1);
                    productService.updateProduct(p);
                    invoiceD.setPrice_sale(p.getPrice_sale());
                    invoiceDetailService.addInvoiceDetail(invoiceD);

                    cartDetailService.deleteCartDetail(cartDetail.get(i).getId());
                    String pd = productService.getProductById(cartDetail.get(i).getProduct().getID()).getName();
                    Float price = cartDetail.get(i).getProduct_Price();
                    Float totasl = cartDetail.get(i).getTotal();
                    String indexImg = "<img src=\"http://dwhigh.tech:8080/api/image/getIndexImages/" + cartDetail.get(i).getProduct().getID()+"\" width=\"130\" height=\"130\">";
                    String productlink = "http://dwhigh.tech/san-pham-chi-tiet/" +cartDetail.get(i).getProduct().getID();
                    int qty = cartDetail.get(i).getQuantity();
                    htmlBuilder.addRowValues(indexImg,pd, String.format("%.2f", price), String.valueOf(qty),String.format("%.2f", totasl),productlink);
                    cartDetailService.deleteCartDetail(cartDetail.get(i).getId());

                }
                String table = htmlBuilder.build();
                cartService.deleteCart(cart.getId());
                List<Voucher> voucher = voucherService.getVoucherByCode(voucherCode);
                if(voucher!=null){
                    if(!voucher.get(0).isStatus()){
                        if(voucher.get(0).getLimit_use()>0){
                            voucher.get(0).setUpdated_date(new Date());
                            voucher.get(0).setUpdated_by("System");
                            voucher.get(0).setLimit_use(voucher.get(0).getLimit_use()-1);
                            voucherService.updateVoucher(voucher.get(0));
                        } else if(voucher.get(0).getLimit_use()==1){
                            voucher.get(0).setUpdated_date(new Date());
                            voucher.get(0).setUpdated_by("System");
                            voucher.get(0).setLimit_use(0);
                            voucher.get(0).setStatus(true);
                            voucherService.updateVoucher(voucher.get(0));
                        }
                    }
                }
                String text = new StringBuilder()
                        .append("Đơn đặt hàng của bạn đã được chúng tôi ghi lại và xử lý. Vui lòng chờ điện thoại xác nhận từ nhân viên trong vòng 24h.\n")
                        .append(table)
                        .append("\n Tổng hóa đơn của bạn là: "+total+"\n")
                        .append("\n Voucher bạn đã áp dụng: "+ voucherCode)
                        .toString();

                MailSender.sendText(user.getEmail(),
                        "DWFashion Chân Thành Cảm Ơn Bạn Đã Đặt Hàng",
                        text);
                return true;
            } else {return false;}
        } else{
            return false;
        }

    }

    @PostMapping("/order/{userID}")
    public Boolean orderwithoutVoucher(@PathVariable int userID, @RequestBody JsonNode json) throws MessagingException {
        User user = userService.getUserById(userID);
        String receipt="";
        if(user!=null) {
            user.setFullname(json.get("name").asText());
            user.setPhone("0"+String.valueOf(json.get("phone").asLong()));
            user.setAddress(json.get("address").asText());
            userService.updateUser(user);
            Cart cart = cartService.getCartByUserId(userID);
            List<Cart_Detail> cartDetail = cartDetailService.getCartDetailListByCardID(cart.getId());
            if(cartDetail.size()>0) {
                Invoice invoice = new Invoice();
                invoice.setUser(user);
                float total = cart.getTotal();
                invoice.setTotal(total);
                invoice.setPayment("Trực tiếp");
                invoice.setVoucher(null);
                invoice.setUpdate_by("System");
                invoice.setCreated_date(new Date());
                invoice.setUpdate_Date(new Date());
                String code = randomString(5);
                List<Invoice> inv = invoiceService.getInvoiceListByCode(code);
                while(inv.size()>0){
                    code = randomString(5);
                }
                invoice.setCode(code);
                invoice.setIsdelete(false);
                invoice.setStatus(0);
                invoiceService.addInvoice(invoice);
                HTMLTableBuilder htmlBuilder = new HTMLTableBuilder(null, true, cartDetail.size(), 6);
                htmlBuilder.addTableHeader("Hình ảnh","Tên sản phẩm","Giá", "Số lượng","Thành Tiền","Link sản phẩm");
                for (int i = 0; i < cartDetail.size(); i++) {
                    Invoice_Detail invoiceD = new Invoice_Detail();
                    invoiceD.setInvoice(invoice);
                    invoiceD.setQuantity(cartDetail.get(i).getQuantity());
                    invoiceD.setProduct(cartDetail.get(i).getProduct());
                    if(cartDetail.get(i).getProduct().getPrice_sale()!=0){
                        invoiceD.setProduct_Price(cartDetail.get(i).getProduct().getPrice_sale());
                        invoiceD.setTotal(cartDetail.get(i).getProduct().getPrice_sale()*cartDetail.get(i).getQuantity());
                    } else{
                        invoiceD.setProduct_Price(cartDetail.get(i).getProduct().getPrice());
                        invoiceD.setTotal(cartDetail.get(i).getProduct().getPrice()*cartDetail.get(i).getQuantity());
                    }
                    invoiceD.setCreated_date(new Date());
                    invoiceD.setUpdate_Date(new Date());
                    Product p = productService.getProductById(cartDetail.get(i).getProduct().getID());
                    p.setQuantity(p.getQuantity()-1);
                    productService.updateProduct(p);
                    invoiceD.setPrice_sale(p.getPrice_sale());
                    invoiceDetailService.addInvoiceDetail(invoiceD);
                String pd = productService.getProductById(cartDetail.get(i).getProduct().getID()).getName();
                Float price = cartDetail.get(i).getProduct_Price();
                Float totasl = cartDetail.get(i).getTotal();
                String indexImg = "<img src=\"http://dwhigh.tech:8080/api/image/getIndexImages/" + cartDetail.get(i).getProduct().getID()+"\" width=\"130\" height=\"130\">";
                String productlink = "http://dwhigh.tech/san-pham-chi-tiet/" +cartDetail.get(i).getProduct().getID();
                int qty = cartDetail.get(i).getQuantity();
                    htmlBuilder.addRowValues(indexImg,pd, String.format("%.2f", price), String.valueOf(qty),String.format("%.2f", totasl),productlink);
                    cartDetailService.deleteCartDetail(cartDetail.get(i).getId());

                }
                String table = htmlBuilder.build();
                cartService.deleteCart(cart.getId());
                String text = new StringBuilder()
                        .append("Đơn đặt hàng của bạn đã được chúng tôi ghi lại và xử lý. Vui lòng chờ điện thoại xác nhận từ nhân viên trong vòng 24h.\n")
                        .append(table)
                        .append("\n Tổng hóa đơn của bạn là: "+total)
                        .toString();
                MailSender.sendText(user.getEmail(),
                        "DWFashion Chân Thành Cảm Ơn Bạn Đã Đặt Hàng",
                        text);
                return true;
            } else{
                return false;}
        } else{
            return false;
        }

    }
}
