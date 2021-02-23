package com.example.backend_final_project.service.Impl;


import com.example.backend_final_project.DAO.Impl.DeliveryDAOImpl;
import com.example.backend_final_project.model.Delivery;
import com.example.backend_final_project.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryDAOImpl deliveryDAOlmpl;

    @Override
    public List<Delivery> getDeliveryList()
    {
        return deliveryDAOlmpl.getDeliveryList();
    }

    @Override
    public Delivery getDeliveryById(int id)
    {
        return deliveryDAOlmpl.getDeliveryById(id);
    }

    @Override
    public List<Delivery> getDeliveryListByInvoiceId(int invID) {

        return deliveryDAOlmpl.getDeliveryListByInvoiceId(invID);
    }

    @Override
    public void addDelivery(Delivery delivery) {
    deliveryDAOlmpl.addDelivery(delivery);
    }

    @Override
    public void updateDelivery(Delivery delivery) {
    deliveryDAOlmpl.updateDelivery(delivery);
    }

    @Override
    public void deleteDelivery(Delivery delivery) {
    deliveryDAOlmpl.deleteDelivery(delivery);
    }
}
