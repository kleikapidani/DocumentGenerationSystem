package com.documentgen.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTemplateSectionResponse {
    private Long id;
    private String name;
    private String description;
    private Integer orderIndex;
}
