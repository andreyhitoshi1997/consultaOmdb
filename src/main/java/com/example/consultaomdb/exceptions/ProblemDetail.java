package com.example.consultaomdb.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.net.URI;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProblemDetail implements Serializable {
    private URI type;
    private String title;
    private int status;
    private String detail;
    private String instance;
}
