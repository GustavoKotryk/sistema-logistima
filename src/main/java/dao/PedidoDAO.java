package dao;

import database.Conexao;
import model.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {
    public void adicionar(Pedido pedido) throws SQLException {
        String sql = "INSERT INTO pedido (cliente_id, data_pedido, volume_m3, peso_kg, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement smt = conn.prepareStatement(sql)) {

            smt.setInt(1, pedido.getClienteId());
            smt.setDate(2, pedido.getDataPedido()); // já vem como java.sql.Date
            smt.setDouble(3, pedido.getVolumeM3());
            smt.setDouble(4, pedido.getPesoKg());
            smt.setString(5, pedido.getStatus());

            smt.executeUpdate();
            System.out.println("Pedido adicionado com sucesso!");
        }
    }

    public List<Pedido> listar() throws SQLException {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT id, cliente_id, data_pedido, volume_m3, peso_kg, status FROM pedido";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement smt = conn.prepareStatement(sql);
             ResultSet rs = smt.executeQuery()) {

            while (rs.next()) {
                Pedido pedido = new Pedido(
                        rs.getInt("id"),
                        rs.getInt("cliente_id"),
                        rs.getDate("data_pedido"),
                        rs.getDouble("volume_m3"),
                        rs.getDouble("peso_kg"),
                        rs.getString("status")
                );
                pedidos.add(pedido);
            }
        }
        return pedidos;
    }

    public Pedido buscarPorId(int id) throws SQLException {
        String sql = "SELECT id, cliente_id, data_pedido, volume_m3, peso_kg, status FROM pedido WHERE id = ?";
        Pedido pedido = null;

        try (Connection conn = Conexao.getConnection();
             PreparedStatement smt = conn.prepareStatement(sql)) {

            smt.setInt(1, id);
            try (ResultSet rs = smt.executeQuery()) {
                if (rs.next()) {
                    pedido = new Pedido(
                            rs.getInt("id"),
                            rs.getInt("cliente_id"),
                            rs.getDate("data_pedido"),
                            rs.getDouble("volume_m3"),
                            rs.getDouble("peso_kg"),
                            rs.getString("status")
                    );
                }
            }
        }
        return pedido;
    }

    public void editar(Pedido pedido) throws SQLException {
        String sql = "UPDATE pedido SET cliente_id = ?, data_pedido = ?, volume_m3 = ?, peso_kg = ?, status = ? WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement smt = conn.prepareStatement(sql)) {

            smt.setInt(1, pedido.getClienteId());
            smt.setDate(2, pedido.getDataPedido());
            smt.setDouble(3, pedido.getVolumeM3());
            smt.setDouble(4, pedido.getPesoKg());
            smt.setString(5, pedido.getStatus());
            smt.setInt(6, pedido.getId());

            smt.executeUpdate();
            System.out.println("Pedido editado com sucesso!");
        }
    }

    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM pedido WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement smt = conn.prepareStatement(sql)) {

            smt.setInt(1, id);
            smt.executeUpdate();
            System.out.println("Pedido removido com sucesso!");
        }
    }
}
