package mvp;

public class NotificacaoCliente implements PedidoObserver {
    private final String cliente;

    public NotificacaoCliente(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public void atualizar(String numeroPedido, String status) {
        System.out.printf("Cliente %s recebeu atualizacao do pedido %s: %s%n", cliente, numeroPedido, status);
    }
}
