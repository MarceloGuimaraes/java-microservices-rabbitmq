package com.guimasoftware.interfaces.error;

import org.springframework.http.HttpStatus;

public class GenericApiException extends RuntimeException {
    private final String code;
    private final String reason;
    private final HttpStatus statusCode;

    public GenericApiException(String code, String reason, String message, HttpStatus statusCode, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.reason = reason;
        this.statusCode = statusCode == null ? HttpStatus.INTERNAL_SERVER_ERROR : statusCode;
    }

    public GenericApiException(String message) {
        super(message);
        this.reason = null;
        this.code = ApiErrorMessage.UNKNOWN_ERROR;
        this.statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public static GenericApiExceptionBuilder builder() {
        return new GenericApiExceptionBuilder();
    }

    public String getCode() {
        return this.code;
    }

    public String getReason() {
        return this.reason;
    }

    public HttpStatus getStatusCode() {
        return this.statusCode;
    }

    public String toString() {
        return "GenericApiException(code=" + this.getCode() + ", reason=" + this.getReason() + ", statusCode=" + this.getStatusCode() + ")";
    }

    public static class GenericApiExceptionBuilder {
        private String code;
        private String reason;
        private String message;
        private HttpStatus statusCode;
        private Throwable cause;

        GenericApiExceptionBuilder() {
        }

        public GenericApiExceptionBuilder code(String code) {
            this.code = code;
            return this;
        }

        public GenericApiExceptionBuilder reason(String reason) {
            this.reason = reason;
            return this;
        }

        public GenericApiExceptionBuilder message(String message) {
            this.message = message;
            return this;
        }

        public GenericApiExceptionBuilder statusCode(HttpStatus statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public GenericApiExceptionBuilder cause(Throwable cause) {
            this.cause = cause;
            return this;
        }

        public GenericApiException build() {
            return new GenericApiException(this.code, this.reason, this.message, this.statusCode, this.cause);
        }

        public String toString() {
            return "GenericApiException.GenericApiExceptionBuilder(code=" + this.code + ", reason=" + this.reason + ", message=" + this.message + ", statusCode=" + this.statusCode + ", cause=" + this.cause + ")";
        }
    }
}
