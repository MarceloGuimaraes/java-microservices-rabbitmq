package com.guimasoftware.interfaces.error;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.beans.ConstructorProperties;

public class ApiError {
    @JsonProperty("code")
    protected String code;
    @JsonProperty("reason")
    protected String reason;
    @JsonProperty("message")
    protected String message;
    @JsonIgnore
    protected Throwable throwable;

    public ApiError(GenericApiException ex) {
        this.throwable = ex.getCause();
        this.code = ex.getCode();
        this.message = ex.getMessage();
        this.reason = ex.getReason();
    }

    public static ApiErrorBuilder builder() {
        return new ApiErrorBuilder();
    }

    public String getCode() {
        return this.code;
    }

    public String getReason() {
        return this.reason;
    }

    public String getMessage() {
        return this.message;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ApiError)) {
            return false;
        } else {
            ApiError other = (ApiError)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$code = this.getCode();
                    Object other$code = other.getCode();
                    if (this$code == null) {
                        if (other$code == null) {
                            break label59;
                        }
                    } else if (this$code.equals(other$code)) {
                        break label59;
                    }

                    return false;
                }

                Object this$reason = this.getReason();
                Object other$reason = other.getReason();
                if (this$reason == null) {
                    if (other$reason != null) {
                        return false;
                    }
                } else if (!this$reason.equals(other$reason)) {
                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$throwable = this.getThrowable();
                Object other$throwable = other.getThrowable();
                if (this$throwable == null) {
                    if (other$throwable != null) {
                        return false;
                    }
                } else if (!this$throwable.equals(other$throwable)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ApiError;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        Object $reason = this.getReason();
        result = result * 59 + ($reason == null ? 43 : $reason.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $throwable = this.getThrowable();
        result = result * 59 + ($throwable == null ? 43 : $throwable.hashCode());
        return result;
    }

    public String toString() {
        return "ApiError(code=" + this.getCode() + ", reason=" + this.getReason() + ", message=" + this.getMessage() + ", throwable=" + this.getThrowable() + ")";
    }

    @ConstructorProperties({"code", "reason", "message", "throwable"})
    public ApiError(String code, String reason, String message, Throwable throwable) {
        this.code = code;
        this.reason = reason;
        this.message = message;
        this.throwable = throwable;
    }

    public ApiError() {
    }

    public static class ApiErrorBuilder {
        private String code;
        private String reason;
        private String message;
        private Throwable throwable;

        ApiErrorBuilder() {
        }

        public ApiErrorBuilder code(String code) {
            this.code = code;
            return this;
        }

        public ApiErrorBuilder reason(String reason) {
            this.reason = reason;
            return this;
        }

        public ApiErrorBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ApiErrorBuilder throwable(Throwable throwable) {
            this.throwable = throwable;
            return this;
        }

        public ApiError build() {
            return new ApiError(this.code, this.reason, this.message, this.throwable);
        }

        public String toString() {
            return "ApiError.ApiErrorBuilder(code=" + this.code + ", reason=" + this.reason + ", message=" + this.message + ", throwable=" + this.throwable + ")";
        }
    }
}
