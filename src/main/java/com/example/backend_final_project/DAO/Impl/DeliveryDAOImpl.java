package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.DeliveryDAO;
import com.example.backend_final_project.model.Delivery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
@EnableTransactionManagement
public class DeliveryDAOImpl implements DeliveryDAO {
    @Override
    public List<Delivery> getDeliveryList() {
        return null;
    }

    @Override
    public Delivery getDeliveryById(int id) {
        return null;
    }

    @Override
    public List<Delivery> getDeliveryListByInvoiceId(int invID) {
        return null;
    }

    @Override
    public void addDelivery(Delivery delivery) {

    }

    @Override
    public void updateDelivery(Delivery delivery) {

    }

    @Override
    public void deleteDelivery(int deliveryID) {

    }
}
