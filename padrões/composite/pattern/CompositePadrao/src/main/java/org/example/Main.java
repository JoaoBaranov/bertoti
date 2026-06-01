package org.example;

public class Main {
    public static void main(String[] args) {
        CategoriaMenu menuCompleto = new CategoriaMenu("Cardapio do Restaurante");

        CategoriaMenu entradas = new CategoriaMenu("Entradas");
        entradas.adicionar(new ItemCardapio("Bruschetta", 18.90));
        entradas.adicionar(new ItemCardapio("Caldo de Feijao", 12.00));

        CategoriaMenu carnes = new CategoriaMenu("Carnes");
        carnes.adicionar(new ItemCardapio("Picanha na Brasa", 89.90));
        carnes.adicionar(new ItemCardapio("Frango Grelhado", 52.00));

        CategoriaMenu massas = new CategoriaMenu("Massas");
        massas.adicionar(new ItemCardapio("Spaghetti Carbonara", 45.00));
        massas.adicionar(new ItemCardapio("Lasanha Bolonhesa", 49.90));

        CategoriaMenu pratosPrincipais = new CategoriaMenu("Pratos Principais");
        pratosPrincipais.adicionar(carnes);
        pratosPrincipais.adicionar(massas);

        CategoriaMenu sobremesas = new CategoriaMenu("Sobremesas");
        sobremesas.adicionar(new ItemCardapio("Pudim de Leite", 15.00));
        sobremesas.adicionar(new ItemCardapio("Mousse de Chocolate", 17.00));

        menuCompleto.adicionar(entradas);
        menuCompleto.adicionar(pratosPrincipais);
        menuCompleto.adicionar(sobremesas);

        menuCompleto.exibir("");
        System.out.printf("%nValor total do cardapio: R$ %.2f%n", menuCompleto.getPreco());
    }
}
