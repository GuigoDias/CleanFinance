package org.example;

import org.example.MySql.ConnectionFactory;
import org.example.TesteCliente.ContaService;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    private static ContaService service = new ContaService();
    private static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Digite o nome do cliente:");
        String nome = teclado.toString();
        System.out.println("Digite o cpf do cliente:");
        int cpf = teclado.nextInt();
        System.out.println("Digite o email do cliente:");
        String email = teclado.toString();
    }
}