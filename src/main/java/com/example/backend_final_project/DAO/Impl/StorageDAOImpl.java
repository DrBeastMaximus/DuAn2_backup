package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.StorageDAO;
import com.example.backend_final_project.exception.DeleteDataException;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.exception.UpdateDataException;
import com.example.backend_final_project.model.Product;
import com.example.backend_final_project.model.Provider;
import com.example.backend_final_project.model.Storage;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Repository
@Transactional
@EnableTransactionManagement
public class StorageDAOImpl implements StorageDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Storage> getStorageList() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Storage", Storage.class).getResultList();
    }

    @Override
    public Storage getStorageById(int id) {
        Session session = this.sessionFactory.openSession();
        String queryString = "from Storage where id = :id";
        return (Storage) session.createQuery(queryString)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public List<Storage> getStorageByProdID(int prodID) {
        Session session = this.sessionFactory.openSession();
        Product product = session.get(Product.class, prodID);
        String hql = "FROM Storage where product = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", product);
        List<Storage> list = query.list();
        return list;
    }

    @Override
    public List<Storage> getStorageByProviderID(int providerID) {
        Session session = this.sessionFactory.openSession();
        Provider provider = session.get(Provider.class, providerID);
        String hql = "FROM Storage where Provider = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", provider);
        List<Storage> list = query.list();
        return list;
    }

    @Override
    @ExceptionHandler({SaveDataErrorException.class})
    public void addStorage(Storage storage) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(storage);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void updateStorage(Storage storage) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(storage);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({DeleteDataException.class})
    public void deleteStorage(int storageID) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Storage storage = session.get(Storage.class, storageID);
            session.delete(storage);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
