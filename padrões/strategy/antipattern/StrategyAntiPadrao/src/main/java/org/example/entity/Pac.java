package org.example.entity;

public class Pac extends Frete {

    @Override
    public void calcular(double peso) {
        System.out.println("Frete PAC calculado! Taxa econômica de 10% aplicada.");
    }
}
