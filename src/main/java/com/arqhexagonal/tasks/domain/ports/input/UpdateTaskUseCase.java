package com.arqhexagonal.tasks.domain.ports.input;

import com.arqhexagonal.tasks.domain.models.Task;

import java.util.Optional;

public interface UpdateTaskUseCase {
    Optional<Task> updateTask(Long id, Task updateTask);
}
