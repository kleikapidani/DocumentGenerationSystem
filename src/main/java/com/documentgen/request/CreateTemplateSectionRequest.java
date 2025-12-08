package com.documentgen.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTemplateSectionRequest {
    private String name;
    private String description;
    private Long idTemplate;
}
