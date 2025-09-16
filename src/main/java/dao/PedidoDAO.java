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
            smt.setDate(2, java.sql.Date.valueOf(String.valueOf(pedido.getDataPedido())));
            smt.setDouble(3, pedido.getVolumeM3());
            smt.setDouble(4, pedido.getPesoKg());
            smt.setString(5, pedido.getStatus().toString());

            smt.executeUpdate();
            System.out.println("Pedido adicionado com sucesso!");
        } catch (SQLException e) {
            throw new SQLException("Erro ao adicionar pedido: " + e.getMessage(), e);
        }

    }

    public List<Pedido> listar() throws SQLException {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT id, cliente_id, data_pedido, volume_m3, peso_kg, status FROM pedido";
        return pedidos;
    }

    public Pedido buscarPorId(int id) throws SQLException {

        return null;
    }

    public void editar(Pedido pedido) throws SQLException {

        String sql = "UPDATE pedido SET cliente_id = ?, data_pedido = ?, volume_m3 = ?, peso_kg = ?, status = ? WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
        PreparedStatement smt = conn.prepareStatement(sql)) {

            smt.setInt(1, pedido.getClienteId());
            smt.setDate(2, java.sql.Date.valueOf(String.valueOf(pedido.getDataPedido())));
            smt.setDouble(3, pedido.getVolumeM3());
            smt.setDouble(4, pedido.getPesoKg());
            smt.setString(5, pedido.getStatus().toString());
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
        }
    }
}
