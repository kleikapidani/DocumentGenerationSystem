package com.documentgen.specification;

import com.documentgen.enums.Language;
import com.documentgen.model.Template;
import org.springframework.data.jpa.domain.Specification;

public class TemplateSpecification {

    public static Specification<Template> hasName(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name == null)
                return null;

            return criteriaBuilder.equal(criteriaBuilder.lower(root.get("name")), name.toLowerCase());
        };
    }

    public static Specification<Template> hasDescription(String description) {
        return (root, query, criteriaBuilder) -> {
            if (description == null)
                return null;

            return criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), "%" + description.toLowerCase() + "%");
        };
    }

    public static Specification<Template> hasLanguage(Language language) {
        return (root, query, criteriaBuilder) -> {
            if (language == null)
                return null;

            return criteriaBuilder.equal(root.get("language"), language);
        };
    }
}
