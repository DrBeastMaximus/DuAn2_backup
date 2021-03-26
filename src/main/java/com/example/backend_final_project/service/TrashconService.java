package com.example.backend_final_project.service;

import com.example.backend_final_project.model.*;

import java.util.List;

public interface TrashconService {
    List<User> getUserdeleteList();
    List<Product> getProductdeleteList();
    List<Voucher> getVoucherdeleteList();
    List<Supplier> getSupplierdeleteList();
    List<Admin> getadmindeleteList();
    void restoreUser(int id);
    void restoreProduct(int id);
    void restoreVoucher(int id);
    void restoreSupplier(int id);
    void restoreAdmin(int id);
}
