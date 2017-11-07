package com.ifpb.appbanco.infra;

import com.ifpb.appbanco.domain.Cliente;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author romulo
 */
public class ClientesJDBC {

    private Connection connection;

    public List<Cliente> todosOsClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            iniciarConexao();
            try (java.sql.Statement createStatement = this.connection.createStatement()) {
                ResultSet executeQuery = createStatement.executeQuery("Select * from cliente;");
                clientes.addAll(listarClientesDoResultSet(executeQuery));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientesJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            finalizarConexao();
        }

        return clientes;
    }

    private List<Cliente> listarClientesDoResultSet(ResultSet resultSet) throws SQLException {
        ArrayList<Cliente> clientes = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            String cpf = resultSet.getString("cpf");
            clientes.add(Cliente.of(id, cpf, nome));
        }
        return clientes;

    }

    private void iniciarConexao() {
        try {
            Class.forName("org.postgresql.Driver");
            //jdbc:postgresql://localhost:5432/dac-cliente
            this.connection = DriverManager.getConnection(
                    "jdbc:postgresql://host-banco:5432/db-cliente",
                    "postgres", "postgres");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ClientesJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void finalizarConexao() {
        if (this.connection == null) {
            return;
        }
        try {
            this.connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
