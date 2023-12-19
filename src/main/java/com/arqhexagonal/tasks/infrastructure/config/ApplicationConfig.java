package com.arqhexagonal.tasks.infrastructure.config;

import com.arqhexagonal.tasks.application.services.TaskService;
import com.arqhexagonal.tasks.application.usecases.*;
import com.arqhexagonal.tasks.domain.ports.input.GetAdditionalTaskInfoUseCase;
import com.arqhexagonal.tasks.domain.ports.output.ExternalServicePort;
import com.arqhexagonal.tasks.domain.ports.output.TaskRepositoryPort;
import com.arqhexagonal.tasks.infrastructure.adapters.ExternalServiceAdapter;
import com.arqhexagonal.tasks.infrastructure.repositories.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase){
        return new TaskService(
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new RetrieveTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort),
                getAdditionalTaskInfoUseCase,
                new DeleteTaskUseCaseImpl(taskRepositoryPort)
        );
    }
    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort) {
        return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort() {
        return new ExternalServiceAdapter();
    }
}
