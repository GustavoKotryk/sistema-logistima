package database;

import java.sql.Connection;

public class TesteConexao {
        public static void main(String[] args) {
            try {
                Connection conn = Conexao.getConnection();
                System.out.println("✅ Conexão bem-sucedida!");
                conn.close();
            } catch (Exception e) {
                System.out.println("❌ Falha na conexão: " + e.getMessage());
            }
        }
}
