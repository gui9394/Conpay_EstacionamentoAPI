package com.gui9394.estacionamento.util;

import com.gui9394.estacionamento.entities.Ticket;
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

    @Value("${tempo_extra}")
    private long tempoExtra;

    @Value("${valor_padrao}")
    private double valorPadrao;

    @Value("${valor_extra}")
    private double valorExtra;
    
    private double calcularValorExtra(long tempo) {
        double valor = 0;

        if (tempo > 0) {
            valor = valorExtra + calcularValorExtra(tempo - tempoExtra);
        }

        return valor;
    }

    /**
     * Calculo de valor do Ticket.
     *
     * @param ticket Ticket que o valor será calculado.
     * @return valor a ser pago.
     * */
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
