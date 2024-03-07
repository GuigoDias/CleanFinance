package org.example.TesteCliente;

import org.example.ClassesPrincipais.Cliente;
import org.example.MySql.ConnectionFactory;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContaDAO {
    private Connection connection;

    ContaDAO(Connection connection) {
        this.connection = connection;
    }

    public void criandoConta(Cliente cliente) {
        Cliente novoCliente = new Cliente(cliente.getNome(), cliente.getCpf(), cliente.getEmail());
        String transformarCpf = novoCliente.getCpf()
                .replace("-","")
                .replace(".","");

        String sql = "INSERT INTO conta(saldo,cliente_nome,cliente_cpf,cliente_email,conta_ativa) VALUES (?,?,?,?,?)";


        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setBigDecimal(1, BigDecimal.ZERO);
            ps.setString(2, novoCliente.getNome());
            ps.setString(3, transformarCpf);
            ps.setString(4, novoCliente.getEmail());
            ps.setBoolean(5, true);

            ps.execute();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}