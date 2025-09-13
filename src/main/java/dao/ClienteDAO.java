package dao;

import database.Conexao;
import model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void adicionar(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (nome, cpf, endereco, cidade, estado) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
        PreparedStatement smt = conn.prepareStatement(sql)) {

            smt.setString(1, cliente.getNome());
            smt.setString(2, cliente.getCpf());
            smt.setString(3, cliente.getEndereco());
            smt.setString(4, cliente.getCidade());
            smt.setString(5, cliente.getEstado());

            smt.executeUpdate();
            System.out.println("Cliente adicionado com sucesso!");
        } catch (SQLException e) {
            throw new SQLException("Erro ao adicionar cliente: " + e.getMessage(), e);
        }
    }

    public void editar(Cliente cliente) throws SQLException{
        String sql = "UPDATE cliente SET nome = ?, cpf = ?, endereco = ?, cidade = ?, estado = ? WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
        PreparedStatement smt = conn.prepareStatement(sql)) {

            smt.setString(1, cliente.getNome());
            smt.setString(2, cliente.getCpf());
            smt.setString(3, cliente.getEndereco());
            smt.setString(4, cliente.getCidade());
            smt.setString(5, cliente.getEstado());
            smt.setInt(6, cliente.getId());

            smt.executeUpdate();
            System.out.println("Cliente editado com sucesso!");
        } catch (SQLException e) {
            throw new SQLException("Erro ao editar cliente: " + e.getMessage(), e);
        }
    }

    public List<Cliente> listar() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT id, nome, cpf, endereco, cidade, estado FROM cliente";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement smt = conn.prepareStatement(sql);
             ResultSet rs = smt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));

                clientes.add(cliente);
            }
        } catch (SQLException e) {
            throw new SQLException("Erro ao listar clientes: " + e.getMessage(), e);
        }

        return clientes;
    }

    public Cliente buscarPorId(int id) throws SQLException {
        Cliente cliente = null;
        String sql = "SELECT id, nome, cpf, endereco, cidade, estado FROM cliente WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement smt = conn.prepareStatement(sql)) {

            smt.setInt(1, id);
            ResultSet rs = smt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setEstado(rs.getString("estado"));
            }

        } catch (SQLException e) {
            throw new SQLException("Erro ao buscar cliente por ID: " + e.getMessage(), e);
        }

        return cliente;
    }

}
