package com.documentgen.service;

import com.documentgen.mapper.TemplateLanguageMapper;
import com.documentgen.repository.TemplateLanguageRepository;
import com.documentgen.response.TemplateLanguageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TemplateLanguageService {

    private final TemplateLanguageRepository templateLanguageRepository;
    private final TemplateLanguageMapper templateLanguageMapper;

    public List<TemplateLanguageResponse> extractTemplateLanguageList() {
        return templateLanguageRepository.findAll()
                .stream()
                .map(templateLanguageMapper::convertToTemplateLanguageResponse)
                .toList();
    }
}
