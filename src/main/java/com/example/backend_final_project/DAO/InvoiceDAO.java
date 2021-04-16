package com.example.backend_final_project.DAO;



import com.example.backend_final_project.model.Invoice;

import java.util.List;

public interface InvoiceDAO {
    List<Invoice> getInvoiceList();

    Invoice getInvoiceById(int id);

    List<Invoice> getInvoiceListByUserId(int userID);
    List<Invoice> getInvoiceListByStatus(int status);
    List<Invoice> getInvoiceListByVoucherId(int voucherID);
    List<Object> getcountAll();

    List<Invoice> getInvoiceListByCode(String code);

    void addInvoice(Invoice invoice);

    void updateInvoice(Invoice invoice);

    void deleteInvoice(int invoiceID);
}
