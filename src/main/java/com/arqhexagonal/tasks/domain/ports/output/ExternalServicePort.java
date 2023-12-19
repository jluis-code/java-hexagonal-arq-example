package com.arqhexagonal.tasks.domain.ports.output;

import com.arqhexagonal.tasks.domain.models.AdditionalTaskInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface ExternalServicePort {
    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);

}
