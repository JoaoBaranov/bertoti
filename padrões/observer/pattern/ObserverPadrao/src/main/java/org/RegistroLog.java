package org;

public class RegistroLog implements Observer {

    @Override
    public void atualizar(Leitura leitura) {
        System.out.println("LOG registrado - Sensor: " + leitura.getSensor()
                + " | ID: " + leitura.getId()
                + " | Temperatura: " + leitura.getTemperatura() + "°C | Local: " + leitura.getLocalizacao());
    }
}
