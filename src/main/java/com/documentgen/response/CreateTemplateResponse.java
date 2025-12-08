package com.documentgen.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTemplateResponse {
    private Long id;
    private String name;
    private String description;
    private TemplateTypeResponse templateTypeResponse;
    private TemplateLanguageResponse templateLanguageResponse;
}
