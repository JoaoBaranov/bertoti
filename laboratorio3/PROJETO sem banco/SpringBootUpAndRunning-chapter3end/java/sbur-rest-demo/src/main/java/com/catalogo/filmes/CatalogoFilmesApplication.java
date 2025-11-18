package com.catalogo.filmes;

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
public class CatalogoFilmesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogoFilmesApplication.class, args);
	}

}

@RestController
@RequestMapping("/movies")
class FilmeController {
	private List<Filme> filmes = new ArrayList<>();

	public FilmeController() {
		filmes.addAll(List.of(
				new Filme("O Poderoso Chefão", "Francis Ford Coppola", 1972, "Drama"),
				new Filme("Matrix", "Lana Wachowski, Lilly Wachowski", 1999, "Ficção Científica"),
				new Filme("Interestelar", "Christopher Nolan", 2014, "Ficção Científica"),
				new Filme("Clube da Luta", "David Fincher", 1999, "Drama")
		));
	}

	@GetMapping
	Iterable<Filme> getFilmes() {
		return filmes;
	}

	@GetMapping("/{id}")
	Optional<Filme> getFilmeById(@PathVariable String id) {
		for (Filme f: filmes) {
			if (f.getId().equals(id)) {
				return Optional.of(f);
			}
		}

		return Optional.empty();
	}

	@PostMapping
	Filme postFilme(@RequestBody Filme filme) {
		filmes.add(filme);
		return filme;
	}

	@PutMapping("/{id}")
	ResponseEntity<Filme> putFilme(@PathVariable String id,
								 @RequestBody Filme filme) {
		int filmeIndex = -1;

		for (Filme f: filmes) {
			if (f.getId().equals(id)) {
				filmeIndex = filmes.indexOf(f);
				filmes.set(filmeIndex, filme);
			}
		}

		return (filmeIndex == -1) ?
				new ResponseEntity<>(postFilme(filme), HttpStatus.CREATED) :
				new ResponseEntity<>(filme, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	void deleteFilme(@PathVariable String id) {
		filmes.removeIf(f -> f.getId().equals(id));
	}
}

class Filme {
	private final String id;
	private String title;
	private String director;
	private Integer year;
	private String genre;

	public Filme(String id, String title, String director, Integer year, String genre) {
		this.id = id;
		this.title = title;
		this.director = director;
		this.year = year;
		this.genre = genre;
	}

	public Filme(String title, String director, Integer year, String genre) {
		this(UUID.randomUUID().toString(), title, director, year, genre);
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
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

