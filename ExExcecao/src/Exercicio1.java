import static javax.swing.JOptionPane.*;

public class Exercicio1 {
    public static void main(String[] args) {
        String msg;
        double[] notas = {8.5, 7.5, 9.5};
        boolean repetir = false;
        do {
            try {
                String s = showInputDialog("Qual nota deseja consultar? (0, 1 ou 2) ");
                int i = Integer.parseInt(s);
                double n = notas[i];
                msg = "Nota: " + n;
                showMessageDialog(null, msg);
                repetir = false;
            } catch (Exception ex) {
                showMessageDialog(null, "Valor inválido!");
                repetir = true;
            }
        } while(repetir);
    }
}

