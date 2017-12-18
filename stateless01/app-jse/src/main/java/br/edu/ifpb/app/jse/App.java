package br.edu.ifpb.app.jse;

import br.edu.ifpb.service.shared.Calculadora;
import br.edu.ifpb.service.shared.ServiceLookup;

public class App {

    public static void main(String[] args) {

        Calculadora calc = new ServiceLookup()
                .lookup("java:global/service-core/CalculadoraSimples");

        System.out.println("A soma é: " + calc.somar(10, 10));

    }

    
}
