package com.arqhexagonal.tasks.application.usecases;

import com.arqhexagonal.tasks.domain.models.Task;
import com.arqhexagonal.tasks.domain.ports.input.UpdateTaskUseCase;
import com.arqhexagonal.tasks.domain.ports.output.TaskRepositoryPort;

import java.util.Optional;

public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public UpdateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        return taskRepositoryPort.update(updateTask);
    }
}
