package com.example.backend_final_project.service.Impl;


import com.example.backend_final_project.DAO.Impl.ProviderDAOImpl;
import com.example.backend_final_project.model.Provider;
import com.example.backend_final_project.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    private ProviderDAOImpl providerDAOlmpl;

    @Override
    public List<Provider> getProviderList() {

        return providerDAOlmpl.getProviderList();
    }

    @Override
    public Provider getProviderById(int id) {

        return providerDAOlmpl.getProviderById(id);
    }

    @Override
    public List<Provider> getProviderByName(String name) {

        return providerDAOlmpl.getProviderByName(name);
    }

    @Override
    public List<Provider> getProviderByPhone(String phone) {

        return providerDAOlmpl.getProviderByPhone(phone);
    }

    @Override
    public List<Provider> getProviderByEmail(String email) {

        return providerDAOlmpl.getProviderByEmail(email);
    }

    @Override
    public void addProvider(Provider provider) {
    providerDAOlmpl.addProvider(provider);
    }

    @Override
    public void updateProvider(Provider provider) {
    providerDAOlmpl.updateProvider(provider);
    }

    @Override
    public void deleteProvider(Provider provider) {
    providerDAOlmpl.deleteProvider(provider);
    }
}
