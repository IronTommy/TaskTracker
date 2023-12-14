package service;

import model.Comment;

public interface CommentService {

    Comment addComment(Comment comment, Long userId, Long taskId);

}
