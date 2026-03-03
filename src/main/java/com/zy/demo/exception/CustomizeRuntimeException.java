package com.zy.demo.exception;

/**
 * 自定义运行时异常
 *
 * @author zy
 */
public class CustomizeRuntimeException extends RuntimeException {

    public CustomizeRuntimeException() {
        super();
    }

    public CustomizeRuntimeException(String message) {
        super(message);
    }

    public CustomizeRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomizeRuntimeException(Throwable cause) {
        super(cause);
    }
}
