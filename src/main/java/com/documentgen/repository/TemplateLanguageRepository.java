package com.documentgen.repository;

import com.documentgen.model.TemplateLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateLanguageRepository extends JpaRepository<TemplateLanguage, Long> {
}
