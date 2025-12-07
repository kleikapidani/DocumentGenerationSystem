package com.documentgen.service;

import com.documentgen.exception.TemplateLanguageNotFoundException;
import com.documentgen.exception.TemplateTypeNotFoundException;
import com.documentgen.factory.TemplateFactory;
import com.documentgen.mapper.TemplateMapper;
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
    private final TemplateMapper templateMapper;
    private final TemplateFactory templateFactory;

    @Transactional
    public CreateTemplateResponse createTemplate(CreateTemplateRequest request) {

        TemplateType templateType = templateTypeRepository.findById(request.getIdTemplateType())
                .orElseThrow(() -> new TemplateTypeNotFoundException("Template type not found"));

        TemplateLanguage templateLanguage = templateLanguageRepository.findById(request.getIdTemplateLanguage())
                .orElseThrow(() -> new TemplateLanguageNotFoundException("Template language not found"));

        Template newTemplate = templateFactory.convertToTemplateEntity(request, templateLanguage, templateType);

        Template addedTemplate = templateRepository.save(newTemplate);

        return templateMapper.convertToCreateTemplateResponse(addedTemplate);
    }
}
