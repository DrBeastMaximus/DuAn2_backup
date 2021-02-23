package com.example.backend_final_project.service.Impl;

import com.example.backend_final_project.DAO.Impl.InvoiceDAOImpl;

import com.example.backend_final_project.model.Invoice;
import com.example.backend_final_project.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private InvoiceDAOImpl invoiceDAOlmpl;

    @Override
    public List<Invoice> getInvoiceList() {

        return invoiceDAOlmpl.getInvoiceList();
    }

    @Override
    public Invoice getDeliveryById(int id)
    {
        return invoiceDAOlmpl.getDeliveryById(id);
    }

    @Override
    public List<Invoice> getInvoiceListByUserId(int userID) {

        return invoiceDAOlmpl.getInvoiceListByUserId(userID);
    }

    @Override
    public List<Invoice> getInvoiceListByVoucherId(int voucherID) {

        return getInvoiceListByVoucherId(voucherID);
    }

    @Override
    public void addInvoice(Invoice invoice) {
    invoiceDAOlmpl.addInvoice(invoice);
    }

    @Override
    public void updateInvoice(Invoice invoice) {
    invoiceDAOlmpl.updateInvoice(invoice);
    }

    @Override
    public void deleteInvoice(int invoiceID) {
    invoiceDAOlmpl.deleteInvoice(invoiceID);
    }
}
