package com.example.backend_final_project.DAO;



import com.example.backend_final_project.model.Invoice;

import java.util.List;

public interface InvoiceDAO {
    List<Invoice> getInvoiceList();

    Invoice getDeliveryById(int id);

    List<Invoice> getInvoiceListByUserId(int userID);

    List<Invoice> getInvoiceListByVoucherId(int voucherID);

    void addInvoice(Invoice invoice);

    void updateInvoice(Invoice invoice);

    void deleteInvoice(Invoice invoice);
}
