package org.example.TesteCliente;

import org.example.ClassesPrincipais.Cliente;
import org.example.MySql.ConnectionFactory;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContaService {
    private ConnectionFactory connection;

    public ContaService(){
        this.connection = new ConnectionFactory();
    }

    public void criarConta(Cliente cliente){
        Connection conn = connection.conectandoDB();
        new ContaDAO(conn).criandoConta(cliente);
    }
}
