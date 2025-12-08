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
import com.documentgen.request.TemplateFilterRequest;
import com.documentgen.response.CreateTemplateResponse;
import com.documentgen.response.TemplateFilterResponse;
import com.documentgen.specification.TemplateSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
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

    public TemplateFilterResponse extractAllByFilterAndPagination(TemplateFilterRequest request,
                                                                  int page,
                                                                  int size,
                                                                  String direction,
                                                                  String sortBy) {

        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);

        Pageable pageable = PageRequest.of(page, size, sort);

        Specification<Template> templateFilter = Specification.allOf(
                TemplateSpecification.hasName(request.getName()),
                TemplateSpecification.hasDescription(request.getDescription()),
                TemplateSpecification.hasLanguage(request.getLanguage())
        );

        Page<Template> result = templateRepository.findAll(templateFilter, pageable);

        return templateMapper.convertToTemplateFilterResponse(result);
    }
}
