package com.example.todoapi.service;

import com.example.todoapi.model.Task;
import com.example.todoapi.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

//Simple serviceClass to illustrate service method implementation via Interface

@Service
public class TaskService implements TaskServiceInterface {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getByDeadline(LocalDate deadline) {
        return taskRepository.findTasksByDeadline(deadline);
    }

    @Override
    public List<Task> getByFinished(boolean finished) {
        return taskRepository.findTasksByFinished(finished);
    }

    @Override
    public List<Task> getByImportant(boolean important) {
        return taskRepository.findTasksByImportant(important);
    }

    @Override
    public Task createTask(Task t) {
       return taskRepository.save(t);
    }

    @Override
    public Task updateTask(Task t) {
        Task taskToUpdate = taskRepository.findById(t.getId()).orElseThrow(() -> new RuntimeException("Couldn't find task"));
        taskToUpdate.setDeadline(t.getDeadline());
        taskToUpdate.setContent(t.getContent());
        taskToUpdate.setFinished(t.isFinished());
        taskToUpdate.setImportant(t.isImportant());
        taskRepository.save(taskToUpdate);
        return taskToUpdate;

    }

    @Override
    public void deleteTask(Task t) {
        taskRepository.deleteById(t.getId());
    }
}
