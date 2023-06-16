// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        System.out.println("----Bom dia. Bem vindo ao Lua_Dev_Corps. Vamos criar seu cadastro!----");

        //Criação do objeto conta
        Conta conta1 = new Conta();

        //inserção do nome
        System.out.println("Digite seu nome: ");
        Scanner nome1 = new Scanner(System.in);
        String nome = nome1.next();
        conta1.setNome(nome);


        //inserção do cpf
        System.out.println("Digite seu cpf: ");
        Scanner cpf1 = new Scanner(System.in);
        String cpf = cpf1.next();
        conta1.setCpf(cpf);

        //Chamar método menu da conta do usuário:
        conta1.menu();
    }
}

class Conta {
    //Atributos privados. Devem ser chamados por meio de métodos.
    private String nome;
    private String cpf;
    private double saldo;

    //Métodos. Devem ser públicos para serem chamados pela classe main.

    //Set (criar/alterar) e get(chamar) do nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    //Set (criar/alterar) e get(chamar) do cpf
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    //Ações de manipulação do saldo: depositar e sacar
    public void depositar(double valor) {
        //Agregar valor dentro do atributo saldo por meio de +=
        saldo += valor;
        System.out.println("Seu saldo atual é de: " + this.saldo);
    }

    public void sacar(double valor) {
        if (valor < saldo) {
            //retirar valor dentro do montante saldo por meio de -=
            saldo -= valor;
            System.out.println("Seu saldo atual é de: " + this.saldo);
        } else {
            System.out.println("----Valor muito alto para ser sacado.----");
        }
    }

    public void menu() {
        int opcaoEscolhida;
        //O "do" serve para uma vez escolhida e executada uma opção, seja inserido novamente esse texto de escolhas até
        //o usuário apertar 4.
        do {
            System.out.print("Escolha uma das opções abaixo: \n" +
                    "1 - Dados do usuário \n" +
                    "2 - Depositar \n" +
                    "3 - Sacar \n" +
                    "4 - Sair \n" +
                    "Opção: ");

            //Processo de entrada do valor e chamar a opção escolhida
            Scanner ponteiro = new Scanner(System.in);
            /*Como não posso simplesmente enfiar o ponteiro dentro do método opcoes foi criado a variável
            opcaoEscolhida para receber o valor do ponteiro. Esse variável então é inserida no método que executará
            uma das opções.*/
            opcaoEscolhida = ponteiro.nextInt();
            this.opcoes(opcaoEscolhida);

        } while (opcaoEscolhida != 4);
        //Aqui encerra o programa. O case 4 será executado primeiro para depois seguir pro while.
    }

    // O switch é chamado dentro do menu.
    public void opcoes(int opcaoEscolhida) {
        //Executa opção escolhida.
        switch (opcaoEscolhida) {
            case 1:
                System.out.print("Dados do usuário: \n" +
                        "--Nome: " + this.nome + "\n" +
                        "--CPF: " + this.cpf + "\n" +
                        "--Saldo: " + this.saldo + "\n");
                break;

            case 2:
                System.out.println("Por favor, insira o valor a ser depositado: ");
                Scanner deposito1 = new Scanner(System.in);
                double deposito = deposito1.nextDouble();
                this.depositar(deposito);
                break;

            case 3:
                System.out.println("Quanto dinheiro deseja sacar? ");
                Scanner saque1 = new Scanner(System.in);
                double saque = saque1.nextDouble();
                this.sacar(saque);
                break;

            case 4:
                System.out.println("----Obrigado por usar o aplicativo de conta bancária da Lua_Dev_Corps. Sayonara Bye-Bye!----");
                break;

            default:
                //Se algum usuário espertinho tentar digitar outro valor não computado nas cases, ele receberá essa mensagem.
                System.out.println("----Dígito inválido. Por favor escolha um valor dentre as opções.----");
                break;

        }

    }

}


