package com.documentgen.request;

import com.documentgen.enums.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemplateFilterRequest {
    private String name;
    private String description;
    private Language language;
}
