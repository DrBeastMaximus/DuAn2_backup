package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.ProviderDAO;
import com.example.backend_final_project.model.Provider;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@EnableTransactionManagement
public class ProviderDAOImpl implements ProviderDAO {
    @Override
    public List<Provider> getProviderList() {
        return null;
    }

    @Override
    public Provider getProviderById(int id) {
        return null;
    }

    @Override
    public List<Provider> getProviderByName(String name) {
        return null;
    }

    @Override
    public List<Provider> getProviderByPhone(String phone) {
        return null;
    }

    @Override
    public List<Provider> getProviderByEmail(String email) {
        return null;
    }

    @Override
    public void addProvider(Provider provider) {

    }

    @Override
    public void updateProvider(Provider provider) {

    }

    @Override
    public void deleteProvider(int providerID) {

    }
}
