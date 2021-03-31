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
}
