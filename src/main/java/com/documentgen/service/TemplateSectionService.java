package com.documentgen.service;

import com.documentgen.exception.TemplateNotFoundException;
import com.documentgen.factory.TemplateSectionFactory;
import com.documentgen.mapper.TemplateSectionMapper;
import com.documentgen.model.Section;
import com.documentgen.model.Template;
import com.documentgen.repository.TemplateRepository;
import com.documentgen.repository.TemplateSectionRepository;
import com.documentgen.request.CreateTemplateSectionRequest;
import com.documentgen.response.CreateTemplateSectionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TemplateSectionService {

    private final TemplateRepository templateRepository;
    private final TemplateSectionRepository templateSectionRepository;
    private final TemplateSectionFactory templateSectionFactory;
    private final TemplateSectionMapper templateSectionMapper;

    @Transactional
    public CreateTemplateSectionResponse createTemplateSection(CreateTemplateSectionRequest request) {

        Template template = templateRepository.findById(request.getIdTemplate())
                .orElseThrow(() -> new TemplateNotFoundException("Template not found"));

        long countSections = templateSectionRepository.count();

        Section section = templateSectionFactory.convertToSectionEntity(request, template, countSections);

        Section addedSection = templateSectionRepository.save(section);

        return templateSectionMapper.convertToCreateTemplateSectionResponse(addedSection);
    }
}
