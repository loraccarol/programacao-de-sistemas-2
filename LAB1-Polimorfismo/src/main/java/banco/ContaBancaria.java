package banco;
public class ContaBancaria {
    private String nomeCorrentista;
    protected double saldo;

    public ContaBancaria(String nome, double saldo) {
        nomeCorrentista = nome;
        this.saldo = saldo;
    }
    public double consultar() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }
    public String getNomeCorrentista() {
        return nomeCorrentista;
    }

    public String toString() {
        return "Conta de " + nomeCorrentista 
            + " com saldo de R$ " + String.format("%.2f", saldo);
    }
}