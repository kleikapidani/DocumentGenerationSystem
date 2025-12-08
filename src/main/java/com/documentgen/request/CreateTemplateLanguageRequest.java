package com.documentgen.request;

import com.documentgen.enums.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTemplateLanguageRequest {
    private Language language;
    private String description;
}
