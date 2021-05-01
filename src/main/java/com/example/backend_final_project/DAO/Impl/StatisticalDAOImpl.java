package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.StatisticalDAO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@EnableTransactionManagement
public class StatisticalDAOImpl implements StatisticalDAO {
    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public Object getCountDHandDT() {
        Session session = this.sessionFactory.openSession();
        String hql = "select count(id) as count,sum(Total)as sum from Invoice where Status = 3";
        Query query = session.createQuery(hql);

        Object object = query.list();
        return object;
    }

    @Override
    public Object getCountUser() {
        Session session = this.sessionFactory.openSession();
        String hql = "select count(id) from User where isdelete = false";
        Query query = session.createQuery(hql);

        Object object = query.list();
        return object;
    }

    @Override
    public Object getCountUserByyear(int year) {
        Session session = this.sessionFactory.openSession();
        String hql = "select count(id) from User where isdelete = false and  YEAR(Created_date) = :year ";
        Query query = session.createQuery(hql).setParameter("year",year);
        Object object = query.list();
        return object;
    }

    @Override
    public Object getQuantityInvoiceByyear(int year) {
        Session session = this.sessionFactory.openSession();
        String hql = "select Month(Created_date), count(id) from  Invoice where YEAR(Created_date) = :year and Status = 3 group by Month(Created_date)";
        Query query = session.createQuery(hql).setParameter("year",year);
        Object object = query.list();
        return object;
    }

    @Override
    public Object getTotalInvoiceByyear(int year) {
        Session session = this.sessionFactory.openSession();
        String hql = "select Month(Created_date), Sum(Total) from  Invoice where YEAR(Created_date) = :year and Status = 3 group by Month(Created_date)";
        Query query = session.createQuery(hql).setParameter("year",year);
        Object object = query.list();
        return object;
    }

    @Override
    public Object getQuantityUserByyear(int year) {
        Session session = this.sessionFactory.openSession();
        String hql = "select Month(Created_date), count(Id) from  User where YEAR(Created_date) = :year  and isdelete = false group by Month(Created_date)";
        Query query = session.createQuery(hql).setParameter("year",year);
        Object object = query.list();
        return object;
    }

    @Override
    public Object getTopProductbyyear(int year) {
        Session session = this.sessionFactory.openSession();
        String hql = "select Product.Name, sum(Quantity), sum(Total) from Invoice_Detail where YEAR(Created_date) = :year and Invoice.Status = 3 group by Product.ID,Product.Name order by sum(Total) DESC";
        Query query = session.createQuery(hql).setParameter("year",year).setMaxResults(10);
        Object object = query.list();
        return object;
    }

    @Override
    public Object getTopProductbymonthyear(int month, int year) {
        Session session = this.sessionFactory.openSession();
        String hql = "select Product.Name, sum(Quantity), sum(Total) from Invoice_Detail where YEAR(Created_date) = :year and MONTH(Created_date) = :month and Invoice.Status = 3 group by Product.ID,Product.Name  order by sum(Total) DESC";
        Query query = session.createQuery(hql).setParameter("year",year)
                .setParameter("month",month).setMaxResults(10);
        Object object = query.list();
        return object;
    }

    @Override
    public Object getTopWishlishbyyear(int year) {
        Session session = this.sessionFactory.openSession();
        String hql = "select product.Name, count(ID) from Wishlish where YEAR(Created_date) = :year  group by product.ID, product.Name  order by count(ID) DESC";
        Query query = session.createQuery(hql).setParameter("year",year).setMaxResults(10);
        Object object = query.list();
        return object;
    }

    @Override
    public Object getTopWishlishbymonthyear(int month, int year) {
        Session session = this.sessionFactory.openSession();
        String hql = "select product.Name, count(ID) from Wishlish where YEAR(Created_date) = :year and MONTH(Created_date) = :month group by product.ID, product.Name order by count(ID) DESC";
        Query query = session.createQuery(hql).setParameter("year",year)
                .setParameter("month",month).setMaxResults(10);
        Object object = query.list();
        return object;
    }

    @Override
    public Object getTopUserbyyear(int year) {
        Session session = this.sessionFactory.openSession();
        String hql = "select  User.Fullname , sum(Total) from  Invoice where YEAR(Created_date) = :year and Status = 3 group by User.Id, User.Fullname order by sum(Total) DESC";
        Query query = session.createQuery(hql).setParameter("year",year).setMaxResults(10);
        Object object = query.list();
        return object;
    }

    @Override
    public Object getTopUserbymonthyear(int month, int year) {
        Session session = this.sessionFactory.openSession();
        String hql = "select  User.Fullname , sum(Total) from  Invoice where YEAR(Created_date) = :year  and MONTH(Created_date) = :month and Status = 3 group by User.Id, User.Fullname order by sum(Total) DESC";
        Query query = session.createQuery(hql).setParameter("year",year)
                .setParameter("month",month).setMaxResults(10);
        Object object = query.list();
        return object;
    }

    @Override
    public Object getProductbyyear(int year) {
        Session session = this.sessionFactory.openSession();
        String hql = "select Product.ID,Product.Name, sum(Quantity), sum(Total) from Invoice_Detail where YEAR(Created_date) = :year and Invoice.Status = 3 group by Product.ID,Product.Name";
        Query query = session.createQuery(hql).setParameter("year",year);
        Object object = query.list();
        return object;
    }

    @Override
    public Object getProductbymonthyear(int month, int year) {

        Session session = this.sessionFactory.openSession();
        String hql = "select Product.ID,Product.Name, sum(Quantity), sum(Total) from Invoice_Detail where YEAR(Created_date) = :year and MONTH(Created_date) = :month and Invoice.Status = 3 group by Product.ID,Product.Name";
        Query query = session.createQuery(hql).setParameter("year",year)
                .setParameter("month",month).setMaxResults(10);
        Object object = query.list();
        return object;
    }

    @Override
    public Object getSupplierbyyear(int year) {

        Session session = this.sessionFactory.openSession();
        String hql = "select Product.Supplier_id.Id,Product.Supplier_id.Name, sum(Quantity), sum(Total) from Invoice_Detail where YEAR(Created_date) = :year and Invoice.Status = 3 group by Product.Supplier_id.Id,Product.Supplier_id.Name";
        Query query = session.createQuery(hql).setParameter("year",year);
        Object object = query.list();
        return object;

    }

    @Override
    public Object getSupplierbymonthyear(int month, int year) {

        Session session = this.sessionFactory.openSession();
        String hql = "select Product.Supplier_id.Id,Product.Supplier_id.Name, sum(Quantity), sum(Total) from Invoice_Detail where YEAR(Created_date) = :year and MONTH(Created_date) = :month and  Invoice.Status = 3 group by Product.Supplier_id.Id,Product.Supplier_id.Name";
        Query query = session.createQuery(hql).setParameter("year",year)
                .setParameter("month",month).setMaxResults(10);
        Object object = query.list();
        return object;
    }
}
