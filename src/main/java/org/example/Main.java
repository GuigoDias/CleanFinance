package org.example;

import org.example.ClassesPrincipais.Cliente;
import org.example.TesteCliente.ContaService;
import org.example.TesteCliente.ControleDeCadastro;

public class Main {
    private static ContaService service = new ContaService();
    public static void main(String[] args) {
        Cliente cliente = ControleDeCadastro.controlandoDados();
        service.criarConta(cliente);
    }
}
