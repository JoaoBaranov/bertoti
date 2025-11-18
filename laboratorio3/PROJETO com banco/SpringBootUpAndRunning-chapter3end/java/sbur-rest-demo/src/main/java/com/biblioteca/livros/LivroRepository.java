package com.biblioteca.livros;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LivroRepository {
    private final JdbcTemplate jdbcTemplate;

    private static final RowMapper<Livro> LIVRO_ROW_MAPPER = (rs, rowNum) ->
            new Livro(rs.getString("id"), rs.getString("title"), rs.getString("author"), 
                    rs.getString("publisher"), rs.getInt("year"));

    public LivroRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Livro> findAll() {
        return jdbcTemplate.query("SELECT id, title, author, publisher, year FROM books ORDER BY title", LIVRO_ROW_MAPPER);
    }

    public Optional<Livro> findById(String id) {
        try {
            Livro livro = jdbcTemplate.queryForObject(
                    "SELECT id, title, author, publisher, year FROM books WHERE id = ?",
                    LIVRO_ROW_MAPPER,
                    id
            );
            return Optional.ofNullable(livro);
        } catch (EmptyResultDataAccessException ex) {
            return Optional.empty();
        }
    }

    public Livro insert(Livro livro) {
        jdbcTemplate.update(
                "INSERT INTO books (id, title, author, publisher, year) VALUES (?, ?, ?, ?, ?)",
                livro.getId(),
                livro.getTitle(),
                livro.getAuthor(),
                livro.getPublisher(),
                livro.getYear()
        );
        return livro;
    }

    public int update(Livro livro) {
        return jdbcTemplate.update(
                "UPDATE books SET title = ?, author = ?, publisher = ?, year = ? WHERE id = ?",
                livro.getTitle(),
                livro.getAuthor(),
                livro.getPublisher(),
                livro.getYear(),
                livro.getId()
        );
    }

    public int deleteById(String id) {
        return jdbcTemplate.update("DELETE FROM books WHERE id = ?", id);
    }
}

