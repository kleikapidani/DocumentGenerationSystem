package com.documentgen.service;

import com.documentgen.exception.TemplateLanguageNotFoundException;
import com.documentgen.exception.TemplateTypeNotFoundException;
import com.documentgen.model.Template;
import com.documentgen.model.TemplateLanguage;
import com.documentgen.model.TemplateType;
import com.documentgen.repository.TemplateLanguageRepository;
import com.documentgen.repository.TemplateRepository;
import com.documentgen.repository.TemplateTypeRepository;
import com.documentgen.request.CreateTemplateRequest;
import com.documentgen.response.CreateTemplateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TemplateService {

    private final TemplateRepository templateRepository;
    private final TemplateTypeRepository templateTypeRepository;
    private final TemplateLanguageRepository templateLanguageRepository;

    @Transactional
    public CreateTemplateResponse createTemplate(CreateTemplateRequest request) {

        TemplateType templateType = templateTypeRepository.findById(request.getIdTemplateType())
                .orElseThrow(() -> new TemplateTypeNotFoundException("Template type not found"));

        TemplateLanguage templateLanguage = templateLanguageRepository.findById(request.getIdTemplateLanguage())
                .orElseThrow(() -> new TemplateLanguageNotFoundException("Template language not found"));

        Template newTemplate = new Template();
        newTemplate.setName(request.getName());
        newTemplate.setDescription(request.getDescription());
        newTemplate.setTemplateLanguage(templateLanguage);
        newTemplate.setTemplateType(templateType);

        Template addedTemplate = templateRepository.save(newTemplate);

        return CreateTemplateResponse.builder()
                .id(addedTemplate.getId())
                .name(addedTemplate.getName())
                .description(addedTemplate.getDescription())
                .createdAt(addedTemplate.getCreatedAt())
                .updatedAt(addedTemplate.getUpdatedAt())
                .createTemplateTypeResponse(
                        CreateTemplateResponse.CreateTemplateTypeResponse.builder()
                                .id(addedTemplate.getTemplateType().getId())
                                .name(addedTemplate.getTemplateType().getName())
                                .description(addedTemplate.getTemplateType().getDescription())
                                .createdAt(addedTemplate.getTemplateType().getCreatedAt())
                                .updatedAt(addedTemplate.getTemplateType().getUpdatedAt())
                                .build()
                )
                .createTemplateLanguageResponse(
                        CreateTemplateResponse.CreateTemplateLanguageResponse.builder()
                                .id(addedTemplate.getTemplateLanguage().getId())
                                .language(addedTemplate.getTemplateLanguage().getLanguage())
                                .description(addedTemplate.getTemplateLanguage().getDescription())
                                .createdAt(addedTemplate.getTemplateLanguage().getCreatedAt())
                                .updatedAt(addedTemplate.getTemplateLanguage().getUpdatedAt())
                                .build()
                )
                .build();
    }
}
