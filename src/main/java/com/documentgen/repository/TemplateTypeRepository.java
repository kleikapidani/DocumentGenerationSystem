package com.documentgen.repository;

import com.documentgen.model.TemplateType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateTypeRepository extends JpaRepository<TemplateType, Long> {
}
