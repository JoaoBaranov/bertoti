package org.example;

public class Pedido {
    private final String numero;
    private final double valorTotal;
    private PagamentoStrategy pagamentoStrategy;

    public Pedido(String numero, double valorTotal) {
        this.numero = numero;
        this.valorTotal = valorTotal;
    }

    public void setPagamentoStrategy(PagamentoStrategy pagamentoStrategy) {
        this.pagamentoStrategy = pagamentoStrategy;
    }

    public void confirmarPagamento() {
        if (pagamentoStrategy == null) {
            throw new IllegalStateException("Forma de pagamento nao definida.");
        }
        System.out.println("Pedido " + numero);
        pagamentoStrategy.pagar(valorTotal);
    }
}
