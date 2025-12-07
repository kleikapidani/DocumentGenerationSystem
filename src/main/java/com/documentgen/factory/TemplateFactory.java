package com.documentgen.factory;

import com.documentgen.model.Template;
import com.documentgen.model.TemplateLanguage;
import com.documentgen.model.TemplateType;
import com.documentgen.request.CreateTemplateRequest;
import org.springframework.stereotype.Component;

@Component
public class TemplateFactory {
    public Template convertToTemplateEntity(CreateTemplateRequest request,
                                            TemplateLanguage templateLanguage,
                                            TemplateType templateType) {

        Template newTemplate = new Template();
        newTemplate.setName(request.getName());
        newTemplate.setDescription(request.getDescription());
        newTemplate.setTemplateLanguage(templateLanguage);
        newTemplate.setTemplateType(templateType);

        return newTemplate;
    }
}
