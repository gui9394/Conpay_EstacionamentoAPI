package com.gui9394.parking.resources;

import com.gui9394.parking.domain.Vaga;
import com.gui9394.parking.services.VagaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/vagas")
public class VagaResource {

    private VagaService service;

    public VagaResource(VagaService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Vaga> listar() {
        Vaga vaga1 = new Vaga(1L, "1", false);
        Vaga vaga2 = new Vaga(2L, "2", false);

        List<Vaga> vagas = new ArrayList<>();

        vagas.add(vaga1);
        vagas.add(vaga2);

        return vagas;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Vaga vaga = service.findById(id);

        return ResponseEntity.ok(vaga);
    }
}
