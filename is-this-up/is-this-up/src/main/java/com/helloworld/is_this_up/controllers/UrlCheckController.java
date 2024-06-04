package com.helloworld.is_this_up.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UrlCheckController {

    private final String SITE_IS_UP="Site is up";
    private final String SITE_IS_DOWN= "Site is down :(";
    private final String INCORRECT_URL= "Url is not correct";

    @GetMapping("/check")
    public String getUrlStatusMessage(@RequestParam String url) {
        String returnMessage="";
        try {
            URL urlObject= new URL(url);
            HttpsURLConnection conn = (HttpsURLConnection) urlObject.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCodeCategory= conn.getResponseCode()/100;
            System.out.println("code is " + responseCodeCategory);
            if((responseCodeCategory !=2) && (responseCodeCategory !=3) ){
                System.out.println("if ran");
                returnMessage= SITE_IS_DOWN;
            } else{
                System.out.println("else ran");
                returnMessage= SITE_IS_UP;
            }            
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            returnMessage = INCORRECT_URL;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            returnMessage = SITE_IS_DOWN;
        }

        return returnMessage;
    }
}
