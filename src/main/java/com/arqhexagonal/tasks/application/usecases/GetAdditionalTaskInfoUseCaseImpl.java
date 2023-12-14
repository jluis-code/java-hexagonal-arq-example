package com.arqhexagonal.tasks.application.usecases;

import com.arqhexagonal.tasks.domain.models.AdditionalTaskInfo;
import com.arqhexagonal.tasks.domain.ports.input.GetAdditionalTaskInfoUseCase;
import com.arqhexagonal.tasks.domain.ports.output.ExternalServicePort;
import com.arqhexagonal.tasks.domain.ports.output.TaskRepositoryPort;

public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {
    private final ExternalServicePort externalServicePort;

    public GetAdditionalTaskInfoUseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return externalServicePort.getAdditionalTaskInfo(id);
    }
}
