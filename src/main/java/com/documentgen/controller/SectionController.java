package com.documentgen.controller;

import com.documentgen.request.CreateTemplateSectionRequest;
import com.documentgen.response.CreateTemplateSectionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/template/section")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SectionController {

    @PostMapping(value = "/create")
    public ResponseEntity<CreateTemplateSectionResponse> createTemplateSection(@RequestBody CreateTemplateSectionRequest request) {

    }
}
