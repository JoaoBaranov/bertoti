package org.example;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorPedido {
    private final String numeroPedido;
    private final List<NotificacaoObserver> observers = new ArrayList<>();
    private String status = "Criado";

    public GerenciadorPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public void adicionarObserver(NotificacaoObserver observer) {
        observers.add(observer);
    }

    public void removerObserver(NotificacaoObserver observer) {
        observers.remove(observer);
    }

    public void atualizarStatus(String status) {
        this.status = status;
        notificarObservers();
    }

    public String getStatus() {
        return status;
    }

    private void notificarObservers() {
        for (NotificacaoObserver observer : observers) {
            observer.atualizar(numeroPedido, status);
        }
    }
}
