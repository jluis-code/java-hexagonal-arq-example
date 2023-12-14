package com.arqhexagonal.tasks.domain.ports.input;

import com.arqhexagonal.tasks.domain.models.Task;

public interface CreateTaskUseCase {
    Task createTask(Task task);
}
