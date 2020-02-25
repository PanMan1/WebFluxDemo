package ru.webservice.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;


@Data
@NoArgsConstructor
public class Base64Request {
//    @JsonProperty("dateTime")
//    @NotNull
//    private OffsetDateTime dateTime;

    @JsonProperty("text")
    @NotNull
    private String text;



}
