package com.example.consultaomdb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String problemTypePrefix = "urn:problem-type:";

    @ExceptionHandler
    public ResponseEntity<ProblemDetail> handleGeneralException(Exception ex, WebRequest request) {
        String instance = ((ServletWebRequest) request).getRequest().getRequestURI();
        ProblemDetail problemDetail = ProblemDetail.builder()
                .type(URI.create(problemTypePrefix + "server-error"))
                .title("INTERNAL SERVER ERROR")
                .status(500)
                .detail(ex.getMessage())
                .instance(instance)
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(problemDetail);
    }

    @ExceptionHandler(MovieCantBeEmptyException.class)
    public ResponseEntity<ProblemDetail> handleIllegalArgument(IllegalArgumentException ex, WebRequest request) {
        String instance = ((ServletWebRequest) request).getRequest().getRequestURI();
        ProblemDetail problem = ProblemDetail.builder()
                .type(URI.create(problemTypePrefix + "bad-request"))
                .title("Bad Requests")
                .status(400)
                .detail(ex.getMessage())
                .instance(instance)
                .build();
        return ResponseEntity.status(400).body(problem);
    }

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleMovieNotFound(MovieNotFoundException ex, WebRequest request) {
        String instance = ((ServletWebRequest) request).getRequest().getRequestURI();
        ProblemDetail problem = ProblemDetail.builder()
                .type(URI.create(problemTypePrefix + "not-found"))
                .title("Movie Not Found")
                .status(404)
                .detail(ex.getMessage())
                .instance(instance)
                .build();
        return ResponseEntity.status(404).body(problem);
    }
}
