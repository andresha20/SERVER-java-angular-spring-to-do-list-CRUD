package project.tech.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import project.tech.crud.models.Task;
import project.tech.crud.repositories.Tasks;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private Tasks taskRepository;

    // Get tasks
    @GetMapping("")
    List<Task> index() {
        return taskRepository.findAll();
    }

    // Create task
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    Task create(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    // Update task
    @PutMapping("{id}")
    Task update(@PathVariable String id, @RequestBody Task task) {
        Task taskFromDB = taskRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
        taskFromDB.setName(task.getName());
        taskFromDB.setCompleted(task.isCompleted());
        return taskRepository.save(taskFromDB);
    }

    // Delete task
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete(@PathVariable String id) {
        Task taskFromDB = taskRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);
        taskRepository.delete(taskFromDB);
    }
}

