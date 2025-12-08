package com.documentgen.factory;

import com.documentgen.model.TemplateLanguage;
import com.documentgen.request.CreateTemplateLanguageRequest;
import org.springframework.stereotype.Component;

@Component
public class TemplateLanguageFactory {
    public TemplateLanguage convertToTemplateLanguageEntity(CreateTemplateLanguageRequest request) {

        TemplateLanguage templateLanguage = new TemplateLanguage();
        templateLanguage.setLanguage(request.getLanguage());
        templateLanguage.setDescription(request.getDescription());

        return templateLanguage;
    }
}
