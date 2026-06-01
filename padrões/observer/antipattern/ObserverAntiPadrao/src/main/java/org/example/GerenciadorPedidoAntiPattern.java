package org.example;

public class GerenciadorPedidoAntiPattern {
    private final String numeroPedido;
    private final NotificacaoEmail email = new NotificacaoEmail();
    private final NotificacaoSMS sms = new NotificacaoSMS();
    private final NotificacaoPush push = new NotificacaoPush();
    private String status = "Criado";

    public GerenciadorPedidoAntiPattern(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public void atualizarStatus(String status) {
        this.status = status;
        email.enviar(numeroPedido, this.status);
        sms.enviar(numeroPedido, this.status);
        push.enviar(numeroPedido, this.status);
    }
}
