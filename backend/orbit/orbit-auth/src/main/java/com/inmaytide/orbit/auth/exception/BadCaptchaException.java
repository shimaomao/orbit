package com.inmaytide.orbit.auth.exception;

public class BadCaptchaException extends RuntimeException {

    private static final long serialVersionUID = 4371999368295695321L;

    public BadCaptchaException() {
        super();
    }

    public BadCaptchaException(String message) {
        super(message);
    }

    public BadCaptchaException(Throwable cause) {
        super(cause);
    }
}
