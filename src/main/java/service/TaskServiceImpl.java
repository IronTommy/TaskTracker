package service;

import model.User;
import repository.UserRepository;
import model.Task;
import repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Task createTask(Task task, Long authorId, Long assigneeId) {
        // логика создания задачи
        // установить автора и исполнителя
        User author = userRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        User assignee = userRepository.findById(assigneeId)
                .orElseThrow(() -> new RuntimeException("Assignee not found"));

        task.setAuthor(author);
        task.setAssignee(assignee);

        return taskRepository.save(task);
    }

    @Override
    public Task editTask(Long taskId, Task updatedTask) {
        // логика редактирования задачи
        Task existingTask = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setStatus(updatedTask.getStatus());
        existingTask.setPriority(updatedTask.getPriority());

        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(Long taskId) {
        // логика удаления задачи
        taskRepository.deleteById(taskId);
    }

    @Override
    public List<Task> getAllTasks() {
        // логика получения всех задач
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getTasksByAuthor(Long authorId) {
        // логика получения задач по автору
        User author = userRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        return taskRepository.findByAuthor(author);
    }

    @Override
    public List<Task> getTasksByAssignee(Long assigneeId) {
        // логика получения задач по исполнителю
        User assignee = userRepository.findById(assigneeId)
                .orElseThrow(() -> new RuntimeException("Assignee not found"));
        return taskRepository.findByAssignee(assignee);
    }

    @Override
    public Task changeTaskStatus(Long taskId, String newStatus) {
        // логика изменения статуса задачи
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setStatus(newStatus);
        return taskRepository.save(task);
    }

    @Override
    public Task assignTask(Long taskId, Long assigneeId) {
        // логика назначения исполнителя задачи
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        User assignee = userRepository.findById(assigneeId)
                .orElseThrow(() -> new RuntimeException("Assignee not found"));

        task.setAssignee(assignee);
        return taskRepository.save(task);
    }

}

