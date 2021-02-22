package com.example.backend_final_project.DAO;

import com.example.backend_final_project.model.Voucher;

import java.util.List;

public interface VoucherDAO {
    List<Voucher> getVoucherList();

    Voucher getVoucherById(int id);

    List<Voucher> getVoucherByCode(String code);

    List<Voucher> getVoucherByProductTypeID(int prodTypeID);

    List<Voucher> getVoucherByStatus(int status);

    void addStorage(Voucher voucher);

    void updateStorage(Voucher voucher);

    void deleteStorage(Voucher voucher);
}
