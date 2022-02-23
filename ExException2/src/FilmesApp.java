import java.io.*;
import java.nio.file.*;
import static javax.swing.JOptionPane.*;

public class FilmesApp {
    public static void main(String[] args) {
        boolean repetir = true;
        do {
            String s = showInputDialog("Consultar filme da linha: ");
            try {
                int linha = Integer.parseInt(s);
                String nome = Filmes.consultar(linha - 1);
                showMessageDialog(null, nome);
                repetir = false;
            } catch (ArrayIndexOutOfBoundsException aib) {
                showMessageDialog(null, "Valor inválido!");
                repetir = true;
            } catch (NumberFormatException nfe) {
                showMessageDialog(null, "Por favor, entre um número!");
                repetir = true;
            } catch (IOException ex) {
                showMessageDialog(null, "Problema ao acessar os filmes!");
                repetir = true;
            }
        } while (repetir);

    }
}

class Filmes{
    public static String consultar(int indice) throws IOException{
        Path arquivo = Paths.get("filmes.txt");
        String[] nomesFilmes = Files.readAllLines(arquivo).toArray(new String[0]);
        return nomesFilmes[indice];
    }
}
