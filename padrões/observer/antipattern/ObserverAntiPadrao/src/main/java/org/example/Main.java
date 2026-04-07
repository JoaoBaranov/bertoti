package org.example;

public class Main {

    public static void main(String[] args) {
        Leitura leitura = new Leitura("Sensor-01", 85.5, "Sala de Servidores");
        Alarme alarme = new Alarme();
        RegistroLog log = new RegistroLog();
        Subject sub = new Subject(alarme, log);

        sub.setLeitura(leitura);
        sub.atualizar();
    }
}
