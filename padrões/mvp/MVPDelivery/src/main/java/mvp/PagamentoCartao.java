package mvp;

public class PagamentoCartao implements PagamentoStrategy {
    private final int parcelas;

    public PagamentoCartao(int parcelas) {
        this.parcelas = parcelas;
    }

    @Override
    public void pagar(double valor) {
        System.out.printf("Pagamento no cartao aprovado em %d parcela(s): R$ %.2f%n", parcelas, valor);
    }
}
