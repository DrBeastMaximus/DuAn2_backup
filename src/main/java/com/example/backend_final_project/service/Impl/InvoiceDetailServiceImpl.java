package com.example.backend_final_project.service.Impl;


import com.example.backend_final_project.DAO.Impl.InvoiceDetailDAOImpl;
import com.example.backend_final_project.model.Invoice_Detail;
import com.example.backend_final_project.service.InvoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InvoiceDetailServiceImpl implements InvoiceDetailService {
    @Autowired
    private InvoiceDetailDAOImpl invoiceDetailDAOlmpl;

    @Override
    public List<Invoice_Detail> getInvoiceDetailList() {

        return invoiceDetailDAOlmpl.getInvoiceDetailList();
    }

    @Override
    public Invoice_Detail getInvoiceDetailById(int id)
    {
        return invoiceDetailDAOlmpl.getInvoiceDetailById(id);
    }

    @Override
    public List<Invoice_Detail> getInvoiceDetailListByInvoiceId(int userID) {

        return invoiceDetailDAOlmpl.getInvoiceDetailListByInvoiceId(userID);
    }

    @Override
    public List<Invoice_Detail> getInvoiceDetailByProductId(int prodID) {

        return invoiceDetailDAOlmpl.getInvoiceDetailByProductId(prodID);
    }

    @Override
    public void addInvoiceDetail(Invoice_Detail invoiceD) {
    invoiceDetailDAOlmpl.addInvoiceDetail(invoiceD);
    }

    @Override
    public void updateInvoiceDetail(Invoice_Detail invoiceD) {
    invoiceDetailDAOlmpl.updateInvoiceDetail(invoiceD);
    }

    @Override
    public void deleteInvoiceDetail(int invoiceDetailID) {
    invoiceDetailDAOlmpl.deleteInvoiceDetail(invoiceDetailID);
    }
}
