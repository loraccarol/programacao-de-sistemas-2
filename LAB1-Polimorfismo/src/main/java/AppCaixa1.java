import static utils.ES.*;
import banco.ContaBancaria;

public class AppCaixa1 {
    private static ContaBancaria conta = new ContaBancaria("Bob", 100.00);
    
    public static void main(String[] args) {
        print("## CAIXA ELETRÔNICA v1");
        boolean sair = false;
        while (!sair) {
            print("\n## MENU PRINCIPAL");
            print("(1) Consultar");
            print("(2) Depositar");
            print("(3) Sacar");
            print("(4) Mostrar informações da conta");
            print("(5) Sair");
            int opcao = inputInt("\n## Escolha uma opção do menu:");
            if (opcao == 1) {
                opcaoConsultar();
            } 
            else if (opcao == 2) {
                opcaoDepositar();
            } 
            else if (opcao == 3) {
                opcaoSacar();
            } 
            else if (opcao == 4) {
                opcaoMostrarInfo();
            }
            else if (opcao == 5) {
                sair = true;
            } 
            else {
                print("\n## OPÇÃO INVÁLIDA!");
            }
        }
        print("\n## Obrigado por usar nossos serviços!");
    }
    
    private static void opcaoConsultar() {
        print("\n## Saldo da conta: R$ " + conta.consultar());        
    }
    
    private static void opcaoDepositar() {
        double v = inputDouble("\n## Valor para depósito:");
        conta.depositar(v);
        print("\n## Depósito efetuado!");        
    }

    private static void opcaoSacar() {
        double v = inputDouble("\n## Valor para saque:");
        if (conta.sacar(v)) {
            print("\n## Saque efetuado!");        
        }
        else {
            print("\n## Saldo insuficiente para efetuar o saque!");
        }
    }
        
    private static void opcaoMostrarInfo() {
        print("\n## Informações da conta:");
        print(conta.toString());
    }
}