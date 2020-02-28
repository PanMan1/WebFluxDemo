package ru.webservice.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import ru.webservice.demo.model.Base64Request;
import ru.webservice.demo.model.Base64Response;

import javax.validation.constraints.NotNull;
import java.util.Base64;
import java.util.concurrent.atomic.AtomicReference;


@RestController
@RequestMapping("/textUtils")
public class TextUtilsController {

    @RequestMapping(
            value = "/base64Encode",
            method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    private Mono<ResponseEntity<Base64Response>> base64Encode(
            @RequestHeader(value = "Message-UUID") String messageUuid,
            @RequestBody @NotNull Base64Request requestBody) {
        AtomicReference<String> bodyMsg =
                new AtomicReference<>(new String(Base64.getEncoder().encode(requestBody.getMessage().getBytes())));
        return Mono.just(ResponseEntity.ok().header("Message-UUID", messageUuid).body(new Base64Response(bodyMsg)));
    }

    // TODO: 28.02.2020 Сделать свой эксепшн хендлер и избавиться от говнокода
    @RequestMapping(
            value = "/base64Decode",
            method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    private Mono<ResponseEntity<Base64Response>> base64Decode(
            @RequestHeader(value = "Message-UUID") String messageUuid,
            @RequestBody @NotNull Base64Request requestBody) {
        AtomicReference<String> bodyMsg = new AtomicReference<>();
        try {
            bodyMsg.set(new String(Base64.getDecoder().decode(requestBody.getMessage().getBytes())));
        } catch (NullPointerException e) {
            bodyMsg.set("Incorrect body format! JSON example:{\"message\":\"<Your message>\"}");
            return Mono.just(
                    ResponseEntity
                    .badRequest()
                    .header("Message-UUID", messageUuid)
                    .body(new Base64Response(bodyMsg)));
        }

        return Mono.just(ResponseEntity.ok().header("Message-UUID", messageUuid).body(new Base64Response(bodyMsg)));
    }
}