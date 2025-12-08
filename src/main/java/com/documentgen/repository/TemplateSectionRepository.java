package com.documentgen.repository;

import com.documentgen.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateSectionRepository extends JpaRepository<Section, Long> {
}
