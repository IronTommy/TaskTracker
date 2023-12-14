package service;

import model.User;
import repository.UserRepository;
import model.Comment;
import model.Task;
import repository.CommentRepository;
import repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, UserRepository userRepository, TaskRepository taskRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public Comment addComment(Comment comment, Long userId, Long taskId) {
        // логика добавления комментария
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        comment.setUser(user);
        comment.setTask(task);
        comment.setCreatedAt(LocalDateTime.now());

        return commentRepository.save(comment);
    }

}

