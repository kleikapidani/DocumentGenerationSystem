package com.documentgen.response;

import com.documentgen.enums.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTemplateResponse {
    private Long id;
    private String name;
    private String description;
    private Language language;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private CreateTemplateTypeResponse createTemplateTypeResponse;
    private CreateTemplateLanguageResponse createTemplateLanguageResponse;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class CreateTemplateTypeResponse {
        private Long id;
        private String name;
        private String description;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class CreateTemplateLanguageResponse {
        private Long id;
        private Language language;
        private String description;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }
}
