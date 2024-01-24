package org.example.methodsecurityrules.controller;

import org.example.methodsecurityrules.model.Document;
import org.example.methodsecurityrules.service.DocumentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.print.Doc;

@RestController
public class DocumentController {
    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/documents/{code}")
    public Document getDetails(@PathVariable String code){
        return documentService.getDocument(code);
    }
    @GetMapping("/secured")
    public String getSecuredMethod(){
        return documentService.getName();
    }
    @GetMapping("/roles-allowed")
    public String getRolesAllowedMethod(){
        return documentService.getRolesAllowed();
    }
}
