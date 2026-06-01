package org.example;

public class PagamentoBoleto implements PagamentoStrategy {
    @Override
    public void pagar(double valor) {
        System.out.printf("Boleto gerado no valor de R$ %.2f%n%n", valor);
    }
}
