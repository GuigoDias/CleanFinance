package org.example.TesteCliente;

import org.example.ClassesPrincipais.Cliente;

import java.util.Scanner;

public class ControleDeCadastro {
    private static Scanner teclado = new Scanner(System.in);

    public static Cliente controlandoDados() {
        System.out.println("Digite o nome do cliente:");
        String nome = teclado.nextLine();
        testandoNome(nome);

        System.out.println("Digite o cpf do cliente:");
        String cpf = teclado.nextLine();
        testandoCpf(cpf);

        System.out.println("Digite o email do cliente:");
        String email = teclado.nextLine();
        testandoEmail(email);

        return new Cliente(nome,cpf,email);
    }

    private static void testandoNome(String nome){
        if (nome.length() > 50 || nome == "") {
            throw new RuntimeException("O nome deve possuir até 50 caracteres!");
        }
    }

    private static void testandoCpf(String cpf){
        String cpfPrimeiraValidacao = testandoCpfVirgulaOuHifem(cpf);
        if (contemCaracterEspecial(cpfPrimeiraValidacao) ||
                contemLetras(cpfPrimeiraValidacao) ||
                cpfPrimeiraValidacao.length() != 11) {
            throw new RuntimeException("O campo cpf deve possuir apenas 11 números!");
        }
    }

    private static String testandoCpfVirgulaOuHifem(String cpf){
        if (cpf.length() > 11){
            String novoCpf = cpf
                    .replace(",","")
                    .replace("-","")
                    .replace(".","");
            return novoCpf;
        }
        else {
            return cpf;
        }
    }

    private static void testandoEmail(String email){
        if (email == "") {
            throw new RuntimeException("O campo email não pode ser vazio!");
        }
    }

    private static boolean contemCaracterEspecial(String entrada) {
        return entrada.matches("[^a-zA-Z0-9#]");
    }

    private static boolean contemLetras(String entrada) {
        return entrada.matches(".*[a-zA-Z].*");
    }
}
