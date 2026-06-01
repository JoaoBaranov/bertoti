package mvp;

public class AppEntregador implements PedidoObserver {
    @Override
    public void atualizar(String numeroPedido, String status) {
        System.out.printf("App do entregador recebeu pedido %s com status: %s%n", numeroPedido, status);
    }
}
