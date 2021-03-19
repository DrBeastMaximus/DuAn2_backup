package com.example.backend_final_project.service.Impl;


import com.example.backend_final_project.DAO.Impl.SupplierDAOImpl;
import com.example.backend_final_project.model.Supplier;
import com.example.backend_final_project.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierDAOImpl supplierDAOlmpl;

    @Override
    public List<Supplier> getSupplierList() {

        return supplierDAOlmpl.getSupplierList();
    }

    @Override
    public Supplier getSupplierById(int id) {

        return supplierDAOlmpl.getSupplierById(id);
    }

    @Override
    public List<Supplier> getSupplierByName(String name) {

        return supplierDAOlmpl.getSupplierByName(name);
    }

    @Override
    public List<Supplier> getSupplierByPhone(String phone) {

        return supplierDAOlmpl.getSupplierByPhone(phone);
    }

    @Override
    public List<Supplier> getSupplierByEmail(String email) {

        return supplierDAOlmpl.getSupplierByEmail(email);
    }

    @Override
    public void addSupplier(Supplier supplier) {
        supplierDAOlmpl.addSupplier(supplier);
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        supplierDAOlmpl.updateSupplier(supplier);
    }

    @Override
    public void deleteSupplier(int SupplierID) {
        supplierDAOlmpl.deleteSupplier(SupplierID);
    }
}
