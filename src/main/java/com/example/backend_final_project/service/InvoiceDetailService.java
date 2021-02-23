package com.example.backend_final_project.service;

import com.example.backend_final_project.model.Invoice_Detail;

import java.util.List;

public interface InvoiceDetailService {
    List<Invoice_Detail> getInvoiceDetailList();

    Invoice_Detail getInvoiceDetailById(int id);

    List<Invoice_Detail> getInvoiceDetailListByInvoiceId(int userID);

    List<Invoice_Detail> getInvoiceDetailByProductId(int prodID);

    void addInvoiceDetail(Invoice_Detail invoiceD);

    void updateInvoiceDetail(Invoice_Detail invoiceD);

    void deleteInvoiceDetail(Invoice_Detail invoiceD);
}
