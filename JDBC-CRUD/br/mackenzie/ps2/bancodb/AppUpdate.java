package br.mackenzie.ps2.bancodb;

import java.math.BigDecimal;
import java.sql.*;
import br.mackenzie.ps2.utils.*;

public class AppUpdate {
	public static void execute() throws SQLException {
    // Solicita dados ao usuário
    long nro_titular = Long.parseLong(ES.inputString("Número de uma conta já existente:"));
		String nome = new String(ES.inputString("Novo nome para esta conta:"));
		String rg = new String(ES.inputString("Novo rg para esta conta:"));
    String cpf = new String(ES.inputString("Novo cpf para esta conta:"));

    // Obtém conexão com banco de dados
    String url = Config.URL;
		String user = Config.USER;
		String pwd = Config.PASSWORD;
		Connection conexao = DriverManager.getConnection(url, user, pwd);

    // Executa atualização no banco
    String sql = "UPDATE titulares SET nome=?, rg=?, cpf=? WHERE nro_titular=?";
		PreparedStatement pstmtTitular = conexao.prepareStatement(sql);
		pstmtTitular.setString(1, nome);
		pstmtTitular.setString(2, rg);
    pstmtTitular.setString(3, cpf);
    pstmtTitular.setLong(4, nro_titular);
		int ret = pstmtTitular.executeUpdate();

    // Exibe resultado
		ES.print("Número de registros alterados: " + ret);
		conexao.close();
	}
}
