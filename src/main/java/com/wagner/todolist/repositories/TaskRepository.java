package com.wagner.todolist.repositories;

import com.wagner.todolist.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser_Id(Long id);

    @Modifying
    @Query("UPDATE Task t SET t.status = true WHERE t.id = :id")
    void deleteStatus(Long id);

}
