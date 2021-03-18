package com.example.backend_final_project.DAO;

import com.example.backend_final_project.model.Comment;

import java.util.List;

public interface CommentDAO {
    List<Comment> getCommentList();

    Comment getCommentById(int id);

    List<Comment> getCommentListByProductId(int prodID);

    Comment getCommentListByProductIdandUserId(int prodID, int userID);

    void addComment(Comment comment);

    void updateComment(Comment comment);

    void deleteComment(int commentID);
}
