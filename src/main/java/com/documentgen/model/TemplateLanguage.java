package com.documentgen.model;

import com.documentgen.enums.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "template_language")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TemplateLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JdbcTypeCode(value = SqlTypes.NAMED_ENUM)
    @Column(columnDefinition = "language")
    private Language language;

    private String description;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "templateLanguage", fetch = FetchType.LAZY)
    private List<Template> templates = new ArrayList<>();
}
