package com.gui9394.parking.services.exceptions;

import com.gui9394.parking.entities.Vaga;

public class VagaOcupadaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public VagaOcupadaException(Vaga vaga) {

        super("Vaga " + vaga.getId() + " ja se encontra ocupada");
    }

}
