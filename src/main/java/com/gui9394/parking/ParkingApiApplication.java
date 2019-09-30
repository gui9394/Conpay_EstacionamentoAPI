package com.gui9394.parking;

import com.gui9394.parking.domain.Ticket;
import com.gui9394.parking.domain.Vaga;
import com.gui9394.parking.repositories.TicketRepository;
import com.gui9394.parking.repositories.VagaRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Arrays;

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

		Ticket ticket1 = new Ticket(vaga1, LocalDateTime.now());
		Ticket ticket2 = new Ticket(vaga1, LocalDateTime.now());

		vagaRepository.saveAll(Arrays.asList(vaga1, vaga2));
		ticketRepository.saveAll(Arrays.asList(ticket1, ticket2));
	}

}
