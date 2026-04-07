package org.example;

public class RegistroLog {

    public void atualizar(Leitura leitura) {
        System.out.println("LOG registrado - Sensor: " + leitura.getSensor()
                + " | Temperatura: " + leitura.getTemperatura() + "°C | Local: " + leitura.getLocalizacao());
    }
}
