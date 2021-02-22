package com.example.backend_final_project.DAO;


import com.example.backend_final_project.model.Delivery;

import java.util.List;

public interface DeliveryDAO {
    List<Delivery> getDeliveryList();

    Delivery getDeliveryById(int id);

    List<Delivery> getDeliveryListByInvoiceId(int invID);

    void addDelivery(Delivery delivery);

    void updateDelivery(Delivery delivery);

    void deleteDelivery(Delivery delivery);
}
