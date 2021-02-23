package com.example.backend_final_project.service.Impl;


import com.example.backend_final_project.DAO.Impl.StorageDAOImpl;
import com.example.backend_final_project.model.Storage;
import com.example.backend_final_project.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageDAOImpl storageDAOlmpl;

    @Override
    public List<Storage> getStorageList() {

        return storageDAOlmpl.getStorageList();
    }

    @Override
    public Storage getStorageById(int id) {

        return storageDAOlmpl.getStorageById(id);
    }

    @Override
    public List<Storage> getStorageByProdID(int prodID) {

        return storageDAOlmpl.getStorageByProdID(prodID);
    }

    @Override
    public List<Storage> getStorageByProviderID(int providerID) {

        return storageDAOlmpl.getStorageByProviderID(providerID);
    }

    @Override
    public void addStorage(Storage storage) {
    storageDAOlmpl.addStorage(storage);
    }

    @Override
    public void updateStorage(Storage storage) {
    storageDAOlmpl.updateStorage(storage);
    }

    @Override
    public void deleteStorage(Storage storage) {
    storageDAOlmpl.deleteStorage(storage);
    }
}
