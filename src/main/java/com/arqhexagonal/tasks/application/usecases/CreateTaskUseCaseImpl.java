package com.arqhexagonal.tasks.application.usecases;

import com.arqhexagonal.tasks.domain.models.Task;
import com.arqhexagonal.tasks.domain.ports.input.CreateTaskUseCase;
import com.arqhexagonal.tasks.domain.ports.output.TaskRepositoryPort;

public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public CreateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepositoryPort.save(task);
    }
}
