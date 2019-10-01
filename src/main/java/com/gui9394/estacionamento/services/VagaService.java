package com.gui9394.estacionamento.services;

import com.gui9394.estacionamento.entities.Vaga;
import com.gui9394.estacionamento.enumerations.EstadoVaga;
import com.gui9394.estacionamento.repositories.VagaRepository;
import com.gui9394.estacionamento.services.exceptions.ObjectNotFoundException;
import com.gui9394.estacionamento.services.exceptions.VagaOcupadaException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class VagaService {

    // Repositories
    private VagaRepository vagaRepository;

    /**
     * Salva Vaga.
     *
     * @return retorna o Vaga salvo.
     * */
    public Vaga salvar(Vaga vaga) {
        return vagaRepository.save(vaga);
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

        return retorno.orElseThrow(() -> new ObjectNotFoundException("Vaga nao encontrada Id: " + id));
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
        return vagaRepository.findByEstado(EstadoVaga.LIVRE);
    }

    /**
     * Busca Vaga utilizando ID.
     *
     * @param id id do Vaga a ser buscado.
     * @throws VagaOcupadaException caso a ja Vaga estiver ocupada.
     * @throws ObjectNotFoundException caso o Vaga nao exista.
     * @return retorna a instancia do objeto Vaga encontrado.
     * */
    public Vaga buscarDisponivelPorId(Long id) {
        Optional<Vaga> retorno = vagaRepository.findById(id);

        retorno.orElseThrow(() ->
            new ObjectNotFoundException("Vaga nao encontrada Id: " + id)
        );

        retorno.ifPresent(vaga -> {
            if (vaga.getEstado() == EstadoVaga.OCUPADA) {
                throw new VagaOcupadaException(vaga);
            }
        });

        return retorno.get();
    }

    /**
     * Retorna a quantidade de Vagas disponiveis.
     *
     * @return quantidade de e Vagas disponiveis.
     * */
    public Integer quantidadeDisponivel() {
        return vagaRepository.countByEstado(EstadoVaga.LIVRE);
    }

}
