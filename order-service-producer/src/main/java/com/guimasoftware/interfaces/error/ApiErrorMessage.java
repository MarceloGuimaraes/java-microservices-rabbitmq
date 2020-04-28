package com.guimasoftware.interfaces.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ApiErrorMessage {

    public static final String UNKNOWN_ERROR = "unknown_error";
    public static final String GENERAL_ERROR = "general_error";
    public static final String VALIDATION_ERROR = "validation_error";

    @Data
    @AllArgsConstructor
    public static class ApiError {
        @JsonProperty("code")
        protected String code;

        @JsonProperty("reason")
        protected String reason;

        @JsonProperty("message")
        protected String message;
    }

    @JsonProperty("errors")
    protected List<ApiError> errors = new ArrayList<>();

    public ApiErrorMessage() { }

    public ApiErrorMessage(final Exception ex) {
        errors.add(new ApiError(GENERAL_ERROR, null, ex.getMessage()));
    }

    public ApiErrorMessage(final ApiException ex) {
        errors.add(new ApiError(ex.getCode(), ex.getReason(), ex.getMessage()));
    }

    public ApiErrorMessage(final ApiBadRequestException ex) {
        errors.add(new ApiError(ex.getCode(), ex.getReason(), ex.getMessage()));
    }

    public ApiErrorMessage(final ApiNotFoundException ex) {
        errors.add(new ApiError(ex.getCode(), ex.getReason(), ex.getMessage()));
    }

}