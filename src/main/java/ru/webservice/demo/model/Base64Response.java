package ru.webservice.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Base64Response {
    @JsonProperty("response")
    @NotNull
    private String response;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("    response: ").append(response).append("\n");
        sb.append("    time: ").append(OffsetDateTime.now()).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
