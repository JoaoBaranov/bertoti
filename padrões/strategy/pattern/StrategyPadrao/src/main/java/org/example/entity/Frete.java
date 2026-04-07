package org.example.entity;

import org.example.entity.strategys.TipoDeFrete;

public class Frete {

    private TipoDeFrete tipoDeFrete;

    public Frete(TipoDeFrete tipoDeFrete) {
        this.tipoDeFrete = tipoDeFrete;
    }

    public void setTipoDeFrete(TipoDeFrete tipoDeFrete) {
        this.tipoDeFrete = tipoDeFrete;
    }

    public void calcularFrete(double peso) {
        tipoDeFrete.calcular(peso);
    }
}
