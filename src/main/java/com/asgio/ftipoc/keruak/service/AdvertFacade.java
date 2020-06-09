package com.asgio.ftipoc.keruak.service;

import com.asgio.ftipoc.keruak.domain.Advert;
import com.asgio.ftipoc.keruak.domain.WebAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adverts")
public class AdvertFacade {
    @Autowired
    AdvertRepo advertRepo;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Advert addAdvert(@RequestBody Advert advert) {
        System.out.println("addAdvert=" + advert.toString());
        //Advert ad = new Advert(advert.getMd5Index());
        return advertRepo.save(advert);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Advert> getAllAdverts() {
        System.out.println("getAllAdverts");
        //Advert ad = new Advert(advert.getMd5Index());

        return advertRepo.findAll();
    }

    @GetMapping(value = "/{md5Index}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Advert findAdvertByIndex(@PathVariable String md5Index) {
        System.out.println("findAdvertByIndex " + md5Index);
        return advertRepo.findBymd5Index(md5Index);
    }

    @GetMapping(value = "/{md5Index}/imageData", produces = MediaType.APPLICATION_JSON_VALUE)
    public String findImageDataByIndex(@PathVariable String md5Index) {
        System.out.println("findImageDataByIndex " + md5Index);
        return advertRepo.findBymd5Index(md5Index).getImageData();
    }

    @PostMapping("/{md5Index}/annotations")
    public Advert addAnnotation(@PathVariable String md5Index, @RequestBody WebAnnotation annotation) {
        System.out.println("addAnnotation " + md5Index);
        Optional<Advert> advert = advertRepo.findById(md5Index);
        Advert ad = null;
        if (advert.isPresent()) {
            ad = advert.get();
            ad.addAnnotation(annotation);
            advertRepo.save(ad);
        }
        return ad;
    }

    @GetMapping(value = "/{md5Index}/annotations", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<WebAnnotation> getAnnotations(@PathVariable String md5Index) {
        System.out.println("getAnnotations " + md5Index);
        return advertRepo.getOne(md5Index).getAnnotations();
    }
}
