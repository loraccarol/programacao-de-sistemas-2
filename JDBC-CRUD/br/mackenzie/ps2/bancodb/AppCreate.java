package br.mackenzie.ps2.bancodb;

import java.math.BigDecimal;
import java.sql.*;
import br.mackenzie.ps2.utils.*;

public class AppCreate {
  public static void execute() throws SQLException {
    // Recebe dados do usuário
    long nro_titular = Long.parseLong(ES.inputString("Número para a nova conta:"));
    String nome = new String(ES.inputString("Nome da nova conta:"));
    String rg = new String(ES.inputString("RG da nova conta:"));
    String cpf = new String(ES.inputString("CPF da nova conta:"));

    // Cria conexão com o banco de dados
    String url = Config.URL;
    String user = Config.USER;
    String pwd = Config.PASSWORD;
    // ClassNotFoundException
    Connection conexao = DriverManager.getConnection(url, user, pwd);

    // Executa comand de inserir no banco de dados
    String sqlTitulares = "INSERT INTO titulares VALUES (?,?,?,?)";
    PreparedStatement pstmtTitular = conexao.prepareStatement(sqlTitulares);
    pstmtTitular.setLong(1, nro_titular);
    pstmtTitular.setString(2, nome);
    pstmtTitular.setString(3, rg);
    pstmtTitular.setString(4, cpf);
    int ret = pstmtTitular.executeUpdate();

    // Exibe o resultado
    ES.print("Número de registros inseridos: " + ret);
    conexao.close();
    
  }
}