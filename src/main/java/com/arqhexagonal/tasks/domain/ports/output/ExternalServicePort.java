package com.arqhexagonal.tasks.domain.ports.output;

import com.arqhexagonal.tasks.domain.models.AdditionalTaskInfo;

public interface ExternalServicePort {
    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);

}
