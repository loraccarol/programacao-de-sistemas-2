package banco;

public class ContaEspecial extends ContaBancaria {
    private double limite;

    public ContaEspecial(String nome, double saldo, double limite) {
        super(nome, saldo);
        this.limite = limite;
    }
    public double consultarLimite() {
        return limite;
    }

    public void alterarLimite(double limite) {
        this.limite = limite;
    }

    public boolean sacar(double valor) {
        if (valor <= saldo+limite) {
            saldo -= valor;
            return true;
        }
        return false;
    }
    public String toString() {
        return super.toString() 
            + " e com limite de R$ " + String.format("%.2f", limite);
    }    
}