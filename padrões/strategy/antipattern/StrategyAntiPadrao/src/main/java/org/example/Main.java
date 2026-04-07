package org.example;

import java.util.Scanner;

import org.example.entity.Frete;
import org.example.entity.Pac;
import org.example.entity.Retirada;
import org.example.entity.Sedex;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o tipo de frete que deseja utilizar:");
        String tipo = sc.next();

        System.out.println("Qual o peso do pacote em kg?");
        double peso = sc.nextDouble();

        Frete frete;

        if (tipo.equalsIgnoreCase("SEDEX")) {
            frete = new Sedex();
            frete.calcular(peso);

        } else if (tipo.equalsIgnoreCase("PAC")) {
            frete = new Pac();
            frete.calcular(peso);

        } else if (tipo.equalsIgnoreCase("RETIRADA")) {
            frete = new Retirada();
            frete.calcular(peso);

        } else {
            System.out.println("Tipo de frete inválido!");
        }

        sc.close();
    }
}
