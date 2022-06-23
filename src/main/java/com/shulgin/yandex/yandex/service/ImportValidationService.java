package com.shulgin.yandex.yandex.service;

import com.shulgin.yandex.yandex.dto.Imports;
import org.springframework.stereotype.Service;

@Service
public interface ImportValidationService {
    boolean isValidImportsData(Imports data);
}
