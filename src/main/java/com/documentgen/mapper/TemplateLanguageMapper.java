package com.documentgen.mapper;

import com.documentgen.model.TemplateLanguage;
import com.documentgen.response.TemplateLanguageResponse;
import org.springframework.stereotype.Component;

@Component
public class TemplateLanguageMapper {
    public TemplateLanguageResponse convertToTemplateLanguageResponse(TemplateLanguage templateLanguage) {
        return TemplateLanguageResponse.builder()
                .id(templateLanguage.getId())
                .language(templateLanguage.getLanguage())
                .description(templateLanguage.getDescription())
                .build();
    }
}
