package ru.webservice.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class Base64Request {
    @JsonProperty("message")
    @NotNull
    private String message = null;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("\"message\": " + message);
        sb.append("}\n");
        return sb.toString();
    }
}
