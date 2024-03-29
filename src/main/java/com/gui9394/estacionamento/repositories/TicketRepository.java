package com.gui9394.estacionamento.repositories;

import com.gui9394.estacionamento.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findBySaidaIsNotNull();

    List<Ticket> findBySaidaIsNull();

}
