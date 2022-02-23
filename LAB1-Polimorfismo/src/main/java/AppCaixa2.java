import banco.ContaEspecial;

import static utils.ES.*;
import static utils.ES.print;

public class AppCaixa2 {

    private static ContaEspecial conta = new ContaEspecial("Carlos", 250.00, 150);

    public static void main(String[] args) {
        print("## CAIXA ELETRÔNICA v1");
        boolean sair = false;
        while (!sair) {
            print("\n## MENU PRINCIPAL");
            print("(1) Consultar");
            print("(2) Depositar");
            print("(3) Sacar");
            print("(4) Consultar limite");
            print("(5) Alterar limite");
            print("(6) Mostrar informações da conta");
            print("(7) Sair");
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
                opcaoConsultarLimite();
            }
            else if (opcao == 5) {
                opcaoAlterarLimite();
            }
            else if (opcao == 6){
                opcaoMostrarInfo();
            }
            else if (opcao == 7){
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

    private static void opcaoConsultarLimite() {
        print("\n## Limite da conta: R$ " + conta.consultarLimite());
    }

    private static void opcaoAlterarLimite() {
        double v = inputDouble("\n## Valor para limite:");
        conta.alterarLimite(v);
    }

    private static void opcaoMostrarInfo() {
        print("\n## Informações da conta:");
        print(conta.toString());
    }

}
