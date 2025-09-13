package view;

import dao.ClienteDAO;
import model.Cliente;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ClienteView {

    private ClienteDAO clienteDAO = new ClienteDAO();
    private Scanner sc = new Scanner(System.in);

    public void menu() throws SQLException {
        int opcao;
        do {
            System.out.println("\n=== MENU CLIENTE ===");
            System.out.println("1 - Adicionar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Buscar Cliente por ID");
            System.out.println("4 - Editar Cliente");
            System.out.println("5 - Remover Cliente");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    adicionarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    buscarClientePorId();
                    break;
                case 4:
                    editarCliente();
                    break;
                case 5:
                    removerCliente();
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void adicionarCliente() throws SQLException {
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


        Cliente cliente = new Cliente(0, nome, cpf, endereco, cidade, estado);
        clienteDAO.adicionar(cliente);
    }
}