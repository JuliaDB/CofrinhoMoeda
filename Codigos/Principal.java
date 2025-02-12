package trabalho;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Cofrinho cofrinho = new Cofrinho();
        Scanner teclado = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1: // Adicionar moeda
                	System.out.println("===== Escolha moeda =====");
                    System.out.println("1 - Real");
                    System.out.println("2 - Dolar");
                    System.out.println("3 - Euro");
                    System.out.print("Opção: ");
                    int escolhaAdicionar = teclado.nextInt();
                    teclado.nextLine();

                    String nomeAdicionar;
                    if (escolhaAdicionar == 1) {
                        nomeAdicionar = "Real";
                    } else if (escolhaAdicionar == 2) {
                        nomeAdicionar = "Dolar";
                    } else if (escolhaAdicionar == 3) {
                        nomeAdicionar = "Euro";
                    } else {
                        System.out.println("Opção inválida.");
                        break;
                    }

                    System.out.print("Digite o valor da moeda: ");
                    double valorAdicionar = teclado.nextDouble();
                    teclado.nextLine();

                    // Declaração da variável para armazenar a moeda
                    Moeda moedaAdicionar;
                    if (nomeAdicionar.equalsIgnoreCase("Dolar")) {
                        moedaAdicionar = new Dolar(valorAdicionar);
                    } else if (nomeAdicionar.equalsIgnoreCase("Euro")) {
                        moedaAdicionar = new Euro(valorAdicionar);
                    } else {
                        moedaAdicionar = new Real(valorAdicionar);
                    }

                    cofrinho.adicionarMoeda(moedaAdicionar);
                    System.out.println("Moeda adicionada ao cofrinho.");
                    break;

                case 2: // Remover moeda
                    System.out.println("===== Remover moeda =====");
                    System.out.println("1 - Real");
                    System.out.println("2 - Dolar");
                    System.out.println("3 - Euro");
                    System.out.print("Opção: ");
                    int escolhaRemover = teclado.nextInt();
                    teclado.nextLine();

                    // Determine o nome da moeda com base na escolha
                    String nomeRemover;
                    if (escolhaRemover == 1) {
                        nomeRemover = "Real";
                    } else if (escolhaRemover == 2) {
                        nomeRemover = "Dolar";
                    } else if (escolhaRemover == 3) {
                        nomeRemover = "Euro";
                    } else {
                        System.out.println("Opção inválida.");
                        break; // Interrompe o fluxo caso a opção seja inválida
                    }

                    System.out.print("Digite o valor da moeda a ser removida: ");
                    double valorRemover = teclado.nextDouble();
                    teclado.nextLine();

                    // Usando o método que recebe nome e valor
                    if (cofrinho.removerMoeda(nomeRemover, valorRemover)) {
                        System.out.println("Moeda removida com sucesso.");
                    } else {
                        System.out.println("Moeda não encontrada.");
                    }
                    break;

                case 3: // Listar moedas
                    cofrinho.listarMoedas();
                    break;

                case 4: // Calcular valor total convertido para Real
                    double valorTotalEmReais = cofrinho.calcularValorTotalEmReais();
                    System.out.println("Valor total em reais no cofrinho: R$ " + valorTotalEmReais);
                    break;

                case 0: // Sair
                    System.out.println("~~~ Final do programa ~~~"); // Exibe a mensagem de finalização e encerra o programa
                    break;

                default: // Exibe uma mensagem de erro caso a opção digitada seja inválida
                    System.out.println("Opção inválida, digite novamente!");
                    break;
            }

        } while (opcao != 0); // Repete o loop até que a opção 0 "Sair" seja escolhida

        teclado.close(); // Fechar o scanner
    }

    // Método para exibir o menu de opções
    public static void exibirMenu() {
        System.out.println("\n====== Menu ======");
        System.out.println("1 - Adicionar moeda");
        System.out.println("2 - Remover moeda");
        System.out.println("3 - Listar moedas");
        System.out.println("4 - Calcular total convertido para Real");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }
}
