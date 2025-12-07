package com.documentgen.mapper;

import com.documentgen.model.TemplateType;
import com.documentgen.response.TemplateTypeResponse;
import org.springframework.stereotype.Component;

@Component
public class TemplateTypeMapper {
    public TemplateTypeResponse convertToTemplateTypeResponse(TemplateType templateType) {
        return TemplateTypeResponse.builder()
                .id(templateType.getId())
                .name(templateType.getName())
                .description(templateType.getDescription())
                .build();
    }
}
