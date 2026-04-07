package org.example;

public class Alarme {

    public void atualizar(Leitura leitura) {
        System.out.println("ALARME DISPARADO! Sensor: " + leitura.getSensor()
                + " - Temperatura: " + leitura.getTemperatura() + "°C em " + leitura.getLocalizacao());
    }
}
