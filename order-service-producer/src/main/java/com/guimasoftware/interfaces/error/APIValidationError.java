package com.guimasoftware.interfaces.error;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

public class APIValidationError extends ApiErrorMessage {

    public APIValidationError(final MethodArgumentNotValidException ex) {
        super();

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        final StringBuilder sb = new StringBuilder("Not valid fields => [");
        fieldErrors.forEach(fieldError -> sb.append(String.format("field='%s', reason='%s', ", fieldError.getField(), fieldError.getDefaultMessage())));
        sb.append("].");

        errors.add(new ApiError(VALIDATION_ERROR, null, sb.toString()));
    }
}
