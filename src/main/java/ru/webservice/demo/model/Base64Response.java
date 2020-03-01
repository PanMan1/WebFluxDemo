package ru.webservice.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
public class Base64Response {
    @JsonProperty("message")
    @NotNull
    private String message;

    @JsonProperty("time")
    @NotNull
    private String time = OffsetDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);

    public Base64Response(String bodyMsg){
        this.message = bodyMsg;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{").append("\n");
        sb.append("    response: ").append(message).append("\n");
        sb.append("    time: ").append(time).append("\n");
        sb.append("}").append("\n");
        return sb.toString();
    }
}
