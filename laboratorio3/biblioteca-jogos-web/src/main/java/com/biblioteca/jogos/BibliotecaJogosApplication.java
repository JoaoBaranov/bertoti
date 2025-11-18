package com.biblioteca.jogos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class BibliotecaJogosApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaJogosApplication.class, args);
	}

}
@CrossOrigin(origins = {"http://localhost:8080","http://127.0.0.1:5500"})
@RestController
@RequestMapping("/games")


class JogoController {
	private List<Jogo> jogos = new ArrayList<>();


	public JogoController() {
		jogos.addAll(List.of(
				new Jogo("The Witcher 3: Wild Hunt", "CD Projekt RED", 2015, "RPG"),
				new Jogo("Red Dead Redemption 2", "Rockstar Games", 2018, "Ação/Aventura"),
				new Jogo("The Legend of Zelda: Breath of the Wild", "Nintendo", 2017, "Ação/Aventura"),
				new Jogo("God of War", "Santa Monica Studio", 2018, "Ação/Aventura")
		));
	}


	@GetMapping
	Iterable<Jogo> getJogos() {
		return jogos;
	}

	@GetMapping("/{id}")
	Optional<Jogo> getJogoById(@PathVariable String id) {
		for (Jogo j: jogos) {
			if (j.getId().equals(id)) {
				return Optional.of(j);
			}
		}

		return Optional.empty();
	}


	@PostMapping
	Jogo postJogo(@RequestBody Jogo jogo) {
		jogos.add(jogo);
		return jogo;
	}

	@PutMapping("/{id}")
	ResponseEntity<Jogo> putJogo(@PathVariable String id,
								 @RequestBody Jogo jogo) {
		int jogoIndex = -1;

		for (Jogo j: jogos) {
			if (j.getId().equals(id)) {
				jogoIndex = jogos.indexOf(j);
				jogos.set(jogoIndex, jogo);
			}
		}

		return (jogoIndex == -1) ?
				new ResponseEntity<>(postJogo(jogo), HttpStatus.CREATED) :
				new ResponseEntity<>(jogo, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	void deleteJogo(@PathVariable String id) {
		jogos.removeIf(j -> j.getId().equals(id));
	}
}

class Jogo {
	private final String id;
	private String name;
	private String developer;
	private Integer year;
	private String genre;

	public Jogo(String id, String name, String developer, Integer year, String genre) {
		this.id = id;
		this.name = name;
		this.developer = developer;
		this.year = year;
		this.genre = genre;
	}

	public Jogo(String name, String developer, Integer year, String genre) {
		this(UUID.randomUUID().toString(), name, developer, year, genre);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}

