package org;

public class Leitura {

    private String sensor;
    private Integer id;
    private Double temperatura;
    private String localizacao;

    public Leitura(String sensor, Integer id, Double temperatura, String localizacao) {
        this.sensor = sensor;
        this.id = id;
        this.temperatura = temperatura;
        this.localizacao = localizacao;
    }

    public String getSensor() {
        return sensor;
    }

    public Integer getId() {
        return id;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public String getLocalizacao() {
        return localizacao;
    }
}
