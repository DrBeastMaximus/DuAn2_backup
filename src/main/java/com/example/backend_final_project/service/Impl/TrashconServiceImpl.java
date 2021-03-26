package com.example.backend_final_project.service.Impl;

import com.example.backend_final_project.DAO.Impl.TrashcanDAOImpl;
import com.example.backend_final_project.model.*;
import com.example.backend_final_project.service.TrashconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TrashconServiceImpl implements TrashconService {

    @Autowired
    private TrashcanDAOImpl trashcanDAOImpl;

    @Override
    public List<User> getUserdeleteList() {
        return trashcanDAOImpl.getUserdeleteList();
    }

    @Override
    public List<Product> getProductdeleteList() {
        return trashcanDAOImpl.getProductdeleteList();
    }

    @Override
    public List<Voucher> getVoucherdeleteList() {
        return trashcanDAOImpl.getVoucherdeleteList();
    }

    @Override
    public List<Supplier> getSupplierdeleteList() {
        return trashcanDAOImpl.getSupplierdeleteList();
    }

    @Override
    public List<Admin> getadmindeleteList() {
        return trashcanDAOImpl.getadmindeleteList();
    }

    @Override
    public void restoreUser(int id) {
    trashcanDAOImpl.restoreUser(id);
    }

    @Override
    public void restoreProduct(int id) {
    trashcanDAOImpl.restoreProduct(id);
    }

    @Override
    public void restoreVoucher(int id) {
    trashcanDAOImpl.restoreVoucher(id);
    }

    @Override
    public void restoreSupplier(int id) {
    trashcanDAOImpl.restoreSupplier(id);
    }

    @Override
    public void restoreAdmin(int id) {
    trashcanDAOImpl.restoreAdmin(id);
    }
}
