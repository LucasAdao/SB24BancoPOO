package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import models.Cliente;
import models.ContaCorrente;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
    	//aplicar os try catchs
        //menu com opções
        Cliente cliente = new Cliente();
        String nome = "a";
        
        while(true) {
        
        System.out.println("Bem vindo ao banco Santander!! \nPara Continuar Insira seu nome:");
        nome = sc.nextLine();
        if(nome.length() > 3) {
        	cliente.setNome(nome);
        	break;
        }else {
        	System.out.println("Seu nome deve conter mais de 3 caracteres!");
        }
        }
        System.out.println("Muito bem " + nome + " insira sua idade:");
        while(true) {
        try {
        	int idade = sc.nextInt();
        	cliente.setIdade(idade);
        	break;
        }catch(InputMismatchException e) {
        	System.out.println("Digite apenas números para cadastrar a idade!");
        }
        }
        if(cliente.getIdade()<18) {
        	System.out.println("Você precisa ter mais de 18 anos para ter uma conta no banco!");
        	System.exit(0);
        }
        ContaCorrente cc = new ContaCorrente(cliente);
        cc.imprimirExtrato();
    }
}
