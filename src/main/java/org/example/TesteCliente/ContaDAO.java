package org.example.TesteCliente;

import org.example.ClassesPrincipais.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ContaDAO {
    private Connection conn;

    public ContaDAO(Connection connection){
        this.conn = connection;
    }
}
