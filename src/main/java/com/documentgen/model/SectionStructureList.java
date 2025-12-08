package com.documentgen.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section_structure_list")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectionStructureList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String tag;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "sectionStructureList", fetch = FetchType.EAGER)
    private List<SectionStructure> sectionStructure = new ArrayList<>();
}
