package org.example.CleanFinance.TesteCliente;

import org.example.CleanFinance.ClassesPrincipais.Cliente;
import org.example.CleanFinance.MySql.ConnectionFactory;

import java.sql.Connection;

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
