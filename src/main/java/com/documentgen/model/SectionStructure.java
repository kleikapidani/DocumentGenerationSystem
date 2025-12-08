package com.documentgen.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section_structure")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectionStructure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_index")
    private Integer orderIndex;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Section.class)
    @JoinColumn(name = "id_section")
    private List<Section> sections = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_structure_type")
    private SectionStructureList sectionStructureList;
}
