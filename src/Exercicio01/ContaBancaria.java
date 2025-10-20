package Exercicio01;

import java.util.Scanner; // ADICIONADO: O Scanner precisa ser importado!

public class ContaBancaria {

    // 1. ATRIBUTOS (Características da Conta)
    private String nomeCliente;
    private String tipoConta;
    private double saldo;

    // 2. CONSTRUTOR
    public ContaBancaria(String nome, String tipo, double saldoInicial) {
        this.nomeCliente = nome;
        this.tipoConta = tipo;
        this.saldo = saldoInicial;
    }

    // 3. MÉTODOS (As ações que a conta pode fazer)

    public double getSaldo() {
        return this.saldo;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor > this.saldo) {
            return false;
        } else {
            this.saldo -= valor;
            return true;
        }
    }

    // MÉTODO auxiliar para exibir os dados iniciais (CORRIGIDO: FORA do main)
    public void exibirDados() {
        System.out.println("************************************************");
        System.out.println("Dados iniciais do cliente:");
        System.out.printf("Nome:        %s%n", this.nomeCliente);
        System.out.printf("Tipo conta:  %s%n", this.tipoConta);
        System.out.printf("Saldo inicial: R$ %.2f%n", this.saldo);
        System.out.println("************************************************");
    }

    // MÉTODO PRINCIPAL (EXECUTÁVEL): Este é o ponto de partida do programa
    public static void main(String[] args) {

        // 1. CRIAÇÃO DO OBJETO (Instanciação)
        ContaBancaria minhaConta = new ContaBancaria("Vanessa Santos", "Corrente", 50000.00);

        Scanner entrada = new Scanner(System.in);
        int opcao = 0;

        minhaConta.exibirDados(); // Chamando o método do objeto

        // A lógica do seu menu e loop continua aqui...
        while (opcao != 4) {
            System.out.println("\nOperações");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Receber valor (Depositar)");
            System.out.println("3 - Transferir valor (Sacar)");
            System.out.println("4 - Sair");
            System.out.print("Digite a opção desejada:");
            opcao = entrada.nextInt();

            // Lógica do Switch usando os MÉTODOS do objeto 'minhaConta'
            switch (opcao) {
                case 1:
                    System.out.printf("Seu Saldo atual é: R$ %.2f%n", minhaConta.getSaldo());
                    break;
                case 2:
                    System.out.print("Informe o valor que irá depositar: R$ ");
                    double valorDeposito = entrada.nextDouble();
                    minhaConta.depositar(valorDeposito);
                    System.out.printf("Depósito realizado. Saldo atualizado: R$ %.2f%n", minhaConta.getSaldo());
                    break;
                case 3:
                    System.out.print("Informe o valor para transferir: R$ ");
                    double valorTransferencia = entrada.nextDouble();
                    if (minhaConta.sacar(valorTransferencia)) {
                        System.out.printf("Transferência realizada. Saldo atual: R$ %.2f%n", minhaConta.getSaldo());
                    } else {
                        System.out.println("Transferência não realizada. Saldo insuficiente!");
                    }
                    break;
                case 4:
                    System.out.println("Encerrando o sistema. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
        entrada.close();
    }
}