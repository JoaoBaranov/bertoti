package org;

public class Alarme implements Observer {

    @Override
    public void atualizar(Leitura leitura) {
        System.out.println("ALARME DISPARADO! Sensor: " + leitura.getSensor()
                + " - Temperatura: " + leitura.getTemperatura() + "°C em " + leitura.getLocalizacao());
    }
}
