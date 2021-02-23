package com.example.backend_final_project.service;

import com.example.backend_final_project.model.Delivery;

import java.util.List;

public interface DeliveryService {
    List<Delivery> getDeliveryList();

    Delivery getDeliveryById(int id);

    List<Delivery> getDeliveryListByInvoiceId(int invID);

    void addDelivery(Delivery delivery);

    void updateDelivery(Delivery delivery);

    void deleteDelivery(int deliveryID);
}
