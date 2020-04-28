package com.guimasoftware.interfaces.error;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
public class ApiNotFoundException extends RuntimeException {

    private final String code;
    private final String reason;

    @Builder
    public ApiNotFoundException(String code, String reason, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.reason = reason;
    }
}
