package br.com.santander.domain.enumeration;

import lombok.Getter;

@Getter
public enum ExceptionMessage {


    RECORD_SUCCESS_NOT_FOUND("no success record was found."),
    RECORD_ERROR_NOT_FOUND("no error record was found."),
    RECORD_NOT_FOUND("no record was found."),
    INTERNAL_SERVER_ERROR("unknown error");

    private final String messageKey;

    ExceptionMessage(String messageKey) {
        this.messageKey = messageKey;
    }

    @Override
    public String toString() {
        return messageKey;
    }

}
