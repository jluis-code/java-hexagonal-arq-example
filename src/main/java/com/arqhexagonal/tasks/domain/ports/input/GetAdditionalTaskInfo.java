package com.arqhexagonal.tasks.domain.ports.input;

import com.arqhexagonal.tasks.domain.models.AdditionalTaskInfo;

public interface GetAdditionalTaskInfo {
    AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}
