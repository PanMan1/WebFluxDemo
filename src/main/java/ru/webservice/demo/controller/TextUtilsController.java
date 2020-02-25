package ru.webservice.demo.controller;



import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;



import java.util.Base64;
import javax.validation.constraints.NotNull;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.webservice.demo.model.Base64Request;
import ru.webservice.demo.model.Base64Response;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


@RestController
@RequestMapping("/textUtils")
public class TextUtilsController {

    @RequestMapping(
            value = "/base64Encode",
            method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    private Mono<Base64Response> base64Encode(
            @RequestHeader(value = "Content-Type", required = true) MediaType contentType,
            @RequestHeader(value ="Message-UUID", required = false) String messageUuid,
            @RequestBody @NotNull Base64Request requestBody) throws IllegalArgumentException {
        if (!contentType.equals(MediaType.APPLICATION_JSON))
            throw new IllegalArgumentException("Content-Type header must be \"application/json\" !");
        String encodedBody = new String(Base64.getEncoder().encode(requestBody.getText().getBytes()));
        return Mono.just(new Base64Response(encodedBody));
    }
}