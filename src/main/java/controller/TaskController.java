package controller;

import service.TaskService;
import model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@RequestBody Task task,
                                           @RequestParam Long authorId,
                                           @RequestParam Long assigneeId) {
        Task createdTask = taskService.createTask(task, authorId, assigneeId);
        return ResponseEntity.ok(createdTask);
    }

    @PutMapping("/edit/{taskId}")
    public ResponseEntity<Task> editTask(@PathVariable Long taskId, @RequestBody Task updatedTask) {
        Task editedTask = taskService.editTask(taskId, updatedTask);
        return ResponseEntity.ok(editedTask);
    }

    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok("Task deleted successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/by-author/{authorId}")
    public ResponseEntity<List<Task>> getTasksByAuthor(@PathVariable Long authorId) {
        List<Task> tasks = taskService.getTasksByAuthor(authorId);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/by-assignee/{assigneeId}")
    public ResponseEntity<List<Task>> getTasksByAssignee(@PathVariable Long assigneeId) {
        List<Task> tasks = taskService.getTasksByAssignee(assigneeId);
        return ResponseEntity.ok(tasks);
    }

    @PatchMapping("/change-status/{taskId}")
    public ResponseEntity<Task> changeTaskStatus(@PathVariable Long taskId, @RequestParam String newStatus) {
        Task updatedTask = taskService.changeTaskStatus(taskId, newStatus);
        return ResponseEntity.ok(updatedTask);
    }

    @PatchMapping("/assign/{taskId}")
    public ResponseEntity<Task> assignTask(@PathVariable Long taskId, @RequestParam Long assigneeId) {
        Task updatedTask = taskService.assignTask(taskId, assigneeId);
        return ResponseEntity.ok(updatedTask);
    }

}