package com.example.backend_final_project.DAO;

import com.example.backend_final_project.model.Storage;

import java.util.List;

public interface StorageDAO {
    List<Storage> getStorageList();

    Storage getStorageById(int id);

    List<Storage> getStorageByProdID(int prodID);

    List<Storage> getStorageByProviderID(int providerID);

    void addStorage(Storage storage);

    void updateStorage(Storage storage);

    void deleteStorage(Storage storage);
}
