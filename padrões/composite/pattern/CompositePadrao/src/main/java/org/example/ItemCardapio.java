package org.example;

public class ItemCardapio implements ComponenteMenu {
    private final String nome;
    private final double preco;

    public ItemCardapio(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public void exibir(String indentacao) {
        System.out.printf("%s- %s: R$ %.2f%n", indentacao, nome, preco);
    }

    @Override
    public double getPreco() {
        return preco;
    }
}
