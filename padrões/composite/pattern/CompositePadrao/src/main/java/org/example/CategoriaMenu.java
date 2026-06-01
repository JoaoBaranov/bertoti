package org.example;

import java.util.ArrayList;
import java.util.List;

public class CategoriaMenu implements ComponenteMenu {
    private final String nome;
    private final List<ComponenteMenu> filhos = new ArrayList<>();

    public CategoriaMenu(String nome) {
        this.nome = nome;
    }

    public void adicionar(ComponenteMenu componente) {
        filhos.add(componente);
    }

    public void remover(ComponenteMenu componente) {
        filhos.remove(componente);
    }

    @Override
    public void exibir(String indentacao) {
        System.out.println(indentacao + "[" + nome + "]");
        for (ComponenteMenu filho : filhos) {
            filho.exibir(indentacao + "  ");
        }
    }

    @Override
    public double getPreco() {
        return filhos.stream()
                .mapToDouble(ComponenteMenu::getPreco)
                .sum();
    }
}
