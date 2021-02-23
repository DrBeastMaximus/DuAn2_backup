package com.example.backend_final_project.service;

import com.example.backend_final_project.model.Provider;

import java.util.List;

public interface ProviderService {
    List<Provider> getProviderList();

    Provider getProviderById(int id);

    List<Provider> getProviderByName(String name);

    List<Provider> getProviderByPhone(String phone);

    List<Provider> getProviderByEmail(String email);

    void addProvider(Provider provider);

    void updateProvider(Provider provider);

    void deleteProvider(int providerID);
}
