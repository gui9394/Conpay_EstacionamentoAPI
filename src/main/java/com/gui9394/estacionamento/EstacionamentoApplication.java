package com.gui9394.estacionamento;

import com.gui9394.estacionamento.entities.Vaga;
import com.gui9394.estacionamento.services.VagaService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@RequiredArgsConstructor
@PropertySource("classpath:vaga.properties")
public class EstacionamentoApplication implements CommandLineRunner{

	@NonNull
	private VagaService vagaService;

	@Value("${quantidade}")
	private int quantidade;

	public static void main(String[] args) {
		SpringApplication.run(EstacionamentoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Criar as vagas caso nao na base de dados
		if (vagaService.buscarTodos().size() == 0) {
			for (int i = 0; i < quantidade; i++) {
				vagaService.salvar(new Vaga(String.valueOf(i + 1)));
			}
		}
	}

}
