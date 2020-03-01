package ru.webservice.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class WebClientCaller {

    public WebClientCaller() {
        super();
        init();
    }

    public void init() {
        WebClient.create("http://localhost:8080");

    }

}