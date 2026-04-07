package org.example;

public class Leitura {

    private String sensor;
    private Double temperatura;
    private String localizacao;

    public Leitura(String sensor, Double temperatura, String localizacao) {
        this.sensor = sensor;
        this.temperatura = temperatura;
        this.localizacao = localizacao;
    }

    public String getSensor() {
        return sensor;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public String getLocalizacao() {
        return localizacao;
    }
}
