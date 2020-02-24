package ru.webservice.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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