package org.example;

public class NotificacaoSMS {
    public void enviar(String numeroPedido, String status) {
        System.out.printf("SMS enviado: pedido %s atualizado para '%s'.%n", numeroPedido, status);
    }
}
