package dao;

import database.Conexao;
import model.Motorista;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MotoristaDAO {
    public void adicionar(Motorista motorista) throws SQLException{
        String sql = "INSERT INTO motorista(nome, cnh, veiculo, cidade_base) VALUES(?,?,?,?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement smt = conn.prepareStatement(sql)){

            smt.setString(1, motorista.getNome());
            smt.setString(2, motorista.getCnh());
            smt.setString(3, motorista.getVeiculo());
            smt.setString(4, motorista.getCidade_base());

            smt.executeUpdate();
            System.out.print("Motorista adicionado!");
        } catch (SQLException e){
            throw new SQLException("Erro ao adicionar motorista: "+ e.getMessage(), e);
        }
    }

    public void editar(Motorista motorista) throws SQLException{
        String sql = "UPDATE cliente SET nome = ?, cnh = ?, veiculo = ?, cidade_base = ?";

        try (Connection conn = Conexao.getConnection();
        PreparedStatement smt = conn.prepareStatement(sql)){

            smt.setString(1, motorista.getNome());
            smt.setString(2, motorista.getCnh());
            smt.setString(3, motorista.getVeiculo());
            smt.setString(4, motorista.getCidade_base());

            smt.executeUpdate();
            System.out.print("Motorista editado com sucesso!");
        }catch (SQLException e){
            throw new SQLException("Erro ao editar motorista: "+ e.getMessage(), e);
        }
    }

    public List<Motorista> listar() throws SQLException{
        List<Motorista> motoristas = new ArrayList<>();
        String sql = "SELECT id_motorista, nome, cnh, veiculo, cidade_base FROM motorista";

        try(Connection conn = Conexao.getConnection();
            PreparedStatement smt = conn.prepareStatement(sql);
            ResultSet rs = smt.executeQuery()){

            while (rs.next()){
                Motorista motorista = new Motorista();
                motorista.setId_motorista(rs.getInt("id"));
                motorista.setNome(rs.getString("nome"));
                motorista.setCnh(rs.getString("cnh"));
                motorista.setVeiculo(rs.getString("veiculo"));
                motorista.setCidade_base(rs.getString("cidade_base"));

                motoristas.add(motorista);
            }
        }catch (SQLException e){
            throw  new SQLException("Erro ao listar motoristas: "+ e.getMessage(), e);
        }
        return motoristas;
    }



}
