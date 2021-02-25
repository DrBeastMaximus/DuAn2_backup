package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.ProviderDAO;
import com.example.backend_final_project.exception.DeleteDataException;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.exception.UpdateDataException;
import com.example.backend_final_project.model.Invoice;
import com.example.backend_final_project.model.Product_type;
import com.example.backend_final_project.model.Provider;
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
public class ProviderDAOImpl implements ProviderDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Provider> getProviderList() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Provider where isdelete=false", Provider.class).getResultList();
    }

    @Override
    public Provider getProviderById(int id) {
        Session session = this.sessionFactory.openSession();
        String queryString = "from Provider where isdelete=false and id = :id";
        return (Provider) session.createQuery(queryString)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public List<Provider> getProviderByName(String name) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Provider where Name like :name and isdelete=false ";
        Query query = session.createQuery(hql);
        query.setParameter("name", name);
        List<Provider> list = query.list();
        return list;
    }

    @Override
    public List<Provider> getProviderByPhone(String phone) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Provider where Phone like :phone and isdelete=false ";
        Query query = session.createQuery(hql);
        query.setParameter("phone", phone);
        List<Provider> list = query.list();
        return list;
    }

    @Override
    public List<Provider> getProviderByEmail(String email) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Provider where Email like :email and isdelete=false ";
        Query query = session.createQuery(hql);
        query.setParameter("email", email);
        List<Provider> list = query.list();
        return list;
    }

    @Override
    @ExceptionHandler({SaveDataErrorException.class})
    public void addProvider(Provider provider) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(provider);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void updateProvider(Provider provider) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(provider);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({DeleteDataException.class})
    public void deleteProvider(int providerID) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Provider provider = session.get(Provider.class, providerID);
            session.delete(provider);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
