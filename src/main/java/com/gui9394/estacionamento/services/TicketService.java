package com.gui9394.estacionamento.services;

import com.gui9394.estacionamento.entities.Ticket;
import com.gui9394.estacionamento.entities.Vaga;
import com.gui9394.estacionamento.enumerations.EstadoVaga;
import com.gui9394.estacionamento.repositories.TicketRepository;
import com.gui9394.estacionamento.services.exceptions.ObjectNotFoundException;
import com.gui9394.estacionamento.services.exceptions.TicketFinalizadoException;
import com.gui9394.estacionamento.util.TicketUtil;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TicketService {

    // Repositories
    @NonNull
    private TicketRepository ticketRepository;

    // Services
    @NonNull
    private VagaService vagaService;

    // Util
    @NonNull
    private TicketUtil ticketUtil;

    /**
     * Salva Ticket.
     *
     * @return retorna o Ticket salvo.
     * */
    public Ticket salvar(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    /**
     * Busca Ticket utilizando ID.
     *
     * @param id id do Ticket a ser buscado.
     * @throws ObjectNotFoundException caso o Ticket nao exista.
     * @return retorna a instancia do objeto Ticket encontrado.
     * */
    public Ticket buscaPorId(Long id) {
        Optional<Ticket> retorno = ticketRepository.findById(id);

        return retorno.orElseThrow(() -> new ObjectNotFoundException("Ticket nao encontrado Id:" + id));
    }

    /**
     * Busca todos os Tickets.
     *
     * @return lista com os Tickets encontrados.
     * */
    public List<Ticket> buscarTodos() {
        return ticketRepository.findAll();
    }

    /**
     * Busca todos os Tickets em aberto.
     *
     * @return lista de Tickets em aberto encontrados.
     * */
    public List<Ticket> buscarAbertos() {
        return ticketRepository.findBySaidaIsNull();
    }

    /**
     * Busca todos os Tickets em aberto.
     *
     * @return lista de Tickets em aberto encontrados.
     * */
    public List<Ticket> buscarFinalizados() {
        return ticketRepository.findBySaidaIsNotNull();
    }

    /**
     * Emitir novo Ticket.
     *
     * @param vagaId id da vaga que sera utilizada.
     * @return retorna o Ticket.
     * */
    public Ticket emitir(Long vagaId) {
        // Horario atual
        LocalDateTime horarioEntrada = LocalDateTime.now();

        // Buscar vaga
        Vaga vaga = vagaService.buscarDisponivelPorId(vagaId);

        // Ocupar vaga
        vaga.setEstado(EstadoVaga.OCUPADA);
        vaga = vagaService.salvar(vaga);

        return salvar(new Ticket(vaga, horarioEntrada));
    }

    /**
     * Finalizar Ticket.
     * Calculando o valor e liberando a vaga.
     *
     * @return retorna o Ticket finalizado.
     * */
    public Ticket finalizar(Long id) {
        // Horario atual
        LocalDateTime horarioSaida = LocalDateTime.now();

        // Buscar ticket
        Ticket ticket = buscaPorId(id);

        if (ticket.getSaida() == null) {
            // Liberar vaga
            Vaga vaga = ticket.getVaga();
            vaga.setEstado(EstadoVaga.LIVRE);
            vaga = vagaService.salvar(vaga);

            // Calcular valor do Ticket
            ticket.setSaida(horarioSaida);
            ticket.setValor(ticketUtil.calcularValor(ticket));
            System.out.println("Continua");

            return salvar(ticket);
        } else {
            throw new TicketFinalizadoException(ticket);
        }
    }
}
