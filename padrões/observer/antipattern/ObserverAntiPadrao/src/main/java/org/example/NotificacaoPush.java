package org.example;

public class NotificacaoPush {
    public void enviar(String numeroPedido, String status) {
        System.out.printf("Push enviado: pedido %s mudou para '%s'.%n", numeroPedido, status);
    }
}
