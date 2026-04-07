package org;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    Leitura leitura;
    List<Observer> observers = new ArrayList<Observer>();

    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    public void notificar(Leitura leitura) {
        for (Observer obs : observers) {
            obs.atualizar(leitura);
        }
    }
}
