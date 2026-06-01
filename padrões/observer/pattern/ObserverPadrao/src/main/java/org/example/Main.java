package org.example;

public class Main {
    public static void main(String[] args) {
        GerenciadorPedido pedido = new GerenciadorPedido("1024");

        pedido.adicionarObserver(new NotificacaoEmail());
        pedido.adicionarObserver(new NotificacaoSMS());
        pedido.adicionarObserver(new NotificacaoPush());

        pedido.atualizarStatus("Pagamento confirmado");
        pedido.atualizarStatus("Em preparo");
        pedido.atualizarStatus("Saiu para entrega");
    }
}
