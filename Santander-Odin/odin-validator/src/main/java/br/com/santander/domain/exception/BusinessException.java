package br.com.santander.domain.exception;

import br.com.santander.domain.enumeration.ExceptionMessage;
import org.springframework.http.HttpStatus;

public class BusinessException extends DefaultException{

    public BusinessException(HttpStatus status, ExceptionMessage reason, Throwable cause, String... messageParams) {
        super(status, reason, cause, messageParams);
    }

    public BusinessException(Integer status, ExceptionMessage reason, Throwable cause, String... messageParams) {
        super(HttpStatus.valueOf(status), reason, cause, messageParams);
    }

    public BusinessException(HttpStatus status, ExceptionMessage reason, String... messageParams) {
        super(status, reason, messageParams);
    }

    public BusinessException(Integer status, ExceptionMessage reason, String... messageParams) {
        super(HttpStatus.valueOf(status), reason, messageParams);
    }

    public BusinessException(ExceptionMessage reason, String... messageParams) {
        super(reason, messageParams);
    }

}
