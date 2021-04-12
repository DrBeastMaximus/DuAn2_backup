package com.example.backend_final_project.service.Impl;

import com.example.backend_final_project.DAO.Impl.StatisticalDAOImpl;
import com.example.backend_final_project.service.StatisticalSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StatisticalSeviceImpl implements StatisticalSevice {
    @Autowired
    private StatisticalDAOImpl statisticalDAOImpl;

    @Override
    public Object getCountDHandDT() {
        return statisticalDAOImpl.getCountDHandDT();
    }

    @Override
    public Object getCountUser() {
        return statisticalDAOImpl.getCountUser();
    }

    @Override
    public Object getCountUserByyear(int year) {
        return statisticalDAOImpl.getCountUserByyear(year);
    }

    @Override
    public Object getQuantityInvoiceByyear(int year) {
        return statisticalDAOImpl.getQuantityInvoiceByyear(year);
    }

    @Override
    public Object getTotalInvoiceByyear(int year) {
        return  statisticalDAOImpl.getTotalInvoiceByyear(year);
    }

    @Override
    public Object getQuantityUserByyear(int year) {
        return statisticalDAOImpl.getQuantityUserByyear(year);
    }

    @Override
    public Object getTopProductbyyear(int year) {
        return statisticalDAOImpl.getTopProductbyyear(year);
    }

    @Override
    public Object getTopProductbymonthyear(int month, int year) {

        return statisticalDAOImpl.getTopProductbymonthyear(month,year);
    }

    @Override
    public Object getTopWishlishbyyear(int year) {
        return statisticalDAOImpl.getTopWishlishbyyear(year);
    }

    @Override
    public Object getTopWishlishbymonthyear(int month, int year) {
        return statisticalDAOImpl.getTopWishlishbymonthyear(month,year);
    }

    @Override
    public Object getTopUserbyyear(int year) {
        return statisticalDAOImpl.getTopUserbyyear(year);
    }

    @Override
    public Object getTopUserbymonthyear(int month, int year) {
        return statisticalDAOImpl.getTopUserbymonthyear(month,year);
    }

    @Override
    public Object getProductbyyear(int year) {
        return statisticalDAOImpl.getProductbyyear(year);
    }

    @Override
    public Object getProductbymonthyear(int month, int year) {

        return statisticalDAOImpl.getProductbymonthyear(month,year);
    }

    @Override
    public Object getSupplierbyyear(int year)
    {
        return statisticalDAOImpl.getSupplierbyyear(year);
    }

    @Override
    public Object getSupplierbymonthyear(int month, int year)
    {
        return statisticalDAOImpl.getSupplierbymonthyear(month,year);
    }
}
