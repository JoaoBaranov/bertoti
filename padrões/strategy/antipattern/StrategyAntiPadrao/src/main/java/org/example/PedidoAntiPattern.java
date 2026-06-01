package org.example;

public class PedidoAntiPattern {
    private final String numero;
    private final double valorTotal;

    public PedidoAntiPattern(String numero, double valorTotal) {
        this.numero = numero;
        this.valorTotal = valorTotal;
    }

    public void confirmarPagamento(String formaPagamento) {
        System.out.println("Pedido " + numero);

        if ("pix".equalsIgnoreCase(formaPagamento)) {
            System.out.printf("Pagamento via Pix aprovado: R$ %.2f%n%n", valorTotal);
        } else if ("cartao".equalsIgnoreCase(formaPagamento)) {
            System.out.printf("Pagamento no cartao aprovado: R$ %.2f%n%n", valorTotal);
        } else if ("boleto".equalsIgnoreCase(formaPagamento)) {
            System.out.printf("Boleto gerado no valor de R$ %.2f%n%n", valorTotal);
        } else {
            throw new IllegalArgumentException("Forma de pagamento desconhecida: " + formaPagamento);
        }
    }
}
