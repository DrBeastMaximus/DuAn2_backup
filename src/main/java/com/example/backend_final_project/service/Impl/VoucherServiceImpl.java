package com.example.backend_final_project.service.Impl;


import com.example.backend_final_project.DAO.Impl.VoucherDAOImpl;
import com.example.backend_final_project.model.Voucher;
import com.example.backend_final_project.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VoucherServiceImpl implements VoucherService {
    @Autowired
    private VoucherDAOImpl voucherDAOlmpl;

    @Override
    public List<Voucher> getVoucherList() {

        return voucherDAOlmpl.getVoucherList();
    }

    @Override
    public Voucher getVoucherById(int id) {

        return voucherDAOlmpl.getVoucherById(id);
    }

    @Override
    public List<Voucher> getVoucherByCode(String code) {

        return voucherDAOlmpl.getVoucherByCode(code);
    }

    @Override
    public List<Voucher> getVoucherByProductTypeID(int prodTypeID) {

        return voucherDAOlmpl.getVoucherByProductTypeID(prodTypeID);
    }

    @Override
    public List<Voucher> getVoucherByStatus(int status) {

        return voucherDAOlmpl.getVoucherByStatus(status);
    }

    @Override
    public void addStorage(Voucher voucher) {
    voucherDAOlmpl.addStorage(voucher);
    }

    @Override
    public void updateStorage(Voucher voucher) {
    voucherDAOlmpl.updateStorage(voucher);
    }

    @Override
    public void deleteStorage(Voucher voucher) {
    voucherDAOlmpl.deleteStorage(voucher);
    }
}
