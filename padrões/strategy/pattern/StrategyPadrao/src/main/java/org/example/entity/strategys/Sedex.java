package org.example.entity.strategys;

public class Sedex implements TipoDeFrete {

    @Override
    public void calcular(double peso) {
        double taxa = 0.30;
        double valorBase = peso * 15.0;
        System.out.println("Frete SEDEX calculado! Taxa expressa de 30% aplicada. Valor: R$ "
                + String.format("%.2f", valorBase + valorBase * taxa));
    }
}
