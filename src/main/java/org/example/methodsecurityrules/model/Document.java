package org.example.methodsecurityrules.model;

import java.util.Objects;

public class Document {
    private String owner;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Document document)) return false;
        return Objects.equals(getOwner(), document.getOwner());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOwner());
    }

    public Document(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}

