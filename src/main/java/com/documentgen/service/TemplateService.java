package com.documentgen.service;

import com.documentgen.exception.TemplateTypeNotFoundException;
import com.documentgen.model.Template;
import com.documentgen.model.TemplateType;
import com.documentgen.repository.TemplateRepository;
import com.documentgen.repository.TemplateTypeRepository;
import com.documentgen.request.CreateTemplateRequest;
import com.documentgen.response.CreateTemplateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TemplateService {

    private final TemplateRepository templateRepository;
    private final TemplateTypeRepository templateTypeRepository;


    public CreateTemplateResponse createTemplate(CreateTemplateRequest request) {

        TemplateType templateType = templateTypeRepository.findById(request.getIdTemplateType())
                .orElseThrow(() -> new TemplateTypeNotFoundException("Template type is not found"));

        Template newTemplate = new Template();
        newTemplate.setName(request.getName());
        newTemplate.setDescription(request.getDescription());
        newTemplate.setLanguage(request.getLanguage());
        newTemplate.setTemplateType(templateType);

        Template addedTemplate = templateRepository.save(newTemplate);

        return CreateTemplateResponse.builder()
                .id(addedTemplate.getId())
                .name(addedTemplate.getName())
                .description(addedTemplate.getDescription())
                .language(addedTemplate.getLanguage())
                .createdAt(addedTemplate.getCreatedAt())
                .updatedAt(addedTemplate.getUpdatedAt())
                .createTemplateType(
                        CreateTemplateResponse.CreateTemplateType.builder()
                                .id(addedTemplate.getTemplateType().getId())
                                .name(addedTemplate.getTemplateType().getName())
                                .description(addedTemplate.getTemplateType().getDescription())
                                .createdAt(addedTemplate.getTemplateType().getCreatedAt())
                                .updatedAt(addedTemplate.getTemplateType().getUpdatedAt())
                                .build()
                )
                .build();
    }
}
