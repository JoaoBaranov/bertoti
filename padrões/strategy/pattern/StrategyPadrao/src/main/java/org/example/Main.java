package org.example;

import org.example.entity.Frete;
import org.example.entity.strategys.Pac;
import org.example.entity.strategys.Retirada;
import org.example.entity.strategys.Sedex;

public class Main {
    public static void main(String[] args) {

        Frete frete = new Frete(new Retirada());

        // Frete por Retirada
        frete.calcularFrete(2.5);

        // Frete por PAC
        frete.setTipoDeFrete(new Pac());
        frete.calcularFrete(2.5);

        // Frete por SEDEX
        frete.setTipoDeFrete(new Sedex());
        frete.calcularFrete(2.5);
    }
}
