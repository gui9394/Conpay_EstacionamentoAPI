package com.gui9394.parking.services.exceptions;

import com.gui9394.parking.entities.Ticket;

public class TicketFinalizadoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TicketFinalizadoException(Ticket ticket) {

        super("Ticket " + ticket.getId() + " ja se encontra finalizado");
    }

}
