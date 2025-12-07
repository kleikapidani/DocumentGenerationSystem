package com.documentgen.response;

import com.documentgen.enums.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TemplateLanguageResponse {
    private Long id;
    private Language language;
    private String description;
}
