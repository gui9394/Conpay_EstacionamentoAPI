package com.gui9394.parking.resources;


import com.gui9394.parking.entities.Ticket;
import com.gui9394.parking.services.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tickets")
public class TicketResource {

    // Services
    private TicketService ticketService;

    public TicketResource(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> listar() {
        List<Ticket> tickets = ticketService.buscarTodos();

        return ResponseEntity.ok(tickets);
    }

    @GetMapping(value = "/abertos")
    public ResponseEntity<List<Ticket>> listarAbertos() {
        List<Ticket> tickets = ticketService.buscarAbertos();

        return ResponseEntity.ok(tickets);
    }

    @PostMapping(value = "/emitir", params = "vaga")
    public ResponseEntity<Ticket> emitir(@RequestParam("vaga") Long vagaId) {
        Ticket ticket = ticketService.emitir(vagaId);

        return ResponseEntity.ok(ticket);
    }

    @PutMapping(value = "/finalizar", params = "id")
    public ResponseEntity<Ticket> finalizar(@RequestParam("id") Long id) {
        Ticket ticket = ticketService.finalizar(id);

        return ResponseEntity.ok(ticket);
    }

}
