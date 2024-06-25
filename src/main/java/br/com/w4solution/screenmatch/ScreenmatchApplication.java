package br.com.w4solution.screenmatch;

import br.com.w4solution.screenmatch.model.DadosSerie;
import br.com.w4solution.screenmatch.service.ConsumoAPI;
import br.com.w4solution.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoAPI();
		var json = consumoApi.obterDados("https://omdbapi.com/?t=gilmore+girls&apikey=46a057c");
//		System.out.println(json);
//		json = consumoApi.obterDados("https://coffee.alexflipnote.dev/random.json");
		System.out.println(json);
		var conversorDados = new ConverteDados();
		var dadosSerie = conversorDados.obterDados(json, DadosSerie.class);
		System.out.println(dadosSerie);
	}
}
