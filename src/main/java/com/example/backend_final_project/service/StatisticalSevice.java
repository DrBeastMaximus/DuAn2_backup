package com.example.backend_final_project.service;

public interface StatisticalSevice {
    Object getCountDHandDT();
    Object getCountUser();
    Object getCountUserByyear(int year);
    Object getQuantityInvoiceByyear(int year);
    Object getTotalInvoiceByyear(int year);
    Object getQuantityUserByyear(int year);
    Object getTopProductbyyear(int year);
    Object getTopProductbymonthyear(int month,int year);
    Object getTopWishlishbyyear(int year);
    Object getTopWishlishbymonthyear(int month,int year);
    Object getTopUserbyyear(int year);
    Object getTopUserbymonthyear(int month,int year);
    Object getProductbyyear(int year);
    Object getProductbymonthyear(int month,int year);
    Object getSupplierbyyear(int year);
    Object getSupplierbymonthyear(int month,int year);
}
