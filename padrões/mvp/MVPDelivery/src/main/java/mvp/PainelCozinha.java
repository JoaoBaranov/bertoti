package mvp;

public class PainelCozinha implements PedidoObserver {
    @Override
    public void atualizar(String numeroPedido, String status) {
        System.out.printf("Painel da cozinha atualizou pedido %s para: %s%n", numeroPedido, status);
    }
}
