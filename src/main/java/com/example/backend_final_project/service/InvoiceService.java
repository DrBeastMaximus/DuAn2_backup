package com.example.backend_final_project.service;

import com.example.backend_final_project.model.Invoice;

import java.util.List;

public interface InvoiceService {
    List<Invoice> getInvoiceList();

    Invoice getInvoiceById(int id);

    List<Invoice> getInvoiceListByUserId(int userID);

    List<Invoice> getInvoiceListByVoucherId(int voucherID);

    void addInvoice(Invoice invoice);

    void updateInvoice(Invoice invoice);

    void deleteInvoice(int invoiceID);
}
