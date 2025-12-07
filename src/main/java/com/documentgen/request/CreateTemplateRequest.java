package com.documentgen.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTemplateRequest {
    private String name;
    private String description;
    private Long idTemplateLanguage;
    private Long idTemplateType;
}
