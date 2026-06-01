package org.example;

public class ItemCardapioAntiPattern {
    private final String nome;
    private final double preco;

    public ItemCardapioAntiPattern(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
