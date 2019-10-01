package com.gui9394.parking.entities;

import com.gui9394.parking.enumerations.VagaEstado;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Vaga implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    // Id da vaga
    private Long id;

    private String nome;

    // Estado atual da vaga
    @Enumerated(EnumType.STRING)
    private VagaEstado estado;

    public Vaga(String nome) {
        this.nome = nome;
        this.estado = VagaEstado.LIVRE;
    }

}
