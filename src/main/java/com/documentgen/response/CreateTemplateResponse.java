package com.documentgen.response;

import com.documentgen.enums.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTemplateResponse {
    private Long id;
    private String name;
    private String description;
    private Language language;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
