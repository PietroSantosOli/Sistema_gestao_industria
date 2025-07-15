package menu;

import dao.FuncionariosDAO;
import model.Funcionario;
import model.Setor;

import java.util.Scanner;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class FuncionarioMenu {

    private static Scanner scanner = new Scanner(System.in);
    private static FuncionariosDAO funcionariosDAO = new FuncionariosDAO();

    public static void main(String[] args) {
        int opcao;
        do {
                System.out.println("\n===== MENU FUNCIONÁRIOS =====");
                System.out.println("1 - Cadastrar novo funcionário");
                System.out.println("2 - Listar funcionários");
                System.out.println("3 - Buscar por ID");
                System.out.println("4 - Atualizar funcionário");
                System.out.println("5 - Remover funcionário");
                System.out.println("0 - Voltar");
                System.out.print("Escolha: ");
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1 -> cadastrarFuncionario();
                    case 2 -> listarFuncionarios();
                    case 3 -> buscarFuncionarioPorId();
                    case 4 -> atualizarFuncionario();
                    case 5 -> removerFuncionario();
                    case 0 -> System.out.println("Voltando...");
                    default -> System.out.println("Opção inválida.");
                }
        }while (opcao != 0);
    }


    private static void cadastrarFuncionario() {
        System.out.println("\n--- Cadastro de Funcionário ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setcargo(cargo);

        funcionariosDAO.cadastrar(funcionario);
    }

    private static void listarFuncionarios() {
        System.out.println("\n--- Lista de Funcionários ---");
        List<Funcionario> lista = funcionariosDAO.listar();

        for (Funcionario f : lista) {
            System.out.println("ID: " + f.getIdFuncionario());
            System.out.println("Nome: " + f.getNome());
            System.out.println("Cargo: " + f.getcargo());
            System.out.println("-------------------------");
        }
    }

    private static void buscarFuncionarioPorId() {
        System.out.print("Informe o ID do funcionário: ");
        int id = Integer.parseInt(scanner.nextLine());

        Funcionario funcionario = funcionariosDAO.buscarPorId(id);
        if (funcionario != null) {
            System.out.println("ID: " + funcionario.getIdFuncionario());
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Cargo: " + funcionario.getcargo());
        } else {
            System.out.println("❌ Funcionário não encontrado.");
        }
    }

    private static void atualizarFuncionario() {
        System.out.print("Informe o ID do funcionário a ser atualizado: ");
        int id = Integer.parseInt(scanner.nextLine());

        Funcionario funcionario = funcionariosDAO.buscarPorId(id);
        if (funcionario != null) {
            System.out.print("Novo nome: ");
            String nome = scanner.nextLine();
            System.out.print("Novo cargo: ");
            String cargo = scanner.nextLine();

            funcionario.setNome(nome);
            funcionario.setcargo(cargo);

            funcionariosDAO.atualizar(funcionario);
        } else {
            System.out.println("❌ Funcionário não encontrado.");
        }
    }

    private static void removerFuncionario() {
        System.out.print("Informe o ID do funcionário a ser removido: ");
        int id = Integer.parseInt(scanner.nextLine());

        funcionariosDAO.remover(id);
    }
}