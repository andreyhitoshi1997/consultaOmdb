package com.example.consultaomdb.exceptions;

public class MovieCantBeEmptyException extends RuntimeException {
    public MovieCantBeEmptyException(String message) {
        super(message);
    }
}
