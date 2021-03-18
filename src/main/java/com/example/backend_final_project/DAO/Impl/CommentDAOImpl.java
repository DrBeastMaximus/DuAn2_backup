package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.CommentDAO;
import com.example.backend_final_project.exception.DeleteDataException;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.exception.UpdateDataException;
import com.example.backend_final_project.model.Cart_Detail;
import com.example.backend_final_project.model.Comment;
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
public class CommentDAOImpl implements CommentDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Comment> getCommentList() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Comment where isdelete=false", Comment.class).getResultList();
    }

    @Override
    public Comment getCommentById(int id) {
        Session session = this.sessionFactory.openSession();
        String queryString = "FROM Comment WHERE id = :id and isdelete=false";
        return (Comment) session.createQuery(queryString)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public List<Comment> getCommentListByProductId(int prodID) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Comment where product.ID = :id and isdelete=false";
        Query query = session.createQuery(hql);
        query.setParameter("id", prodID);
        List<Comment> list = query.list();
        return list;
    }

    @Override
    public Comment getCommentListByProductIdandUserId(int prodID, int userID) {
        Session session = this.sessionFactory.openSession();
        String queryString = "FROM Comment WHERE product.id = :prodID and User.Id = :userID and isdelete=false";
        return (Comment) session.createQuery(queryString)
                .setParameter("prodID", prodID)
                .setParameter("userID", userID)
                .uniqueResult();
    }

    @Override
    @ExceptionHandler({SaveDataErrorException.class})
    public void addComment(Comment comment) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(comment);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void updateComment(Comment comment) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(comment);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({DeleteDataException.class})
    public void deleteComment(int commentID) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Comment comment = session.get(Comment.class, commentID);
            session.delete(comment);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
