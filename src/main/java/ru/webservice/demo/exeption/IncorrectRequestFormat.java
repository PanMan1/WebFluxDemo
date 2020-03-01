package ru.webservice.demo.exeption;

import lombok.Data;

@Data
public class IncorrectRequestFormat extends Exception {
    String messageUuid;

    public IncorrectRequestFormat(String message, String messageUuid){
        super(message);
        this.messageUuid = messageUuid;
    }
}
