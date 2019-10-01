package com.gui9394.parking.repositories;

import com.gui9394.parking.entities.Vaga;
import com.gui9394.parking.enumerations.VagaEstado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {

    List<Vaga> findByEstado(VagaEstado estado);

    Integer countByEstado(VagaEstado estado);

}
