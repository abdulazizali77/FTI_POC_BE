package com.asgio.ftipoc.keruak;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileReader;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootTest

class KeruakApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testMd5() throws NoSuchAlgorithmException {
        try {
            MessageDigest.getInstance("MD5");
            MessageDigest md = MessageDigest.getInstance("MD5");

            FileReader imageFile = new FileReader("file:///d:\\1.png");

            String string1 = "Hello World";
            String string2 = "a";


            md.update(string1.getBytes());
            byte[] string1Digest = md.digest();
            System.out.println(string1Digest);

            md.update(string2.getBytes());
            byte[] string2Digest = md.digest();
            System.out.println(string2Digest);

            md.update(imageFile.toString().getBytes());
            byte[] fileDigest = md.digest();
            System.out.println(fileDigest);
        } catch (Exception e) {

        }

    }
}
