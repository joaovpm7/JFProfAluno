
package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.BancoDados;


public class UsuarioControle {
    
    public static long ExisteUsuario(String login,
            String senha) {

        try {
            Connection conn = BancoDados.getConexao();
            String sql = "SELECT id FROM tb_usuario ";
            sql += " WHERE login = ? ";
            sql += " AND senha = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                long cod = rs.getInt("id");
                if (cod > 0) {
                    return cod;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
}
