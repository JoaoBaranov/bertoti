package org.example.entity;

public class Sedex extends Frete {

    @Override
    public void calcular(double peso) {
        System.out.println("Frete SEDEX calculado! Taxa expressa de 30% aplicada.");
    }
}
