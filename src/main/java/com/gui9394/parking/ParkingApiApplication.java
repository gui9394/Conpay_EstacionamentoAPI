package com.gui9394.parking;

import com.gui9394.parking.entities.Vaga;
import com.gui9394.parking.repositories.TicketRepository;
import com.gui9394.parking.repositories.VagaRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class ParkingApiApplication implements CommandLineRunner {

	VagaRepository vagaRepository;
	TicketRepository ticketRepository;

	public static void main(String[] args) {
		SpringApplication.run(ParkingApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Vaga vaga1 = new Vaga("1");
		Vaga vaga2 = new Vaga("2");
		Vaga vaga3 = new Vaga("3");
//
//		vaga3.setOcupada(true);

//		Ticket ticket1 = new Ticket(vaga1, LocalDateTime.now());
//		Ticket ticket2 = new Ticket(vaga1, LocalDateTime.now());

		Vaga[] vagas = {vaga1, vaga2, vaga3};

		for (Vaga vaga:vagas) {
			vagaRepository.save(vaga);
		}

//		ticketRepository.saveAll(Arrays.asList(ticket1, ticket2));

	}

}
