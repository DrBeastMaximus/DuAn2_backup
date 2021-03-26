package com.example.backend_final_project.DAO;

import com.example.backend_final_project.model.Supplier;

import java.util.List;

public interface SupplierDAO {
    List<Supplier> getSupplierList();

    Supplier getSupplierById(int id);

    List<Supplier> getSupplierByName(String name);

    List<Supplier> getSupplierByPhone(String phone);

    List<Supplier> getSupplierByEmail(String email);

    void addSupplier(Supplier supplier);

    void updateSupplier(Supplier supplier);

    boolean deleteSupplier(int SupplierID);
}
