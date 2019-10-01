package com.gui9394.estacionamento.resources;

import com.gui9394.estacionamento.entities.Ticket;
import com.gui9394.estacionamento.services.TicketService;
import com.gui9394.estacionamento.reports.HistoricoReport;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/relatorios")
public class ReportResource {

    // Services
    private TicketService ticketService;

    @GetMapping(value = "/historico")
    public ResponseEntity<HistoricoReport> relatorio() {
        List<Ticket> tickets = ticketService.buscarFinalizados();

        double valoTotal = 0;

        for (Ticket ticket: tickets) {
            valoTotal = valoTotal + ticket.getValor();
        }

        return ResponseEntity.ok( new HistoricoReport(tickets.size(), valoTotal));
    }

}
