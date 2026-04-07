package org.example;

public class Subject {

    private Leitura leitura;
    private Alarme alarme;
    private RegistroLog registroLog;

    public Subject(Alarme alarme, RegistroLog registroLog) {
        this.alarme = alarme;
        this.registroLog = registroLog;
    }

    public void setLeitura(Leitura leitura) {
        this.leitura = leitura;
    }

    public void atualizar() {
        alarme.atualizar(leitura);
        registroLog.atualizar(leitura);
    }
}
