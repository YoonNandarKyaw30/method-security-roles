package org.example.methodsecurityrules.security;

import org.example.methodsecurityrules.model.Document;
import org.example.methodsecurityrules.repository.DocumentRepository;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.io.Serializable;
import java.io.StringReader;

@Component
public class DocumentPermissionEvaluator implements PermissionEvaluator {
    private final DocumentRepository documentRepository;

    public DocumentPermissionEvaluator(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
//        Document document= (Document) targetDomainObject;
//        String p= (String) permission;
//        boolean admin= authentication.getAuthorities()
//                .stream()
//                .anyMatch(a -> a.getAuthority().equals(p));
//        return admin || document.getOwner().equals(authentication.getName());
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        String code = targetId.toString();
        Document document = documentRepository.findDocument(code);
        String p = (String)permission;
        boolean admin = authentication
                .getAuthorities()
                .stream()
                .anyMatch(a -> a.getAuthority().equals(p));
        return false;
    }

}
