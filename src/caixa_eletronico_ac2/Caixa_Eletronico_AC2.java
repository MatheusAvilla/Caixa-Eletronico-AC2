package caixa_eletronico_ac2;

import java.util.Scanner;


public class Caixa_Eletronico_AC2 {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cpf, senhaCorreta = "01020304", senha;
        float saldo = 1000.00f, deposito, saque, transf;
        int opc, tentativas = 1, nConta, nContaCorreto = 1234567890, agencia;
        System.out.println("******** CAIXA ELETRÔNICO ********");
        System.out.println("======= Seja Bem-Vindo(a) =======");
        System.out.println("Digite seu CPF e Senha para acessar o menu: ");
        cpf = sc.nextLine();
        if("123.456.789-00".equals(cpf)){
            System.out.println("CPF VALIDADO COM SUCESSO.");
            System.out.println("Agora, digite sua senha: ");
            senha = sc.nextLine();
            
            while(!senha.equals(senhaCorreta) && tentativas < 3) {
                System.out.println("SENHA INCORRETA, TENTE NOVAMENTE: ");
                senha = sc.nextLine();
                tentativas++;
            }
            if(senha.equals(senhaCorreta) && tentativas <= 3) {
                System.out.println("SENHA CORRETA, PROSSIGA PARA O MENU: ");
                    do {
                        System.out.println("##########   MENU   ##########");
                        System.out.println("OPÇÃO 1 -> SALDO");
                        System.out.println("OPÇÃO 2 -> DEPÓSITO");
                        System.out.println("OPÇÃO 3 -> SAQUE");
                        System.out.println("OPÇÃO 4 -> TRANSFERÊNCIA");
                        System.out.println("OPÇÃO 0 -> SAIR");
                        System.out.print("Digite o código referente à operação desejada: ");
                        opc = sc.nextInt();
                        switch(opc){
                            case 1: 
                                System.out.println("SALDO ATUAL: R$ " + saldo);
                                break;
                            case 2:
                                System.out.print("DIGITE O VALOR DO DEPÓSITO: R$ ");
                                deposito = sc.nextFloat();
                                saldo += deposito;
                                System.out.println("SALDO ATUAL: R$ " + saldo);
                                break;
                            case 3:
                                System.out.print("DIGITE O VALOR DO SAQUE: R$ ");
                                saque = sc.nextFloat();
                                saldo -= saque;
                                System.out.println("SALDO ATUAL: R$ " + saldo);
                                break;
                            case 4:
                                System.out.print("DIGITE O VALOR DA TRANSFERÊNCIA: R$ ");
                                transf = sc.nextFloat();
                                if(transf > saldo) {
                                    System.out.println("SALDO INSUFICIENTE.");                                   
                                }
                                else {
                                System.out.print("DIGITE O Nº DA CONTA: ");
                                nConta = sc.nextInt();
                                do{
                                    if(nConta == nContaCorreto) {
                                        System.out.println("O Nº DE CONTA " + nConta + " É VÁLIDO.");
                                    }
                                    else {
                                        System.out.println("O NÚMERO DE CONTA DIGITADO É INVÁLIDO, TENTE NOVAMENTE: ");
                                        nConta = sc.nextInt();
                                        if(nConta == nContaCorreto) {
                                        System.out.println("O Nº DE CONTA " + nConta + " É VÁLIDO.");
                                    }
                                    }
                                }while(nConta != nContaCorreto);
                                System.out.print("DIGITE O NÚMERO DA AGÊNCIA: ");
                                agencia = sc.nextInt(); 
                                do {
                                    if(agencia != 341 && agencia != 102 && agencia != 237){
                                        System.out.print("AGÊNCIA INVÁLIDA. DIGITE UMA VÁLIDA POR FAVOR: ");
                                        agencia = sc.nextInt();
                                    }
                                    if(agencia == 341) {
                                        System.out.println("TRANSFERÊNCIA DE " + transf + " REALIZADA PARA O BANCO ITAÚ.");
                                        saldo -= transf;
                                        System.out.println("SALDO ATUAL: R$ " + saldo);
                                    }
                                    if(agencia == 102) {
                                        System.out.println("TRANSFERÊNCIA DE " + transf + " REALIZADA PARA O BANCO CAIXA.");
                                        saldo -= transf;
                                        System.out.println("SALDO ATUAL: R$ " + saldo);
                                    }
                                    if(agencia == 237) {
                                        System.out.println("TRANSFERÊNCIA DE " + transf + " REALIZADA PARA O BANCO BRADESCO");
                                        saldo -= transf;
                                        System.out.println("SALDO ATUAL: R$ " + saldo);
                                    }                                  
                                }while(agencia != 341 && agencia != 102 && agencia != 237);
                                break;
                                }
                            case 0: 
                                System.out.println("~~~~~~ OPERAÇÕES ENCERRADAS ~~~~~~");
                                break;
                            default:
                                System.out.println("Código inválido. Por favor, digite um código válido.");
                                break;
                        }                       
                    }while(opc != 0);
                }
                else {
                    System.out.println("SEU CARTÃO FOI BLOQUEADO.");
                }
        }
        else {
            System.out.println("CPF INCORRETO, ACESSO NÃO PERMITIDO.");
        }
    }
}
