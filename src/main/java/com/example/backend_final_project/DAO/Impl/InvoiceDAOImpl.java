package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.InvoiceDAO;
import com.example.backend_final_project.model.Invoice;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
@EnableTransactionManagement
public class InvoiceDAOImpl implements InvoiceDAO {
    @Override
    public List<Invoice> getInvoiceList() {
        return null;
    }

    @Override
    public Invoice getDeliveryById(int id) {
        return null;
    }

    @Override
    public List<Invoice> getInvoiceListByUserId(int userID) {
        return null;
    }

    @Override
    public List<Invoice> getInvoiceListByVoucherId(int voucherID) {
        return null;
    }

    @Override
    public void addInvoice(Invoice invoice) {

    }

    @Override
    public void updateInvoice(Invoice invoice) {

    }

    @Override
    public void deleteInvoice(Invoice invoice) {

    }
}
