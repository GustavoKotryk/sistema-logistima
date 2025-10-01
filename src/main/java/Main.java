import view.ClienteView;
import view.PedidoView;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1 - Gestão de Clientes");
            System.out.println("2 - Gestão de Motoristas");
            System.out.println("3 - Gestão de Pedidos");
            System.out.println("4 - Gestão de Entregas");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    ClienteView clienteView = new ClienteView();
                    clienteView.menu();
                }
                case 2 -> {
                    System.out.println("🚧 Em desenvolvimento...");
                }
                case 3 -> {
                    PedidoView pedidoView = new PedidoView();
                    pedidoView.menu();
                }
                case 4 -> {
                    System.out.println("Em desenvolvimento...");
                }
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("⚠Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}
