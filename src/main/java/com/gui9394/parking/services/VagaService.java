package com.gui9394.parking.services;

import com.gui9394.parking.domain.Vaga;
import com.gui9394.parking.repositories.VagaRepository;
import com.gui9394.parking.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VagaService {

    private VagaRepository vagaRepository;

    public VagaService(VagaRepository vagaRepository) {
        this.vagaRepository = vagaRepository;
    }

    public Vaga findById(Long id) {
        Optional<Vaga> retorno = vagaRepository.findById(id);

        return retorno.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Vaga.class.getName()));
    }

}
