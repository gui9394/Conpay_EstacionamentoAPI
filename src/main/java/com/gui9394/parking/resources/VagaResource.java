package com.gui9394.parking.resources;

import com.gui9394.parking.entities.Vaga;
import com.gui9394.parking.services.VagaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/vagas")
public class VagaResource {

    private VagaService service;

    public VagaResource(VagaService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Vaga> buscarPorId(@PathVariable Long id) {
        Vaga vaga = service.buscarPorId(id);

        return ResponseEntity.ok(vaga);
    }

    @GetMapping
    public ResponseEntity<List<Vaga>> listar() {
        List<Vaga> vagas = service.buscarTodos();

        return ResponseEntity.ok(vagas);
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
