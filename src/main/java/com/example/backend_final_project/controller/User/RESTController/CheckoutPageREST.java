package com.example.backend_final_project.controller.User.RESTController;

import com.example.backend_final_project.model.*;
import com.example.backend_final_project.service.Impl.*;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutPageREST {
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


    @GetMapping("/getVoucherInfo/{code}")
    public Integer checkVoucher(@PathVariable String code){
        List<Voucher> voucher = voucherService.getVoucherByCode(code);
        if(voucher!=null){
            if(voucher.get(0).isStatus()){
                if(voucher.get(0).getLimit_use()>0){
                    return voucher.get(0).getValue();
                }else{
                    return null;
                }
            }else{
                return null;
            }
        } else {
            return null;
        }
    }

    @GetMapping("/getAddress/{userID}")
    public String getAddress(@PathVariable int userID){
        return userService.getUserById(userID).getAddress();
    }

    @PostMapping("/order/{userID}/{voucherCode}")
    public Boolean orderwithVoucher(@PathVariable int userID, @PathVariable String voucherCode, @RequestBody JsonNode json){
        int discontValue = checkVoucher(voucherCode);
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
                float total = cart.getTotal() * ((100 - discontValue) / 100);
                invoice.setTotal(total);
                invoice.setPayment("Trực tiếp");
                invoice.setVoucher(voucherService.getVoucherByCode(voucherCode).get(0));
                invoice.setUpdate_by("System");
                invoice.setCreated_date(new Date());
                invoice.setUpdate_Date(new Date());
                invoice.setIsdelete(false);
                invoice.setStatus(0);
                invoiceService.addInvoice(invoice);
                for (int i = 0; i < cartDetail.size(); i++) {
                    Invoice_Detail invoiceD = new Invoice_Detail();
                    invoiceD.setInvoice(invoice);
                    invoiceD.setQuantity(cartDetail.get(i).getQuantity());
                    invoiceD.setProduct(cartDetail.get(i).getProduct());
                    invoiceD.setProduct_Price(cartDetail.get(i).getProduct_Price());
                    invoiceD.setTotal(cartDetail.get(i).getTotal());
                    invoiceD.setCreated_date(new Date());
                    invoiceD.setUpdate_Date(new Date());
                    invoiceDetailService.addInvoiceDetail(invoiceD);
                    cartDetailService.deleteCartDetail(cartDetail.get(i).getId());
                }
                cartService.deleteCart(cart.getId());
                return true;
            } else {return false;}
        } else{
            return false;
        }

    }
    @PostMapping("/order/{userID}")
    public Boolean orderwithoutVoucher(@PathVariable int userID, @RequestBody JsonNode json){
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
                float total = cart.getTotal();
                invoice.setTotal(total);
                invoice.setPayment("Trực tiếp");
                invoice.setVoucher(null);
                invoice.setUpdate_by("System");
                invoice.setCreated_date(new Date());
                invoice.setUpdate_Date(new Date());
                invoice.setIsdelete(false);
                invoice.setStatus(0);
                invoiceService.addInvoice(invoice);
                for (int i = 0; i < cartDetail.size(); i++) {
                    Invoice_Detail invoiceD = new Invoice_Detail();
                    invoiceD.setInvoice(invoice);
                    invoiceD.setQuantity(cartDetail.get(i).getQuantity());
                    invoiceD.setProduct(cartDetail.get(i).getProduct());
                    invoiceD.setProduct_Price(cartDetail.get(i).getProduct_Price());
                    invoiceD.setTotal(cartDetail.get(i).getTotal());
                    invoiceD.setCreated_date(new Date());
                    invoiceD.setUpdate_Date(new Date());
                    invoiceDetailService.addInvoiceDetail(invoiceD);
                    cartDetailService.deleteCartDetail(cartDetail.get(i).getId());

                }
                cartService.deleteCart(cart.getId());
                return true;
            } else{
                return false;}
        } else{
            return false;
        }

    }
}
