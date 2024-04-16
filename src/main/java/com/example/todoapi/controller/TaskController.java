package com.example.todoapi.controller;

import com.example.todoapi.model.Task;
import com.example.todoapi.repository.TaskRepository;
import com.example.todoapi.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private final TaskService taskService;

    @Autowired
    private final TaskRepository taskRepository;

    @GetMapping("/all")
    public List<Task> getAll(){
        return taskService.getAllTasks();
    }

    @GetMapping("/finished/{status}")
    public List<Task> getByFinished(@PathVariable boolean status){
        return taskService.getByFinished(status);
    }

    @GetMapping("/important/{status}")
    public List<Task> getByImportant(@PathVariable boolean status){
        return taskService.getByImportant(status);
    }

    @GetMapping("/deadline/{deadline}")
    public List<Task> getByDeadline(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate deadline){
        return taskService.getByDeadline(deadline);
    }

    @PostMapping ("/new")
    public ResponseEntity<Task> addNewTask(@RequestBody Task task){
        Task newTask = taskService.createTask(task);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    @PutMapping ("/update/")
    public ResponseEntity<Task> updateTask(@RequestBody Task task){
        Task updatedTask = taskService.updateTask(task);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }


}
