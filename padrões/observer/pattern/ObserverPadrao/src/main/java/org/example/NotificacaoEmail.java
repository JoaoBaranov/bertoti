package org.example;

public class NotificacaoEmail implements NotificacaoObserver {
    @Override
    public void atualizar(String numeroPedido, String status) {
        System.out.printf("Email enviado: pedido %s esta com status '%s'.%n", numeroPedido, status);
    }
}
