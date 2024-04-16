package com.example.todoapi.service;


import com.example.todoapi.model.Task;

import java.time.LocalDate;
import java.util.List;

//Interface for loose coupling CRUD

public interface TaskServiceInterface {

    //Gets
    List<Task> getAllTasks();
    List<Task> getByDeadline(LocalDate deadline);
    List<Task> getByFinished(boolean finished);
    List<Task> getByImportant(boolean important);

    //POST
    Task createTask(Task t);

    //PUT
    Task updateTask(Task t);

    //DELETE
    void deleteTask(Task t);

}
