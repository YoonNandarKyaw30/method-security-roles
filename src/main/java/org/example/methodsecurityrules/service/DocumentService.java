package org.example.methodsecurityrules.service;

import jakarta.annotation.security.RolesAllowed;
import org.example.methodsecurityrules.model.Document;
import org.example.methodsecurityrules.repository.DocumentRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepostory){
        this.documentRepository = documentRepostory;

    }
//    @PostAuthorize("hasPermission(returnObject,'ROLE_ADMIN')
//    public Document getDocument(String code){
//        return documentResposity.findDocument(code);
//    }
    @Secured("ROLE_ADMIN")
    public String getName(){
        return "Secured Method";
    }
    @RolesAllowed({"ROLES_ADMIN","ROLE_USER"})
    public String getRolesAllowed(){
        return "HELLO from Roles Allowed!";
    }
    @PreAuthorize("hasPermission(#code,'document','ROLE_ADMIN')")
    public Document getDocument(String code){
        return documentRepository.findDocument(code);

    }
}
