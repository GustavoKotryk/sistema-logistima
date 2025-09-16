package view;

import dao.PedidoDAO;
import model.Pedido;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PedidoView {

    private PedidoDAO pedidoDAO = new PedidoDAO();
    private Scanner sc = new Scanner(System.in);

    public void menu() throws SQLException {
        int opcao;
        do {
            System.out.println("\n=== MENU PEDIDO ===");
            System.out.println("1 - Adicionar Pedido");
            System.out.println("2 - Listar Pedido");
            System.out.println("3 - Buscar Pedido por ID");
            System.out.println("4 - Editar Pedido");
            System.out.println("5 - Remover Pedido");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    adicionarPedido();
                    break;
                case 2:
                    listarPedido();
                    break;
                case 3:
                    buscarPedidoPorId();
                    break;
                case 4:
                    editarPedido();
                    break;
                case 5:
                    removerPedido();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void adicionarPedido() throws SQLException {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Endereço: ");
        String endereco = sc.nextLine();
        System.out.print("Cidade: ");
        String cidade = sc.nextLine();
        System.out.print("Estado: ");
        String estado = sc.nextLine();


        Pedido pedido = new Pedido(0, nome, cpf, endereco, cidade, estado);
        pedidoDAO.adicionar(pedido);
    }

    private void listarPedido() throws SQLException {
        List<Pedido> pedidos = pedidoDAO.listar();
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }
        System.out.println("Fim da lista de pedidos.");
    }

    private void buscarPedidoPorId() throws SQLException {
        System.out.print("Digite o ID do pedido: ");
        int id = sc.nextInt();
        sc.nextLine();
        Pedido pedido = pedidoDAO.buscarPorId(id);
        if (pedido != null) {
            System.out.println(pedido);
        }
    }

    private void editarPedido() throws SQLException {
        System.out.print("Digite o ID do pedido: ");
        int id = sc.nextInt();
        sc.nextLine();
        Pedido pedido = pedidoDAO.buscarPorId(id);
        if (pedido != null) {
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("CPF: ");
            String cpf = sc.nextLine();
            String endereco = sc.nextLine();
            String cidade = sc.nextLine();
            String estado = sc.nextLine();

            pedido.setNome(nome);
            pedido.setCpf(cpf);
            pedido.setEndereco(endereco);
            pedido.setCidade(cidade);
            pedido.setEstado(estado);

            pedidoDAO.editar(pedido);
            System.out.println("Pedido editado com sucesso!");
        }
    }

    private void removerPedido() throws SQLException{
        System.out.print("Digite o ID do pedido: ");
        int id = sc.nextInt();
        sc.nextLine();
        Pedido pedido = pedidoDAO.buscarPorId(id);
        if (pedido != null){
            removerPedido();
        }
    }
}