package com.gui9394.estacionamento.resources;

import com.gui9394.estacionamento.entities.Ticket;
import com.gui9394.estacionamento.services.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/tickets")
public class TicketResource {

    // Services
    private TicketService ticketService;

    @GetMapping(params = "id")
    public ResponseEntity<Ticket> buscarPorId(@RequestParam("id") Long id) {
        Ticket ticket = ticketService.buscarPorId(id);

        return ResponseEntity.ok(ticket);
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

    @PostMapping(value = "/emitir", params = "vaga_id")
    public ResponseEntity<Ticket> emitir(@RequestParam("vaga_id") Long vagaId) {
        Ticket ticket = ticketService.emitir(vagaId);

        return ResponseEntity.ok(ticket);
    }

    @PutMapping(value = "/finalizar", params = "id")
    public ResponseEntity<Ticket> finalizar(@RequestParam("id") Long id) {
        Ticket ticket = ticketService.finalizar(id);

        return ResponseEntity.ok(ticket);
    }

}
