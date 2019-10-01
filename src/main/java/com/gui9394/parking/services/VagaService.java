package com.gui9394.parking.services;

import com.gui9394.parking.entities.Vaga;
import com.gui9394.parking.enumerations.VagaEstado;
import com.gui9394.parking.repositories.VagaRepository;
import com.gui9394.parking.services.exceptions.ObjectNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VagaService {

    // Repositories
    @NonNull
    private VagaRepository vagaRepository;

    @Value("${vagas.quantidade}")
    private int quantidade;

    /**
     * Salva Vaga.
     *
     * @return retorna o Vaga salvo.
     * */
    public Vaga salvar(Vaga vaga) {
        return vagaRepository.save(vaga);
    }

    /**
     * Busca todos os Vagas.
     *
     * @return lista com os Vagas encontrados.
     * */
    public List<Vaga> buscarTodos() {
        return vagaRepository.findAll();
    }

    /**
    * Busca as todas as Vagas com estado livre
     *
     * @return lista com as Vagas com estado de livre encontradas.
    * */
    public List<Vaga> buscarVagasDisponiveis() {
        return vagaRepository.findByEstado(VagaEstado.LIVRE);
    }

    /**
     * Busca Vaga utilizando ID.
     *
     * @param id id do Vaga a ser buscado.
     * @throws ObjectNotFoundException caso o Vaga nao exista.
     * @return retorna a instancia do objeto Vaga encontrado.
     * */
    public Vaga buscarPorId(Long id) {
        Optional<Vaga> retorno = vagaRepository.findById(id);

        return retorno.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Vaga.class.getName()));
    }

    public Integer quantidadeDisponivel() {
        return vagaRepository.countByEstado(VagaEstado.LIVRE);
    }
}
