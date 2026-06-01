package org.example;

public class Main {
    public static void main(String[] args) {
        PedidoAntiPattern pedido = new PedidoAntiPattern("1024", 63.40);

        pedido.confirmarPagamento("pix");
        pedido.confirmarPagamento("cartao");
        pedido.confirmarPagamento("boleto");
    }
}
