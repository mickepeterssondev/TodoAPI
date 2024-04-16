package com.example.todoapi.repository;

import com.example.todoapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    //Some custom repository searches for use in service methods
    List<Task> findTasksByDeadline(LocalDate deadline);
    List<Task> findTasksByFinished(boolean finished);
    List<Task> findTasksByImportant(boolean important);
}
