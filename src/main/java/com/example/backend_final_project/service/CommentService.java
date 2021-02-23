package com.example.backend_final_project.service;

import com.example.backend_final_project.model.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getCommentList();

    Comment getCommentById(int id);

    List<Comment> getCommentListByProductId(int prodID);

    void addComment(Comment comment);

    void updateComment(Comment comment);

    void deleteComment(Comment comment);
}
