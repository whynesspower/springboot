package controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UrlCheckController {

    @GetMapping("/check")
    public String getUrlStatusMessage(@RequestParam String urlString) {
        return new String();
    }
}
