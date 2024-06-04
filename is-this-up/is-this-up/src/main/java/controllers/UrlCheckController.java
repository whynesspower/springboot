package controllers;

import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UrlCheckController {

    private final String IS_SITE_UP="Site is up";
    private final String SIDE_IS_DOWN= "Site is down :(";
    private final String INCORRECT_URL= "Url is not correct";

    @GetMapping("/check")
    public String getUrlStatusMessage(@RequestParam String urlString) {
        String returnMessage="";
        try {
            URL urlObject= new URL(urlString);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return returnMessage;
    }
}
