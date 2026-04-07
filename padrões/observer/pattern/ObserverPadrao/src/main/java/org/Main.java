package org;

public class Main {

    public static void main(String[] args) {
        Subject sub = new Subject();
        Alarme alarme = new Alarme();
        RegistroLog log = new RegistroLog();

        Leitura leitura01 = new Leitura("Sensor-01", 1, 92.3, "Sala de Servidores");

        sub.addObserver(alarme);
        sub.addObserver(log);

        sub.notificar(leitura01);
    }
}
