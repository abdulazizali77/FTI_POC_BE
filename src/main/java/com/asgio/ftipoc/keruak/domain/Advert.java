package com.asgio.ftipoc.keruak.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Advert {
    @Id
    private String md5Index;

    @Lob
    private String imageData;

    @OneToMany(cascade = CascadeType.ALL)
    private List<WebAnnotation> annotations = new ArrayList<>();

    public Advert() {
    }

    public Advert(String md5Index) {
        this.md5Index = md5Index;
    }

    public Advert(String md5Index, String imageData, List<WebAnnotation> annotations) {
        this.md5Index = md5Index;
        this.imageData = imageData;
        this.annotations = annotations;
    }

    public void addAnnotation(WebAnnotation annotation) {
        annotations.add(annotation);
    }

    public List<WebAnnotation> getAnnotations() {
        return annotations;
    }

    public String getMd5Index() {
        return md5Index;
    }

    public void setMd5Index(String md5Index) {
        this.md5Index = md5Index;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

//    @Override
//    public String toString() {
//        return "md5Index=" + this.md5Index.toString() + ",imageData=" + this.imageData.toString();
//    }
}
