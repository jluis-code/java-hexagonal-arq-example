package com.arqhexagonal.tasks.infrastructure.repositories;

import com.arqhexagonal.tasks.infrastructure.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> {
}
