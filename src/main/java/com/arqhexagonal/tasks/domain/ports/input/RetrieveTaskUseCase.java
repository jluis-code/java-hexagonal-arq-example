package com.arqhexagonal.tasks.domain.ports.input;

import com.arqhexagonal.tasks.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface RetrieveTaskUseCase {
    Optional<Task> getTask(Long id);
    List<Task> getAllTask();
}
