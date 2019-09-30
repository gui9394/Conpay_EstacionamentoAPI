package com.gui9394.parking.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class StandardError implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer status;
    private String message;
    private Long time;

}