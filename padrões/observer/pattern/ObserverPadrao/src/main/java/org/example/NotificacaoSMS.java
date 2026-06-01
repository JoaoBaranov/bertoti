package org.example;

public class NotificacaoSMS implements NotificacaoObserver {
    @Override
    public void atualizar(String numeroPedido, String status) {
        System.out.printf("SMS enviado: pedido %s atualizado para '%s'.%n", numeroPedido, status);
    }
}
