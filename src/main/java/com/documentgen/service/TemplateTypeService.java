package com.documentgen.service;

import com.documentgen.mapper.TemplateTypeMapper;
import com.documentgen.repository.TemplateTypeRepository;
import com.documentgen.response.TemplateTypeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TemplateTypeService {

    private final TemplateTypeRepository templateTypeRepository;
    private final TemplateTypeMapper templateTypeMapper;

    public List<TemplateTypeResponse> extractTemplateTypeList() {
        return templateTypeRepository.findAll()
                .stream()
                .map(templateTypeMapper::convertToTemplateTypeResponse)
                .toList();
    }
}
