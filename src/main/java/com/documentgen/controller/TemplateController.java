package com.documentgen.controller;

import com.documentgen.request.CreateTemplateRequest;
import com.documentgen.request.TemplateFilterRequest;
import com.documentgen.response.CreateTemplateResponse;
import com.documentgen.response.TemplateFilterResponse;
import com.documentgen.service.TemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/template")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TemplateController {

    private final TemplateService templateService;

    @PostMapping(value = "/create")
    public ResponseEntity<CreateTemplateResponse> createTemplate(@RequestBody CreateTemplateRequest request) {
        CreateTemplateResponse response = templateService.createTemplate(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping(value = "/filter")
    public ResponseEntity<TemplateFilterResponse> filterTemplates(@RequestBody(required = false) TemplateFilterRequest request,
                                                                  @RequestParam(defaultValue = "0") int page,
                                                                  @RequestParam(defaultValue = "5") int size,
                                                                  @RequestParam(defaultValue = "ASC") String direction,
                                                                  @RequestParam(defaultValue = "name") String sortBy) {

        TemplateFilterResponse response = templateService.extractAllByFilterAndPagination(request, page, size, direction, sortBy);
        return ResponseEntity.ok(response);
    }
}
