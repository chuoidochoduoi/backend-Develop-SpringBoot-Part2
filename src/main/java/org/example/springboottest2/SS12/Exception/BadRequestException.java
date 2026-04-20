package org.example.springboottest2.SS12.Exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String msg) { super(msg); }
}