package ru.webservice.demo;

import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/compress")
public class CompressionController {

    @PostMapping("/test")
    private Mono<String> getBookByIsbn() {

        Mono<String> just = Mono.just("bla");

        return just;
    }
}