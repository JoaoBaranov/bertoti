package org.example;

public class Main {
    public static void main(String[] args) {
        CategoriaMenuAntiPattern entradas = new CategoriaMenuAntiPattern("Entradas");
        entradas.adicionarItem(new ItemCardapioAntiPattern("Bruschetta", 18.90));
        entradas.adicionarItem(new ItemCardapioAntiPattern("Caldo de Feijao", 12.00));

        CategoriaMenuAntiPattern carnes = new CategoriaMenuAntiPattern("Carnes");
        carnes.adicionarItem(new ItemCardapioAntiPattern("Picanha na Brasa", 89.90));
        carnes.adicionarItem(new ItemCardapioAntiPattern("Frango Grelhado", 52.00));

        CategoriaMenuAntiPattern massas = new CategoriaMenuAntiPattern("Massas");
        massas.adicionarItem(new ItemCardapioAntiPattern("Spaghetti Carbonara", 45.00));
        massas.adicionarItem(new ItemCardapioAntiPattern("Lasanha Bolonhesa", 49.90));

        CategoriaMenuAntiPattern pratosPrincipais = new CategoriaMenuAntiPattern("Pratos Principais");
        pratosPrincipais.adicionarSubcategoria(carnes);
        pratosPrincipais.adicionarSubcategoria(massas);

        CategoriaMenuAntiPattern menuCompleto = new CategoriaMenuAntiPattern("Cardapio do Restaurante");
        menuCompleto.adicionarSubcategoria(entradas);
        menuCompleto.adicionarSubcategoria(pratosPrincipais);

        exibirCategoria(menuCompleto, "");
    }

    private static void exibirCategoria(CategoriaMenuAntiPattern categoria, String indentacao) {
        System.out.println(indentacao + "[" + categoria.getNome() + "]");

        for (ItemCardapioAntiPattern item : categoria.getItens()) {
            System.out.printf("%s  - %s: R$ %.2f%n", indentacao, item.getNome(), item.getPreco());
        }

        for (CategoriaMenuAntiPattern subcategoria : categoria.getSubcategorias()) {
            exibirCategoria(subcategoria, indentacao + "  ");
        }
    }
}
