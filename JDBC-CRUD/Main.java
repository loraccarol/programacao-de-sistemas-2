import br.mackenzie.ps2.bancodb.*;
import br.mackenzie.ps2.utils.*;
import java.sql.*;

class Main {
  public static void main(String[] args) {
    try{
      int opt;
      
      do {
        ES.print("\n==================");
        ES.print("Escolha uma opção");
        ES.print("==================");
        ES.print("1 - Create");
        ES.print("2 - Read");
        ES.print("3 - Update");
        ES.print("4 - Delete");
        ES.print("9 - Sair");

        opt = ES.inputInt("opção:");

        switch(opt) {
          case 1:
            AppCreate.execute();
            break;
          case 2:
            AppRead.execute();
            break;
          case 3:
            AppUpdate.execute();
            break;
          case 4:
            AppDelete.execute();
            break;
          case 9:
            ES.print("Até logo");
            break;
          default:
            ES.print("Opção inválida");
        }
      } while(opt != 9);
      
    } catch(SQLException ex) {
      ex.printStackTrace();
    }
  }
}