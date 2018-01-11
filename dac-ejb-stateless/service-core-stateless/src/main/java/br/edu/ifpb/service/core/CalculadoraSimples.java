
package br.edu.ifpb.service.core;

import br.edu.ifpb.service.shared.Calculadora;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(Calculadora.class)
public class CalculadoraSimples implements Calculadora {

    @Override
    public int somar(int a, int b) {
        return a + b;
    }

    @Override
    public int subtrair(int a, int b) {
        return a - b;
    }

}
