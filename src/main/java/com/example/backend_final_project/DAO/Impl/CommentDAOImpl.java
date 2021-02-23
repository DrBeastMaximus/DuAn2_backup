package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.CommentDAO;
import com.example.backend_final_project.model.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
@EnableTransactionManagement
public class CommentDAOImpl implements CommentDAO {
    @Override
    public List<Comment> getCommentList() {
        return null;
    }

    @Override
    public Comment getCommentById(int id) {
        return null;
    }

    @Override
    public List<Comment> getCommentListByProductId(int prodID) {
        return null;
    }

    @Override
    public void addComment(Comment comment) {

    }

    @Override
    public void updateComment(Comment comment) {

    }

    @Override
    public void deleteComment(Comment comment) {

    }
}
