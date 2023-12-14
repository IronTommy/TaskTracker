package service;

import model.Task;

import java.util.List;

public interface TaskService {

    Task createTask(Task task, Long authorId, Long assigneeId);

    Task editTask(Long taskId, Task updatedTask);

    void deleteTask(Long taskId);

    List<Task> getAllTasks();

    List<Task> getTasksByAuthor(Long authorId);

    List<Task> getTasksByAssignee(Long assigneeId);

    Task changeTaskStatus(Long taskId, String newStatus);

    Task assignTask(Long taskId, Long assigneeId);

}
