package com.gui9394.parking.util;

import com.gui9394.parking.entities.Ticket;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@PropertySource("classpath:ticket.properties")
public class TicketUtil {

    // Parametros
    @Value("${tempo_gratuito}")
    private long tempoGratuito;

    @Value("${tempo_padrao}")
    private long tempoPadrao;

    @Value("${valor_padrao}")
    private double valorPadrao;

    @Value("${tempo_extra}")
    private long tempoExtra;

    @Value("${valor_extra}")
    private double valorExtra;
    
    private double calcularValorExtra(long tempo) {
        double valor = 0;

        if (tempo > 0) {
            valor = valorExtra + calcularValorExtra(tempo - tempoExtra);
        }

        return valor;
    }

    public double calcularValor(Ticket ticket) {
        long tempo = Duration.between(ticket.getEntrada(), ticket.getSaida()).toMinutes() - tempoGratuito;
        double valor = 0;

        if (tempo == 0) {
            valor = valorPadrao;
        } else {
            valor = valorPadrao + calcularValorExtra(tempo - tempoPadrao);
        }

        return valor;
    }
}
