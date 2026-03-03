package com.zy.demo.exception;

/**
 * 自定义受检查的异常
 *
 * @author zy
 */
public class CustomizeCheckedException extends Exception {

    public CustomizeCheckedException() {
        super();
    }

    public CustomizeCheckedException(String message) {
        super(message);
    }

    public CustomizeCheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomizeCheckedException(Throwable cause) {
        super(cause);
    }
}
