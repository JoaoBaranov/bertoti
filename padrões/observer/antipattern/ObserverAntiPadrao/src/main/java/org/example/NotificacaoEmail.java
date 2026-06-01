package org.example;

public class NotificacaoEmail {
    public void enviar(String numeroPedido, String status) {
        System.out.printf("Email enviado: pedido %s esta com status '%s'.%n", numeroPedido, status);
    }
}
