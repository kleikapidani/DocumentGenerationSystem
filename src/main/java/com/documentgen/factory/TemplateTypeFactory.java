package com.documentgen.factory;

import com.documentgen.model.TemplateType;
import com.documentgen.request.CreateTemplateTypeRequest;
import org.springframework.stereotype.Component;

@Component
public class TemplateTypeFactory {
    public TemplateType convertToTemplateTypeEntity(CreateTemplateTypeRequest request) {

        TemplateType templateType = new TemplateType();
        templateType.setName(request.getName());
        templateType.setDescription(request.getDescription());

        return templateType;
    }
}
