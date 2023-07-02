package com.wagner.todolist.repositories;

import com.wagner.todolist.models.TodoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<TodoUser, Long> {
    @Modifying
    @Query("UPDATE TodoUser u SET u.status = true WHERE u.id = :id")
    void deleteStatus(Long id);

}
