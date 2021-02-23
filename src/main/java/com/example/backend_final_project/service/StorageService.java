package com.example.backend_final_project.service;

import com.example.backend_final_project.model.Storage;

import java.util.List;

public interface StorageService {
    List<Storage> getStorageList();

    Storage getStorageById(int id);

    List<Storage> getStorageByProdID(int prodID);

    List<Storage> getStorageByProviderID(int providerID);

    void addStorage(Storage storage);

    void updateStorage(Storage storage);

    void deleteStorage(int storageID);
}
