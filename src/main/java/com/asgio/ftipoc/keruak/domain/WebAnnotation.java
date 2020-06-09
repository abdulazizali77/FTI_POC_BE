package com.asgio.ftipoc.keruak.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
public class WebAnnotation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Date entryAdded;
    private Date entryEdited;
    private String annotationContent;

    public WebAnnotation() {

    }

    public WebAnnotation(Date entryAdded, String annotationContent) {
        this.entryAdded = entryAdded;
        this.annotationContent = annotationContent;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getEntryAdded() {
        return entryAdded;
    }

    public void setEntryAdded(Date entryAdded) {
        this.entryAdded = entryAdded;
    }

    public Date getEntryEdited() {
        return entryEdited;
    }

    public void setEntryEdited(Date entryEdited) {
        this.entryEdited = entryEdited;
    }

    public String getAnnotationContent() {
        return annotationContent;
    }

    public void setAnnotationContent(String annotationContent) {
        this.annotationContent = annotationContent;
    }
}
