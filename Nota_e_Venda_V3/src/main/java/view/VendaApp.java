





import java.util.Scanner;
import moder.ItemVenda;
import moder.Produto;
import view.NotaDeVenda;

public class VendaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NotaDeVenda notaDeVenda = new NotaDeVenda();

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

            Produto produto = new Produto(nome, preco, quantidade);
            ItemVenda itemVenda = new ItemVenda(produto, quantidade);
            notaDeVenda.adicionarItem(itemVenda);
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

        notaDeVenda.definirFormaPagamento(formaPagamento, jurosOuDesconto);
        notaDeVenda.exibirNota();

        scanner.close();
    }
}
