package com.gui9394.estacionamento.resources;

import com.gui9394.estacionamento.entities.Vaga;
import com.gui9394.estacionamento.services.VagaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/vagas")
public class VagaResource {

    private VagaService service;

    @GetMapping
    public ResponseEntity<List<Vaga>> listar() {
        List<Vaga> vagas = service.buscarTodos();

        return ResponseEntity.ok(vagas);
    }

    @GetMapping(params = "id")
    public ResponseEntity<Vaga> buscarPorId(@PathVariable Long id) {
        Vaga vaga = service.buscarDisponivelPorId(id);

        return ResponseEntity.ok(vaga);
    }

    @GetMapping(value = "/disponiveis")
    public ResponseEntity<List<Vaga>> listarDisponiveis() {
        List<Vaga> vagas = service.buscarVagasDisponiveis();

        return ResponseEntity.ok(vagas);
    }

    @GetMapping(value = "/disponiveis/quantidade")
    public ResponseEntity<Integer> quantidadeDisponivel() {
        Integer quantidade = service.quantidadeDisponivel();

        return ResponseEntity.ok(quantidade);
    }

}