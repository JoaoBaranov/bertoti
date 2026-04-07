package org.example.entity.strategys;

public class Pac implements TipoDeFrete {

    @Override
    public void calcular(double peso) {
        double taxa = 0.10;
        double valorBase = peso * 8.0;
        System.out.println("Frete PAC calculado! Taxa econômica de 10% aplicada. Valor: R$ "
                + String.format("%.2f", valorBase + valorBase * taxa));
    }
}
