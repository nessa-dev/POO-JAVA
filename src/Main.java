import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Variáveis
        String nome = "Vanessa Santos";
        String tipoConta = "Corrente";
        double saldo = 50000;
        Scanner entrada = new Scanner(System.in);
        System.out.println("************************************************");
        System.out.println("Dados iniciais do cliente:");
        System.out.printf("Nome:        %s%n", nome);
        System.out.printf("Tipo conta:  %s%n", tipoConta);
        System.out.printf("Saldo inicial: R$ %.2f%n", saldo);
        System.out.println("************************************************");

        //Menu
        System.out.println("Operações");
        System.out.println("1 - Consultar Saldos");
        System.out.println("2 - Receber valor");
        System.out.println("3 - Transferir valor");
        System.out.println("4 - Sair");

        System.out.print("Digite a opção desejada:");
        int opcao = entrada.nextInt();

        switch (opcao) {
            case 1:
                System.out.printf("Seu Saldo atual é: R$ %.2f%n", saldo);
                break;

                case 2:
                    System.out.println("Informe o valor que irá receber:");
                    double valor = entrada.nextDouble();
                    saldo+=valor;
                    System.out.println("Saldo atualizado: " + saldo);
                    break;

            case 3:
                System.out.print("Informe o valor para transferir: R$ ");
                double valorTransferencia = entrada.nextDouble();
                if (valorTransferencia > saldo) {
                    System.out.println("Saldo insuficiente!");
                } else {
                    saldo -= valorTransferencia;
                    System.out.printf("Transferência realizada. Saldo atual: R$ %.2f%n", saldo);
                }
                break;
            case 4:
                System.out.println("Encerrando o sistema...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        entrada.close();
        }
    }
