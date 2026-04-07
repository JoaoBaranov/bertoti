package org.example.entity.strategys;

public class Retirada implements TipoDeFrete {

    @Override
    public void calcular(double peso) {
        System.out.printf("Retirada em loja selecionada! Frete grátis para o pacote de %.2f kg.%n", peso);
    }
}
