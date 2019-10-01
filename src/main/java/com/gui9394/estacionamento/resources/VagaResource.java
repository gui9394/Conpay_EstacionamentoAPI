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

    private VagaService vagaService;

    @GetMapping(params = "id")
    public ResponseEntity<Vaga> buscarPorId(@RequestParam("id") Long id) {
        Vaga vaga = vagaService.buscarPorId(id);

        return ResponseEntity.ok(vaga);
    }

    @GetMapping
    public ResponseEntity<List<Vaga>> listar() {
        List<Vaga> vagas = vagaService.buscarTodos();

        return ResponseEntity.ok(vagas);
    }

    @GetMapping(value = "/disponiveis")
    public ResponseEntity<List<Vaga>> listarDisponiveis() {
        List<Vaga> vagas = vagaService.buscarVagasDisponiveis();

        return ResponseEntity.ok(vagas);
    }

    @GetMapping(value = "/disponiveis/quantidade")
    public ResponseEntity<Integer> quantidadeDisponivel() {
        Integer quantidade = vagaService.quantidadeDisponivel();

        return ResponseEntity.ok(quantidade);
    }

}
