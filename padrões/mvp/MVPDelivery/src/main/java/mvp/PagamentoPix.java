package mvp;

public class PagamentoPix implements PagamentoStrategy {
    @Override
    public void pagar(double valor) {
        System.out.printf("Pagamento via Pix aprovado: R$ %.2f%n", valor);
    }
}
