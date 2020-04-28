package com.guimasoftware.interfaces.error;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
@Getter
@ToString
public class ApiException extends RuntimeException {

	public static final String VALIDATION_ERROR = "validation_error";
	public static final String INTEGRATION_ERROR = "integration_eroor";

	private final String code;
	private final String reason;

	@Builder
	public ApiException (String code, String reason, String message) {
		super(message);
		this.code = code;
		this.reason = reason;
	}

	public ApiException (String code, String msg) {
		super(msg);
		this.code = code;
		this.reason = null;
	}
}
