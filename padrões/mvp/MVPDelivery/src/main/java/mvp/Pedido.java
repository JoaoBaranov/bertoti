package mvp;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final String numero;
    private final ItemPedido carrinho;
    private final List<PedidoObserver> observers = new ArrayList<>();
    private PagamentoStrategy pagamentoStrategy;
    private String status = "Criado";

    public Pedido(String numero, ItemPedido carrinho) {
        this.numero = numero;
        this.carrinho = carrinho;
    }

    public void adicionarObserver(PedidoObserver observer) {
        observers.add(observer);
    }

    public void setPagamentoStrategy(PagamentoStrategy pagamentoStrategy) {
        this.pagamentoStrategy = pagamentoStrategy;
    }

    public void exibirResumo() {
        System.out.println("Pedido " + numero);
        carrinho.exibir("  ");
        System.out.printf("Total: R$ %.2f%n%n", carrinho.getPreco());
    }

    public void confirmarPagamento() {
        if (pagamentoStrategy == null) {
            throw new IllegalStateException("Forma de pagamento nao definida.");
        }
        pagamentoStrategy.pagar(carrinho.getPreco());
        atualizarStatus("Pagamento confirmado");
    }

    public void atualizarStatus(String status) {
        this.status = status;
        notificarObservers();
    }

    public String getStatus() {
        return status;
    }

    private void notificarObservers() {
        for (PedidoObserver observer : observers) {
            observer.atualizar(numero, status);
        }
    }
}
