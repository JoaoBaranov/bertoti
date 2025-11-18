package com.biblioteca.livros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class BibliotecaLivrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaLivrosApplication.class, args);
	}

}

@RestController
@RequestMapping("/books")
class LivroController {
    private final LivroRepository repository;

    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    Iterable<Livro> getLivros() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Livro> getLivroById(@PathVariable String id) {
        return repository.findById(id);
    }

    @PostMapping
    Livro postLivro(@RequestBody LivroRequest request) {
        Livro toInsert = new Livro(request.getTitle(), request.getAuthor(), request.getPublisher(), request.getYear());
        return repository.insert(toInsert);
    }

    @PutMapping("/{id}")
    ResponseEntity<Livro> putLivro(@PathVariable String id,
                                 @RequestBody LivroRequest request) {
        Livro updated = new Livro(id, request.getTitle(), request.getAuthor(), request.getPublisher(), request.getYear());
        int rows = repository.update(updated);
        if (rows == 0) {
            repository.insert(updated);
            return new ResponseEntity<>(updated, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteLivro(@PathVariable String id) {
        repository.deleteById(id);
    }
}

class Livro {
	private final String id;
	private String title;
	private String author;
	private String publisher;
	private Integer year;

	public Livro(String id, String title, String author, String publisher, Integer year) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.year = year;
	}

	public Livro(String title, String author, String publisher, Integer year) {
		this(UUID.randomUUID().toString(), title, author, publisher, year);
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
}

