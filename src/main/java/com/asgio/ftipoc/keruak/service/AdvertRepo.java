package com.asgio.ftipoc.keruak.service;


import com.asgio.ftipoc.keruak.domain.Advert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertRepo extends JpaRepository<Advert, String>{
    Advert findBymd5Index(String md5Index);

    Advert findByImageData(String imageData);
}
