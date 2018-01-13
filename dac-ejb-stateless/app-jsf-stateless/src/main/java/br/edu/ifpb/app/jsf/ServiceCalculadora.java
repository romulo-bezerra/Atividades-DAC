package br.edu.ifpb.app.jsf;

import br.edu.ifpb.service.shared.Calculadora;
import br.edu.ifpb.service.shared.ServiceLookup;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ServiceCalculadora {

    private Calculadora calculadora;

    @PostConstruct
    public void init() {
        calculadora = new ServiceLookup()
                .lookup("host-core", "3700",
                        "java:global/service-core-stateless/CalculadoraSimples");
    }

    private int a;
    private int b;
    private int resultadoSoma;

    public String somar() {
        this.resultadoSoma = calculadora.somar(a, b);
        return null;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getResultadoSoma() {
        return resultadoSoma;
    }

    public void setResultadoSoma(int resultadoSoma) {
        this.resultadoSoma = resultadoSoma;
    }

}
