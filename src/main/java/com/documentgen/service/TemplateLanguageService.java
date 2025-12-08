package com.documentgen.service;

import com.documentgen.factory.TemplateLanguageFactory;
import com.documentgen.mapper.TemplateLanguageMapper;
import com.documentgen.model.TemplateLanguage;
import com.documentgen.repository.TemplateLanguageRepository;
import com.documentgen.request.CreateTemplateLanguageRequest;
import com.documentgen.response.TemplateLanguageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TemplateLanguageService {

    private final TemplateLanguageRepository templateLanguageRepository;
    private final TemplateLanguageMapper templateLanguageMapper;
    private final TemplateLanguageFactory templateLanguageFactory;

    public List<TemplateLanguageResponse> extractTemplateLanguageList() {

        return templateLanguageRepository.findAll()
                .stream()
                .map(templateLanguageMapper::convertToTemplateLanguageResponse)
                .toList();
    }

    public TemplateLanguageResponse createTemplateLanguage(CreateTemplateLanguageRequest request) {

        TemplateLanguage templateLanguage = templateLanguageFactory.convertToTemplateLanguageEntity(request);
        TemplateLanguage addedTemplateLanguage = templateLanguageRepository.save(templateLanguage);

        return templateLanguageMapper.convertToTemplateLanguageResponse(addedTemplateLanguage);
    }
}
