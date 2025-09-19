package view;

import dao.PedidoDAO;
import model.Pedido;
import model.StatusPedido;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PedidoView {

    private final PedidoDAO pedidoDAO = new PedidoDAO();
    private final Scanner sc = new Scanner(System.in);

    public void menu() throws SQLException {
        int opcao;
        do {
            System.out.println("\n=== MENU PEDIDO ===");
            System.out.println("1 - Adicionar Pedido");
            System.out.println("2 - Listar Pedidos");
            System.out.println("3 - Buscar Pedido por ID");
            System.out.println("4 - Editar Pedido");
            System.out.println("5 - Remover Pedido");
            System.out.println("0 - Voltar");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> adicionarPedido();
                case 2 -> listarPedido();
                case 3 -> buscarPedidoPorId();
                case 4 -> editarPedido();
                case 5 -> removerPedido();
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void adicionarPedido() throws SQLException {
        System.out.print("ID do Cliente: ");
        int clienteId = sc.nextInt();
        sc.nextLine();

        System.out.print("Data do Pedido (AAAA-MM-DD): ");
        String dataStr = sc.nextLine();
        Date dataPedido = Date.valueOf(dataStr);

        System.out.print("Volume (m³): ");
        double volume = sc.nextDouble();

        System.out.print("Peso (kg): ");
        double peso = sc.nextDouble();
        sc.nextLine();

        System.out.print("Status (PENDENTE, ENTREGUE, CANCELADO): ");
        String statusStr = sc.nextLine().toUpperCase();
        StatusPedido status = StatusPedido.valueOf(statusStr);

        Pedido pedido = new Pedido(0, clienteId, dataPedido, volume, peso, status.name());
        pedidoDAO.adicionar(pedido);

        System.out.println("Pedido adicionado com sucesso!");
    }

    private void listarPedido() throws SQLException {
        List<Pedido> pedidos = pedidoDAO.listar();
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido encontrado.");
        } else {
            for (Pedido pedido : pedidos) {
                System.out.println("ID: " + pedido.getId()
                        + " | Cliente ID: " + pedido.getClienteId()
                        + " | Data: " + pedido.getDataPedido()
                        + " | Volume: " + pedido.getVolumeM3() + " m³"
                        + " | Peso: " + pedido.getPesoKg() + " kg"
                        + " | Status: " + pedido.getStatus());
            }
        }
        System.out.println("Fim da lista de pedidos.");
    }

    private void buscarPedidoPorId() throws SQLException {
        System.out.print("Digite o ID do pedido: ");
        int id = sc.nextInt();
        sc.nextLine();

        Pedido pedido = pedidoDAO.buscarPorId(id);
        if (pedido != null) {
            System.out.println("=== Pedido Encontrado ===");
            System.out.println("ID: " + pedido.getId());
            System.out.println("Cliente ID: " + pedido.getClienteId());
            System.out.println("Data: " + pedido.getDataPedido());
            System.out.println("Volume: " + pedido.getVolumeM3() + " m³");
            System.out.println("Peso: " + pedido.getPesoKg() + " kg");
            System.out.println("Status: " + pedido.getStatus());
        } else {
            System.out.println("Pedido não encontrado!");
        }
    }

    private void editarPedido() throws SQLException {
        System.out.print("Digite o ID do pedido: ");
        int id = sc.nextInt();
        sc.nextLine();

        Pedido pedido = pedidoDAO.buscarPorId(id);
        if (pedido != null) {
            System.out.print("Novo Status (PENDENTE, ENTREGUE, CANCELADO): ");
            String statusStr = sc.nextLine().toUpperCase();
            StatusPedido status = StatusPedido.valueOf(statusStr);

            pedido.setStatus(status.name());
            pedidoDAO.editar(pedido);

            System.out.println("Pedido editado com sucesso!");
        } else {
            System.out.println("Pedido não encontrado!");
        }
    }

    private void removerPedido() throws SQLException {
        System.out.print("Digite o ID do pedido: ");
        int id = sc.nextInt();
        sc.nextLine();

        Pedido pedido = pedidoDAO.buscarPorId(id);
        if (pedido != null) {
            pedidoDAO.remover(id);
            System.out.println("Pedido removido com sucesso!");
        } else {
            System.out.println("Pedido não encontrado!");
        }
    }
}
