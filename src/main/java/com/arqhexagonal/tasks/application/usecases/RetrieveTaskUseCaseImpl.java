package com.arqhexagonal.tasks.application.usecases;

import com.arqhexagonal.tasks.domain.models.Task;
import com.arqhexagonal.tasks.domain.ports.input.RetrieveTaskUseCase;
import com.arqhexagonal.tasks.domain.ports.output.TaskRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveTaskUseCaseImpl implements RetrieveTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public RetrieveTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return taskRepositoryPort.findById(id);
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepositoryPort.findAll();
    }
}
