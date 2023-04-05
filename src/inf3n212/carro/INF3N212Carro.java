/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inf3n212.carro;

import controller.CCarro;
import controller.CPessoa;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Carro;
import model.Pessoa;
import util.Validadores;

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
        System.out.println("    Cadastrar Pessoa    ");
        int idPessoa;
        String nome;
        String cpf;
        String endereco;
        String telefone;
        boolean tcpf = true;

        do {
            System.out.print("Informe o CPF: ");
            cpf = leia.nextLine();
            tcpf = Validadores.isCPF(cpf);
            if (tcpf) {
                if (cadPessoa.getPessoaCPF(cpf) != null) {
                    System.out.println("CPF já cadastrado!");
                    System.out.println("1 - Tentar novamente");
                    System.out.println("2 - Cancelar");
                    System.out.print("Digite aqui: ");
                    int op = leiaNumInt();
                    if (op == 2) {
                        return;
                    }
                } else {
                    tcpf = false;
                }
            } else {
                System.out.println("CPF inválido!");
                System.out.println("1 - Tentar novamente");
                System.out.println("2 - Cancelar");
                System.out.print("Digite aqui: ");
                int op = leiaNumInt();
                if (op == 2) {
                    return;
                }
                tcpf = true;
            }
        } while (tcpf);
        System.out.print("Informe o nome: ");
        nome = leia.nextLine();
        System.out.print("Informe o endereço: ");
        endereco = leia.nextLine();
        System.out.print("Informe o telefone: ");
        telefone = leia.nextLine();
        idPessoa = cadPessoa.geraID();
        Pessoa p = new Pessoa(idPessoa, nome, cpf, endereco, telefone);
        cadPessoa.addPessoa(p);
        System.out.println(p.getNome() + " cadastrado com sucesso!");
    }//fim cadastro

    private static void cadastrarCarro() {
        System.out.println("Carro");
    }

    private static void editarPessoa() {
        System.out.println("    Editar Pessoa   ");
        boolean isCPF;
        do{
        System.out.print("Informe o CPF de quem deseja atualizar os dados: ");
        String cpf = leia.nextLine();
        isCPF = Validadores.isCPF(cpf);
            if (isCPF) {
                Pessoa p = cadPessoa.getPessoaCPF(cpf);
                if (p != null) {
                    System.out.println("Quais dados de " + p.getNome() + " deseja alterar? ");
                    System.out.println("1 - Nome");
                    System.out.println("2 - Endereço");
                    System.out.println("3 - Telefone");
                    System.out.println("4 - Todos");
                    System.out.println("0 - Cancelar");
                    System.out.println("Digite aqui: ");
                    int op = leiaNumInt();
                    if (op == 1 || op == 4) {
                        System.out.println("Informe o novo nome: ");
                        p.setNome(leia.nextLine());
                        System.out.println("Nome alterado para " + p.getNome());
                        isCPF = false;
                    }
                    if (op == 2 || op == 4) {
                        System.out.println("Informe o novo endereço: ");
                        p.setEndereco(leia.nextLine());
                        System.out.println("Endereço alterado para " + p.getEndereco());
                        isCPF = false;
                    }
                    if (op == 3 || op == 4) {
                        System.out.println("Informe o novo nome: ");
                        p.setTelefone(leia.nextLine());
                        System.out.println("Telefone alterado para " + p.getTelefone());
                        isCPF = false;
                    }
                    if (op == 0) {
                        System.out.println("Operação cancelada.");
                        isCPF = false;
                    }
                }else{
                    System.out.println("CPF não cadastrado!");
                    isCPF = false;
                }
            }else{
                System.out.println("CPF inválido!");
                System.out.print("Deseja tentar novamente? \n1 - Sim | 2 - Não: ");
                int op = leiaNumInt();
                isCPF = op == 1;// simplificacção do if junto do else pra dizer se é false ou true
            }
        }while (isCPF);
    }//fim editar pessoa

    private static void editarCarro() {
        System.out.println("Editar Carro");
    }

    private static void listarPessoa() {
        System.out.println("    Listar Pessoa   ");
        for (Pessoa pessoa : cadPessoa.getPessoas()) {
            System.out.println(pessoa.toString());
        }
    }

    private static void listarCarro() {
        System.out.println("    Listar Carro");
        for (Carro carro : cadCarro.getCarros()) {
            System.out.println(carro.toString());
        }
    }

    private static void deletarPessoa() {
        System.out.println("    Deletar Pessoa  ");
        boolean delCPF = false;
        do {
            System.out.print("Informe o CPF da pessoa que deseja deletar: ");
            String cpf = leia.nextLine();
            delCPF = Validadores.isCPF(cpf);
            if (delCPF) {
                Pessoa p = cadPessoa.getPessoaCPF(cpf);
                if (p != null) {
                    System.out.println("Deseja realmente deletar " + p.getNome() + "?");
                    System.out.print("1 - Sim | 2 - Não: ");
                    int op = leiaNumInt();
                    if (op == 1) {
                        cadPessoa.removePessoa(p);
                        System.out.println("Pessoa deletada.");
                        delCPF = false;
                    } else {
                        System.out.println("Operação cancelada!");
                        delCPF = false;
                    }
                } else {
                    System.out.println("Não foi encontrada nenhum cadastro no CPF.");
                    System.out.println("Deseja tentar novamente? ");
                    System.out.print("1 - Sim | 2 - Não: ");
                    int op = leiaNumInt();
                    if (op == 1) {
                        delCPF = true;
                    } else {
                        delCPF = false;
                    }
                }
            }else{
                System.out.println("CPF inválido!"
                    + "\nTente novamente");
                delCPF = true;
            }
        } while (delCPF);
    }// fim deletar pessoa

    private static void deletarCarro() {
        System.out.println("Deletar Carro");
    }
}
