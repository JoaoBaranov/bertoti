package org.example;

public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido("1024", 63.40);

        pedido.setPagamentoStrategy(new PagamentoPix());
        pedido.confirmarPagamento();

        pedido.setPagamentoStrategy(new PagamentoCartao(2));
        pedido.confirmarPagamento();

        pedido.setPagamentoStrategy(new PagamentoBoleto());
        pedido.confirmarPagamento();
    }
}
