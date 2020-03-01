package ru.webservice.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import ru.webservice.demo.exeption.IncorrectRequestFormat;
import ru.webservice.demo.model.Base64Request;
import ru.webservice.demo.model.Base64Response;

import javax.validation.constraints.NotNull;
import java.util.Map;

import static ru.webservice.demo.handler.Base64Handler.Operation;
import static ru.webservice.demo.handler.Base64Handler.makeBase64Operation;

@RestController
@RequestMapping("/textUtils")
public class TextUtilsController {

    @RequestMapping(
            value = "/base64Encode",
            method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    private Mono<ResponseEntity<Base64Response>> base64Encode(
            @RequestHeader @NotNull Map<String, String> headers,
            @RequestBody @NotNull Base64Request requestBody) throws IncorrectRequestFormat  {
        return Mono.just(makeBase64Operation(Operation.ENCODE, headers, requestBody));
    }

    @RequestMapping(
            value = "/base64Decode",
            method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    private Mono<ResponseEntity<Base64Response>> base64Decode(
            @RequestHeader @NotNull Map<String, String> headers,
            @RequestBody @NotNull Base64Request requestBody) throws IncorrectRequestFormat {
        return Mono.just(makeBase64Operation(Operation.DECODE, headers, requestBody));
    }

    @ExceptionHandler
    private Mono<ResponseEntity<Base64Response>> exeptionHandler(IncorrectRequestFormat ex) {
        return Mono.just(ResponseEntity
                .badRequest()
                .header("Message-UUID", ex.getMessageUuid())
                .body(new Base64Response(ex.getMessage())));
    }
}