package controller;

import model.Comment;
import service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/add")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment,
                                              @RequestParam Long userId,
                                              @RequestParam Long taskId) {
        Comment addedComment = commentService.addComment(comment, userId, taskId);
        return ResponseEntity.ok(addedComment);
    }

}
