package com.documentgen.mapper;

import com.documentgen.model.Template;
import com.documentgen.response.CreateTemplateResponse;
import com.documentgen.response.TemplateLanguageResponse;
import com.documentgen.response.TemplateTypeResponse;
import org.springframework.stereotype.Component;

@Component
public class TemplateMapper {
    public CreateTemplateResponse convertToCreateTemplateResponse(Template addedTemplate) {
        return CreateTemplateResponse.builder()
                .id(addedTemplate.getId())
                .name(addedTemplate.getName())
                .description(addedTemplate.getDescription())
                .createdAt(addedTemplate.getCreatedAt())
                .updatedAt(addedTemplate.getUpdatedAt())
                .templateTypeResponse(
                        TemplateTypeResponse.builder()
                                .id(addedTemplate.getTemplateType().getId())
                                .name(addedTemplate.getTemplateType().getName())
                                .description(addedTemplate.getTemplateType().getDescription())
                                .build()
                )
                .templateLanguageResponse(
                        TemplateLanguageResponse.builder()
                                .id(addedTemplate.getTemplateLanguage().getId())
                                .language(addedTemplate.getTemplateLanguage().getLanguage())
                                .description(addedTemplate.getTemplateLanguage().getDescription())
                                .build()
                )
                .build();
    }
}
