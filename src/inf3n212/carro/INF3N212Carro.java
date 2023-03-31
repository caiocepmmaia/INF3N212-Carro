/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inf3n212.carro;

import controller.CCarro;
import controller.CPessoa;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author 181810115
 */
public class INF3N212Carro {

    public static CPessoa cadPessoa = new CPessoa();
    public static CCarro cadCarro = new CCarro();
    static Scanner leia = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        cadPessoa.mockPessoas();
        cadCarro.mockCarros();
        int opM = 99;
        int opSM = 99;

        do {
            System.out.println("    Sistema de Cadastro     ");
            menuPrincipal();
            opM = leiaNumInt();
            switch (opM) {
                case 1:
                case 2:
                    do {
                        subMenu(opM);
                        opSM = leiaNumInt();
                        switch (opSM) {
                            case 1:
                                System.out.println("1 - Cadastrar");
                                if (opM == 1) {
                                    cadastrarPessoa();
                                } else {
                                    cadastrarCarro();
                                }
                                break;
                            case 2:
                                System.out.println("2 - Editar");
                                if (opM == 1) {
                                    editarPessoa();
                                } else {
                                    editarCarro();
                                }
                                break;
                            case 3:
                                System.out.println("3 - Listar");
                                if (opM == 1) {
                                    listarPessoa();
                                } else {
                                    listarCarro();
                                }
                                break;
                            case 4:
                                System.out.println("4 - Deletar");
                                if (opM == 1) {
                                    deletarPessoa();
                                } else {
                                    deletarCarro();
                                }
                                break;
                            case 0:
                                System.out.println("0 - Sair");
                                break;
                            default:
                                System.out.println("Opção não existe, tente novamente!");
                        }// fim switch submenu
                    } while (opSM != 0);// fim do do submenu

                    break;
                case 0:
                    System.out.println("Aplicação finalizada pelo usuário!");
                    break;
                default:
                    System.out.println("Opção não existe, tente novamente!");
            }//fim switch menuPrincipal
        } while (opM != 0);// fim do do menuPrincuoal

    }// fim public main

    public static int leiaNumInt() {
        Scanner leiaNum = new Scanner(System.in);
        try {
            return leiaNum.nextInt();
        } catch (InputMismatchException i) {//i variavel local
            System.out.println("Erro: " + i.getMessage() + "\nTente Novamente!");
        }
        return 99;
    }// fim leiaNumInt

    public static void menuPrincipal() {
        System.out.println("        Menu Principal      ");
        System.out.println("1 - Ger. Pessoa");
        System.out.println("2 - Ger. Carro");
        System.out.println("0 - Sair");
        System.out.print("Digite aqui: ");
    }// fim menuPricipal

    public static void subMenu(int opM) {
        String subM = null;
        if (opM == 1) {
            subM = "Pessoa";
        }
        if (opM == 2) {
            subM = "Carro";
        }

        System.out.println("Ger. " + subM + "   ");
        System.out.println("1 - Cadastrar " + subM);
        System.out.println("2 - Editar " + subM);
        System.out.println("3 - Listar " + subM + "s");
        System.out.println("4 - Deletar " + subM);
        System.out.println("0 - Voltar");
        System.out.print("Digite a opção: ");

    }// fim subMenu

    private static void cadastrarPessoa() {
        System.out.println("Pessoa");
    }

    private static void cadastrarCarro() {
        System.out.println("Carro");
    }

    private static void editarPessoa() {
        System.out.println("Editar Pessoa");
    }

    private static void editarCarro() {
        System.out.println("Editar Carro");
    }

    private static void listarPessoa() {
        System.out.println("Listar Pessoa");
    }

    private static void listarCarro() {
        System.out.println("Listar Carro");
    }

    private static void deletarPessoa() {
        System.out.println("Deletar Pessoa");
    }

    private static void deletarCarro() {
        System.out.println("Deletar Carro");
    }
}
