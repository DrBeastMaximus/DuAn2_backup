package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.InvoiceDetailDAO;
import com.example.backend_final_project.model.Invoice_Detail;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
@EnableTransactionManagement
public class InvoiceDetailDAOImpl implements InvoiceDetailDAO {
    @Override
    public List<Invoice_Detail> getInvoiceDetailList() {
        return null;
    }

    @Override
    public Invoice_Detail getInvoiceDetailById(int id) {
        return null;
    }

    @Override
    public List<Invoice_Detail> getInvoiceDetailListByInvoiceId(int userID) {
        return null;
    }

    @Override
    public List<Invoice_Detail> getInvoiceDetailByProductId(int prodID) {
        return null;
    }

    @Override
    public void addInvoiceDetail(Invoice_Detail invoiceD) {

    }

    @Override
    public void updateInvoiceDetail(Invoice_Detail invoiceD) {

    }

    @Override
    public void deleteInvoiceDetail(Invoice_Detail invoiceD) {

    }
}
