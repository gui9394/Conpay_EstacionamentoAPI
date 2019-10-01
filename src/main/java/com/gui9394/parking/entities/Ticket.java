package com.gui9394.parking.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    // Id do ticket
    private Long id;

    // Vaga utilizada
    @ManyToOne(fetch = FetchType.EAGER)
    private Vaga vaga;

    // Horario de entrada
    private LocalDateTime entrada;

    // Horario de saida do estacionamento
    private LocalDateTime saida;

    // Valor pago
    private Double valor;

    public Ticket(@NonNull Vaga vaga, @NonNull LocalDateTime entrada) {
        this.vaga = vaga;
        this.entrada = entrada;
        this.valor = 0D;
    }
    
}
