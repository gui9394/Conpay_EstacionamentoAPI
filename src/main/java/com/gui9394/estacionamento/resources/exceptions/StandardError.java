package com.gui9394.estacionamento.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class StandardError implements Serializable {

    private static final long serialVersionUID = 1L;

    private int status;
    private String message;
    private LocalDateTime timestamp;

}
