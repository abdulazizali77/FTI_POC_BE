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
        System.out.println("WebAnnotation construct 0");
    }

    public WebAnnotation(String annotationContent ) {
        System.out.println("WebAnnotation construct 1 "+annotationContent);
        this.annotationContent = annotationContent;
    }

    public WebAnnotation(Date entryAdded) {
        System.out.println("WebAnnotation construct 2");
        this.entryAdded = entryAdded;
    }

    public WebAnnotation(Date entryAdded, String annotationContent) {
        System.out.println("WebAnnotation construct 3");
        this.entryAdded = entryAdded;
        this.annotationContent = annotationContent;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        System.out.println("WebAnnotation setId " + id);
        this.id = id;
    }

    public Date getEntryAdded() {
        return entryAdded;
    }

    public void setEntryAdded(Date entryAdded) {
        System.out.println("WebAnnotation setEntryAdded " + entryAdded);
        this.entryAdded = entryAdded;
    }

    public Date getEntryEdited() {
        return entryEdited;
    }

    public void setEntryEdited(Date entryEdited) {
        System.out.println("WebAnnotation setEntryEdited " + entryEdited);
        this.entryEdited = entryEdited;
    }

    public String getAnnotationContent() {
        return annotationContent;
    }

    public void setAnnotationContent(String annotationContent) {
        System.out.println("WebAnnotation setAnnotationContent " + annotationContent);
        this.annotationContent = annotationContent;
    }
}
