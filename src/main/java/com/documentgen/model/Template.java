package com.documentgen.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "template")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_template_type")
    private TemplateType templateType;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_template_language")
    private TemplateLanguage templateLanguage;

    @OneToMany(mappedBy = "template", fetch = FetchType.EAGER)
    private List<Section> sections = new ArrayList<>();
}
