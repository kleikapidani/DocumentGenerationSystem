package com.documentgen.service;

import com.documentgen.factory.TemplateTypeFactory;
import com.documentgen.mapper.TemplateTypeMapper;
import com.documentgen.model.TemplateType;
import com.documentgen.repository.TemplateTypeRepository;
import com.documentgen.request.CreateTemplateTypeRequest;
import com.documentgen.response.TemplateTypeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TemplateTypeService {

    private final TemplateTypeRepository templateTypeRepository;
    private final TemplateTypeMapper templateTypeMapper;
    private final TemplateTypeFactory templateTypeFactory;

    public List<TemplateTypeResponse> extractTemplateTypeList() {

        return templateTypeRepository.findAll()
                .stream()
                .map(templateTypeMapper::convertToTemplateTypeResponse)
                .toList();
    }

    public TemplateTypeResponse createTemplateType(CreateTemplateTypeRequest request) {

        TemplateType templateType = templateTypeFactory.convertToTemplateTypeEntity(request);

        TemplateType addedTemplateType = templateTypeRepository.save(templateType);

        return templateTypeMapper.convertToTemplateTypeResponse(addedTemplateType);
    }
}
