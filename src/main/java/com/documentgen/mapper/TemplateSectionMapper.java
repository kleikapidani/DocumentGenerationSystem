package com.documentgen.mapper;

import com.documentgen.model.Section;
import com.documentgen.response.CreateTemplateSectionResponse;
import org.springframework.stereotype.Component;

@Component
public class TemplateSectionMapper {
    public CreateTemplateSectionResponse convertToCreateTemplateSectionResponse(Section section) {

        return CreateTemplateSectionResponse.builder()
                .id(section.getId())
                .name(section.getName())
                .description(section.getDescription())
                .orderIndex(section.getOrderIndex())
                .build();
    }
}
