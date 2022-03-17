package br.mackenzie.ps2.bancodb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.mackenzie.ps2.utils.*;

public class AppDelete {
	public static void execute() throws SQLException {
    // Solicita dados ao usuário
		long nro_titular = Long.parseLong(ES.inputString("Número de um titular já existente:"));
		
    // Conecta no banco de dados
    String url = Config.URL;
		String user = Config.USER;
		String pwd = Config.PASSWORD;
		Connection conexao = DriverManager.getConnection(url, user, pwd);
		
    // Executa comando de delete no banco de dados
    String sql = "DELETE FROM titulares WHERE nro_titular=?";
		PreparedStatement prepstm = conexao.prepareStatement(sql);
		prepstm.setLong(1, nro_titular);
		int ret = prepstm.executeUpdate();

    // Exibe resultado ao usuário
		ES.print("Número de registros apagados: " + ret);
		conexao.close();
	}
}
