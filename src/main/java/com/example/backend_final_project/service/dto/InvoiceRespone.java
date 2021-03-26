package com.example.backend_final_project.service.dto;

import com.example.backend_final_project.model.Invoice;

import java.util.List;

public class InvoiceRespone {
    private Invoice invoice;
    private List<Invoice_detetailRespone> invoidetail;

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public List<Invoice_detetailRespone> getInvoidetail() {
        return invoidetail;
    }

    public void setInvoidetail(List<Invoice_detetailRespone> invoidetail) {
        this.invoidetail = invoidetail;
    }

    public InvoiceRespone(Invoice invoice, List<Invoice_detetailRespone> invoidetail) {
        this.invoice = invoice;
        this.invoidetail = invoidetail;
    }

    public InvoiceRespone() {
    }
}
