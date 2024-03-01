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
        Cliente novoCliente = new Cliente(cliente.getNome(),cliente.getCpf(),cliente.getEmail());
        String transformarCpf = String.valueOf(novoCliente.getCpf());

        String sql = "INSERT INTO conta(saldo,cliente_nome,cliente_cpf,cliente_email,conta_ativa) VALUES (?,?,?,?,?)";
        Connection conn = connection.conectandoDB();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBigDecimal(1, BigDecimal.ZERO);
            ps.setString(2,novoCliente.getNome());
            ps.setString(3,transformarCpf);
            ps.setString(4, novoCliente.getEmail());
            ps.setBoolean(5,true);

            ps.execute();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
