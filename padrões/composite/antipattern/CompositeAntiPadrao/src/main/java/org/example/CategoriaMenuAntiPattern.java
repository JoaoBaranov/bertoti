package org.example;

import java.util.ArrayList;
import java.util.List;

public class CategoriaMenuAntiPattern {
    private final String nome;
    private final List<ItemCardapioAntiPattern> itens = new ArrayList<>();
    private final List<CategoriaMenuAntiPattern> subcategorias = new ArrayList<>();

    public CategoriaMenuAntiPattern(String nome) {
        this.nome = nome;
    }

    public void adicionarItem(ItemCardapioAntiPattern item) {
        itens.add(item);
    }

    public void adicionarSubcategoria(CategoriaMenuAntiPattern subcategoria) {
        subcategorias.add(subcategoria);
    }

    public List<ItemCardapioAntiPattern> getItens() {
        return itens;
    }

    public List<CategoriaMenuAntiPattern> getSubcategorias() {
        return subcategorias;
    }

    public String getNome() {
        return nome;
    }
}
