package com.documentgen.factory;

import com.documentgen.model.Section;
import com.documentgen.model.Template;
import com.documentgen.request.CreateTemplateSectionRequest;
import org.springframework.stereotype.Component;

@Component
public class TemplateSectionFactory {
    public Section convertToSectionEntity(CreateTemplateSectionRequest request, Template template, long countSections) {

        Section section = new Section();
        section.setName(request.getName());
        section.setDescription(request.getDescription());
        section.setOrderIndex(countSections == 0 ? 1 : (int) countSections);
        section.setTemplate(template);

        return section;
    }
}
