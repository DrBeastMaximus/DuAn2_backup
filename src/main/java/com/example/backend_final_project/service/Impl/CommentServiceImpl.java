package com.example.backend_final_project.service.Impl;


import com.example.backend_final_project.DAO.Impl.CommentDAOImpl;
import com.example.backend_final_project.model.Comment;
import com.example.backend_final_project.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDAOImpl commentDAOlmpl;

    @Override
    public List<Comment> getCommentList() {

        return commentDAOlmpl.getCommentList();
    }

    @Override
    public Comment getCommentById(int id) {

        return commentDAOlmpl.getCommentById(id);
    }

    @Override
    public List<Comment> getCommentListByProductId(int prodID)
    {
        return commentDAOlmpl.getCommentListByProductId(prodID);
    }

    @Override
    public void addComment(Comment comment) {
    commentDAOlmpl.addComment(comment);
    }

    @Override
    public void updateComment(Comment comment) {
    commentDAOlmpl.updateComment(comment);
    }

    @Override
    public void deleteComment(Comment comment) {
    commentDAOlmpl.deleteComment(comment);
    }
}
