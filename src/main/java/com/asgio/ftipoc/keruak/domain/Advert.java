package com.asgio.ftipoc.keruak.domain;

import jdk.jfr.events.ExceptionThrownEvent;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Entity
public class Advert {
    @Id
    private String md5Index;

    @Lob
    private Blob imageData;

    @OneToMany(cascade = CascadeType.ALL)
    private List<WebAnnotation> annotations = new ArrayList<>();

    public Advert() {
        System.out.println("Advert construct 1");
    }

    public Advert(String md5Index) {
        System.out.println("Advert construct 2");
        this.md5Index = md5Index;
    }

    public Advert(String md5Index, Blob imageData, List<WebAnnotation> annotations) {
        System.out.println("Advert construct 3");
        this.md5Index = md5Index;
        this.imageData = imageData;
        this.annotations = annotations;
    }

    public void addAnnotation(WebAnnotation annotation) {
        System.out.println("Advert addAnnotation");
        annotations.add(annotation);
    }

    public void setAnnotation(WebAnnotation annotation) {
        System.out.println("Advert setAnnotation");
        annotations.add(annotation);
    }

    public List<WebAnnotation> getAnnotations() {
        return annotations;
    }

    public String getMd5Index() {
        return md5Index;
    }

    public void setMd5Index(String md5Index) {
        System.out.println("Advert setMd5Index "+md5Index);
        this.md5Index = md5Index;
    }

    public Blob getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        byte[] bs = Base64.getDecoder().decode(imageData);
        System.out.println("setImageData "
                + "bs.length=" + bs.length);
        //+ "\n" + imageData);
        try {
            Blob blob = new SerialBlob(bs);
            this.imageData = blob;
        } catch (Exception e) {
            //TODO: address
            e.printStackTrace();
        }
    }

//    @Override
//    public String toString() {
//        return "md5Index=" + this.md5Index.toString() + ",imageData=" + this.imageData.toString();
//    }
}
