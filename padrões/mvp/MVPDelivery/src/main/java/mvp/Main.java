package mvp;

public class Main {
    public static void main(String[] args) {
        Combo lanche = new Combo("Combo Burger");
        lanche.adicionar(new Produto("Burger artesanal", 32.90));
        lanche.adicionar(new Produto("Batata frita", 12.00));
        lanche.adicionar(new Produto("Refrigerante", 8.50));

        Combo carrinho = new Combo("Carrinho do cliente");
        carrinho.adicionar(lanche);
        carrinho.adicionar(new Produto("Brownie", 10.00));

        Pedido pedido = new Pedido("1024", carrinho);
        pedido.adicionarObserver(new NotificacaoCliente("Ana"));
        pedido.adicionarObserver(new PainelCozinha());
        pedido.adicionarObserver(new AppEntregador());

        pedido.exibirResumo();

        pedido.setPagamentoStrategy(new PagamentoPix());
        pedido.confirmarPagamento();

        pedido.atualizarStatus("Em preparo");
        pedido.atualizarStatus("Saiu para entrega");
        pedido.atualizarStatus("Entregue");

        System.out.println("\nCliente mudou a forma de pagamento em outro pedido:");
        pedido.setPagamentoStrategy(new PagamentoCartao(2));
        pedido.confirmarPagamento();
    }
}
