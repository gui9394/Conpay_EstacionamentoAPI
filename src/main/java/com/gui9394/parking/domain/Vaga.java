package com.gui9394.parking.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vaga implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    // Id da vaga
    private Long id;

    // Nome vaga
    private String nome;

    // Estado atual da vaga
    private Boolean ocupada;

    public Vaga(@NonNull String nome) {
        this.nome = nome;
        this.ocupada = false;
    }

}
