package com.wagner.todolist.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = Task.TABLE_NAME)
public class Task extends AbstractLog {
    public static final String TABLE_NAME = "task";


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private TodoUser user;

    @Column(name = "description", length = 255, nullable = false)
    private String description;

    public Task() {

    }
    public Task(TodoUser user, String description) {
        this.user = user;
        this.description = description;
    }

    public TodoUser getUser() {
        return user;
    }

    public void setUser(TodoUser user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return Objects.equals(getId(), task.getId()) && Objects.equals(getUser(), task.getUser()) && Objects.equals(getDescription(), task.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getDescription());
    }
}
