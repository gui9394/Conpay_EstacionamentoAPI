package com.gui9394.parking.services;

import com.gui9394.parking.domain.Ticket;
import com.gui9394.parking.repositories.TicketRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketService {

    private TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket findById(Long id) {
        Optional<Ticket> retorno = ticketRepository.findById(id);

        return retorno.orElseThrow(() -> new ObjectNotFoundException(id, "Objeto não encontrado! Id:"));
    }

}
