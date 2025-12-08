package com.documentgen.mapper;

import com.documentgen.model.Template;
import com.documentgen.response.*;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class TemplateMapper {

    public CreateTemplateResponse convertToCreateTemplateResponse(Template addedTemplate) {

        return CreateTemplateResponse.builder()
                .id(addedTemplate.getId())
                .name(addedTemplate.getName())
                .description(addedTemplate.getDescription())
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

    public TemplateFilterResponse convertToTemplateFilterResponse(Page<Template> result) {

        return TemplateFilterResponse.builder()
                .templates(result.getContent()
                        .stream()
                        .map(this::convertToCreateTemplateResponse)
                        .toList())
                .paginationResponse(PaginationResponse.builder()
                        .size(result.getSize())
                        .number(result.getNumber())
                        .totalPages(result.getTotalPages())
                        .totalElements(result.getTotalElements())
                        .isFirst(result.isFirst())
                        .isLast(result.isLast())
                        .build())
                .build();
    }
}
