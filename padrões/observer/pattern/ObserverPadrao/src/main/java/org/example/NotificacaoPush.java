package org.example;

public class NotificacaoPush implements NotificacaoObserver {
    @Override
    public void atualizar(String numeroPedido, String status) {
        System.out.printf("Push enviado: pedido %s mudou para '%s'.%n", numeroPedido, status);
    }
}
