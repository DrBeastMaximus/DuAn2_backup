package com.example.backend_final_project.controller.Admin;

import com.example.backend_final_project.model.Invoice;
import com.example.backend_final_project.model.Invoice_Detail;
import com.example.backend_final_project.service.Impl.InvoiceDetailServiceImpl;
import com.example.backend_final_project.service.Impl.InvoiceServiceImpl;
import com.example.backend_final_project.service.SessionService;
import com.example.backend_final_project.service.dto.InvoiceRequest;
import com.example.backend_final_project.service.dto.InvoiceRespone;
import com.example.backend_final_project.service.dto.Invoice_detetailRespone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes({"username", "role"})
//@SessionAttributes("admin")
@RequestMapping("admin/invoice")
public class AdminInvoiceController {
    @Autowired
    private InvoiceDetailServiceImpl invoiceDetailServiceImpl;

    @Autowired
    private InvoiceServiceImpl invoiceServiceImpl;



    @GetMapping("/count/list")
    @ResponseBody
    public List<Object> getcountall(){
        List<Object> list = invoiceServiceImpl.getcountAll();
        return list;
    }


    @GetMapping("/list/{status}")
    @ResponseBody
    public List<InvoiceRespone> getinvoice(@PathVariable("status") int status){
        List<InvoiceRespone> ListinvoiceRespones = new ArrayList<InvoiceRespone>();
        List<Invoice> listinvoice = invoiceServiceImpl.getInvoiceListByStatus(status);
        for(int i =0; i < listinvoice.size(); i ++){
            InvoiceRespone invoiceRespone = new InvoiceRespone();
            List<Invoice_detetailRespone> listinvoice_detetailRespone = new ArrayList<Invoice_detetailRespone>();
            List<Invoice_Detail> listinvoice_detail = invoiceDetailServiceImpl.getInvoiceDetailListByInvoiceId(listinvoice.get(i).getID());
            for(int j =0; j < listinvoice_detail.size(); j++) {
                Invoice_detetailRespone invoice_detetailRespone = new Invoice_detetailRespone();
                invoice_detetailRespone.setProduct_name(listinvoice_detail.get(j).getProduct().getName());
                invoice_detetailRespone.setProduct_price(listinvoice_detail.get(j).getProduct_Price());
                invoice_detetailRespone.setPrice_sale(listinvoice_detail.get(j).getPrice_sale());
                invoice_detetailRespone.setQuantity(listinvoice_detail.get(j).getQuantity());
                invoice_detetailRespone.setTotal(listinvoice_detail.get(j).getTotal());
                invoice_detetailRespone.setId(listinvoice_detail.get(j).getID());
                listinvoice_detetailRespone.add(invoice_detetailRespone);
            }
            invoiceRespone.setInvoice(listinvoice.get(i));
            invoiceRespone.setInvoidetail(listinvoice_detetailRespone);
            ListinvoiceRespones.add(invoiceRespone);
        }

        return ListinvoiceRespones;
    }

    @GetMapping("/home/{status}")
    public String homestatus(ModelMap model,@PathVariable("status") String check){

        int status = 0;
        if(check.equals("cho-xac-nhan")) {
            status = 0;
        }else{
            if (check.equals("cho-van-chuyen")){
                status = 1;
            }else{
                if(check.equals( "dang-van-chuyen")){
                    status = 2;
                }else{
                    if(check.equals("da-huy")){
                        status = 4;
                    }else{
                        if(check.equals("da-hoan-thanh")){
                            status = 3;
                        }else{
                            status = 0;
                        }

                    }

                }
            }
        }


        model.addAttribute("status", new InvoiceRequest());
        model.addAttribute("id", status);
        return "main/tables/dh";
    }
    @PostMapping("/home/{status}")
    public String statusInvoice(ModelMap model,@PathVariable("status") String check,@ModelAttribute InvoiceRequest invoiceRequest){

        int status = 0;
        if(check.equals("cho-xac-nhan")) {
            status = 0;
        }else{
            if (check.equals("cho-van-chuyen")){
                status = 1;
            }else{
                if(check.equals( "dang-van-chuyen")){
                    status = 2;
                }else{
                    if(check.equals("da-huy")){
                        status = 4;
                    }else{
                        if(check.equals("da-hoan-thanh")){
                            status = 3;
                        }else{
                            status = 0;
                        }

                    }

                }
            }
        }

        Invoice invoice = invoiceServiceImpl.getInvoiceById(invoiceRequest.getId());
        invoice.setStatus(invoiceRequest.getStatus());
        invoice.setUpdate_Date(new Date());
        invoice.setUpdate_by(SessionService.username);
        invoiceServiceImpl.updateInvoice(invoice);
        model.addAttribute("status", new InvoiceRequest());
        model.addAttribute("id", status);
        return "main/tables/dh";
    }

}
