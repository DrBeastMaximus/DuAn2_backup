package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.StorageDAO;
import com.example.backend_final_project.model.Storage;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@EnableTransactionManagement
public class StorageDAOImpl implements StorageDAO {
    @Override
    public List<Storage> getStorageList() {
        return null;
    }

    @Override
    public Storage getStorageById(int id) {
        return null;
    }

    @Override
    public List<Storage> getStorageByProdID(int prodID) {
        return null;
    }

    @Override
    public List<Storage> getStorageByProviderID(int providerID) {
        return null;
    }

    @Override
    public void addStorage(Storage storage) {

    }

    @Override
    public void updateStorage(Storage storage) {

    }

    @Override
    public void deleteStorage(Storage storage) {

    }
}
