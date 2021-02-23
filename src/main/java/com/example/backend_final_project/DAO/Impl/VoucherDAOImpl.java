package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.VoucherDAO;
import com.example.backend_final_project.model.Voucher;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@EnableTransactionManagement
public class VoucherDAOImpl implements VoucherDAO {
    @Override
    public List<Voucher> getVoucherList() {
        return null;
    }

    @Override
    public Voucher getVoucherById(int id) {
        return null;
    }

    @Override
    public List<Voucher> getVoucherByCode(String code) {
        return null;
    }

    @Override
    public List<Voucher> getVoucherByProductTypeID(int prodTypeID) {
        return null;
    }

    @Override
    public List<Voucher> getVoucherByStatus(int status) {
        return null;
    }

    @Override
    public void addStorage(Voucher voucher) {

    }

    @Override
    public void updateStorage(Voucher voucher) {

    }

    @Override
    public void deleteStorage(Voucher voucher) {

    }
}
