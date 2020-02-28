package ru.webservice.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.concurrent.atomic.AtomicReference;

@Data
@NoArgsConstructor
public class Base64Response {
    @JsonProperty("message")
    @NotNull
    private AtomicReference<String> message;

    @JsonProperty("time")
    @NotNull
    private OffsetDateTime time = OffsetDateTime.now();

    public Base64Response(AtomicReference<String> bodyMsg){
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
