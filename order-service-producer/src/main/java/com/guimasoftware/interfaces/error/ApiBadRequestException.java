package com.guimasoftware.interfaces.error;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@Getter
public class ApiBadRequestException extends RuntimeException {
    public static final String VALIDATION_ERROR = "validation_error";

    private final String code;
    private final String reason;

    @Builder
    public ApiBadRequestException(String code, String reason, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.reason = reason;
    }
}
