package com.ifpb.appbanco.infra;

import com.ifpb.appbanco.domain.Cliente;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author romulo
 */
public class ClientesEmMemoria {

    public List<Cliente> todosOsClientes() {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(Cliente.of(1, "123", "Kiko"));
        clientes.add(Cliente.of(2, "133", "Florinda"));
        return clientes;
    }

}
