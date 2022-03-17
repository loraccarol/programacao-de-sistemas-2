package br.mackenzie.ps2.bancodb;

import java.math.BigDecimal;
import java.sql.*;
import br.mackenzie.ps2.utils.*;

public class AppRead {
	public static void execute() throws SQLException {
    // Obtém conexão com banco de dados
		String url = Config.URL;
		String user = Config.USER;
		String pwd = Config.PASSWORD;
		Connection conexao = DriverManager.getConnection(url, user, pwd);

    // Executa consulta no banco de dados
		String sql = "SELECT * FROM titulares";
		PreparedStatement pstmtTitular = conexao.prepareStatement(sql);
		ResultSet rs = pstmtTitular.executeQuery();
    
    // Exibe dados recebidos no console
    String leftAlignFormat = "| %-13s | %-15s | %-15s | %-15s |%n"; 
    System.out.format("+---------------+-----------------+-----------------+-----------------+%n");
    System.out.format("| Nro Titular   | Nome            | RG              | CPF             |%n");
    System.out.format("+---------------+-----------------+-----------------+-----------------+%n");
    while (rs.next()) {
			long nro_titular = rs.getLong("nro_titular");
			String nome = rs.getString("nome");
      String rg = rs.getString("rg");
      String cpf = rs.getString("cpf");

      // impressao dos dados
      System.out.format(leftAlignFormat, nro_titular, nome, rg, cpf);
		}
    System.out.format("+---------------+-----------------+-----------------+-----------------+%n");
		conexao.close();
	}
}
