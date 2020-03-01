package ru.webservice.demo.handler;

import org.springframework.http.ResponseEntity;
import ru.webservice.demo.exeption.IncorrectRequestFormat;
import ru.webservice.demo.model.Base64Request;
import ru.webservice.demo.model.Base64Response;

import java.util.Base64;
import java.util.Map;
import java.util.UUID;

public class Base64Handler {

   public enum Operation {
        ENCODE,
        DECODE
    }

    public static ResponseEntity<Base64Response>
    makeBase64Operation(Base64Handler.Operation operation, Map<String, String> headers, Base64Request requestBody)
            throws IncorrectRequestFormat {

        String responseBody;

        String messageUuid = (headers.containsKey("Message-UUID") && (headers.get("Message-UUID") != null)) ?
                headers.get("Message-UUID") : UUID.randomUUID().toString();

        try {
            switch (operation) {
                case ENCODE:
                    responseBody = new String(Base64.getEncoder().encode(requestBody.getMessage().getBytes()));
                    break;

                case DECODE:
                    responseBody = new String(Base64.getDecoder().decode(requestBody.getMessage().getBytes()));
                    break;

                default: responseBody = "Unknown Base64 operation type";
            }

        } catch (NullPointerException e) {
            throw new IncorrectRequestFormat(
                    "Incorrect body format! JSON example:{\"message\":\"<Your message (should be not null )>\"}",
                    messageUuid);
        }

        return ResponseEntity.ok().header("Message-UUID", messageUuid).body(new Base64Response(responseBody));
    }
}
