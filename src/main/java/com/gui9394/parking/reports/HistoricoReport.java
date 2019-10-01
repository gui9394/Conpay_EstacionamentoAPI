package com.gui9394.parking.reports;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Relatorio contendo:
 *  - Quantidade de veiculos ja estaciondos
 *  - Somatorio dos pagamentos realizados;
 * */
@Getter
@Setter
@AllArgsConstructor
public class HistoricoReport implements Serializable {
    private static final long serialVersionUID = 1L;

    private int quantidadeEstacionados;
    private double valorPagamentos;

}