package view;

import java.util.ArrayList;
import java.util.Scanner;
import moder.Produto;

public class NotaDeVenda {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Produto> produtos = new ArrayList<>();

        System.out.println("Cadastro de produtos vendidos (Digite 'sair' para encerrar):");
        while (true) {
            System.out.print("Nome do produto: ");
            String nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.print("Preço unitário: ");
            double preco = scanner.nextDouble();

            System.out.print("Quantidade vendida: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            produtos.add(new Produto(nome, preco, quantidade));
        }

        System.out.println("\nEscolha a forma de pagamento:");
        System.out.println("1. Cartão de Crédito (5% de juros)");
        System.out.println("2. Cartão de Débito (sem juros e sem desconto)");
        System.out.println("3. Dinheiro/Pix (5% de desconto)");

        int opcaoPagamento = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        String formaPagamento = "";
        double jurosOuDesconto = 0;
        switch (opcaoPagamento) {
            case 1:
                formaPagamento = "Cartão de Crédito";
                jurosOuDesconto = 0.05; // 5% juros
                break;
            case 2:
                formaPagamento = "Cartão de Débito";
                jurosOuDesconto = 0; // Sem juros ou desconto
                break;
            case 3:
                formaPagamento = "Dinheiro/Pix";
                jurosOuDesconto = -0.05; // 5% desconto
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }

        double valorTotal = 0;
        System.out.println("\nNota de Venda:");
        System.out.println("-------------------------------------------------");
        for (Produto produto : produtos) {
            double precoTotal = produto.calcularPrecoTotal();
            valorTotal += precoTotal;
            System.out.printf("%s - %d x R$ %.2f = R$ %.2f%n",
                    produto.getNome(), produto.getQuantidade(), produto.getPreco(), precoTotal);
        }

        double valorFinal = valorTotal + (valorTotal * jurosOuDesconto);

        System.out.println("-------------------------------------------------");
        System.out.printf("Forma de pagamento: %s%n", formaPagamento);
        System.out.printf("Valor total: R$ %.2f%n", valorTotal);
        System.out.printf("Valor a ser pago: R$ %.2f%n", valorFinal);
        System.out.println("-------------------------------------------------");

        scanner.close();
    }
}
