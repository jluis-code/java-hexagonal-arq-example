package com.arqhexagonal.tasks.infrastructure.entities;

import com.arqhexagonal.tasks.domain.models.Task;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private  String description;
    private LocalDateTime creationdate;
    private boolean completed;

    public TaskEntity() {
    }

    public TaskEntity(Long id, String title, String description, LocalDateTime creationdate, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationdate = creationdate;
        this.completed = completed;
    }

    public static TaskEntity fromDomainModel(Task task){
        return new TaskEntity(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getCreationDate(),
                task.isCompleted()
        );
    }

    public Task toDomainModel() {
        return new Task(
            this.id,
            this.title,
            this.description,
            this.creationdate,
            this.completed
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(LocalDateTime creationdate) {
        this.creationdate = creationdate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

