package com.example.backend_final_project.DAO;

import com.example.backend_final_project.model.Invoice_Detail;

import java.util.List;

public interface InvoiceDetailDAO {
    List<Invoice_Detail> getInvoiceDetailList();

    Invoice_Detail getInvoiceDetailById(int id);

    List<Invoice_Detail> getInvoiceDetailListByInvoiceId(int userID);

    List<Invoice_Detail> getInvoiceDetailByProductId(int prodID);

    void addInvoiceDetail(Invoice_Detail invoiceD);

    void updateInvoiceDetail(Invoice_Detail invoiceD);

    void deleteInvoiceDetail(int invoiceDetailID);
}

