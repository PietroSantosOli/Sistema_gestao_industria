package menu;

import dao.FuncionariosDAO;
import dao.ProducaoDAO;
import dao.ProdutosDAO;
import model.Funcionario;
import model.Producao;
import model.Produtos;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ProducaoMenu {
    private static Scanner scanner = new Scanner(System.in);
    private static ProducaoDAO producaoDAO = new ProducaoDAO();
    private static FuncionariosDAO funcionariosDAO = new FuncionariosDAO();
    private static ProdutosDAO produtosDAO = new ProdutosDAO();

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n===== MENU PRODUÇÃO =====");
            System.out.println("1 - Registrar nova produção");
            System.out.println("2 - Listar produções");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> registrarProducao();
                case 2 -> listarProducoes();
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    private static void registrarProducao() {
        System.out.println("\n--- Registrar Nova Produção ---");

        System.out.print("ID do Funcionário: ");
        int idFuncionario = Integer.parseInt(scanner.nextLine());
        Funcionario funcionario = funcionariosDAO.buscarPorId(idFuncionario);
        if (funcionario == null) {
            System.out.println("❌ Funcionário não encontrado.");
            return;
        }

        System.out.print("ID do Produto: ");
        int idProduto = Integer.parseInt(scanner.nextLine());
        Produtos produto = produtosDAO.buscarPorId(idProduto);
        if (produto == null) {
            System.out.println("❌ Produto não encontrado.");
            return;
        }

        System.out.print("Quantidade produzida: ");
        int quantidade = Integer.parseInt(scanner.nextLine());

        System.out.println("Data de produção: ");
        String data = scanner.next();

        Producao producao = new Producao();
        producao.setFuncionario(funcionario);
        producao.setProduto(produto);
        producao.setQuantidade(quantidade);
        producao.setDataProducao(data);

        producaoDAO.cadastrar(producao);
    }

    private static void listarProducoes() {
        System.out.println("\n--- Lista de Produções ---");

        List<Producao> lista = producaoDAO.listar();

        for (Producao p : lista) {
            System.out.println("ID: " + p.getId());
            System.out.println("Funcionário: " + p.getFuncionario().getNome());
            System.out.println("Produto: " + p.getProduto().getNomeProdutos());
            System.out.println("Quantidade: " + p.getQuantidade());
            System.out.println("Data: " + p.getDataProducao());
            System.out.println("----------------------------");
        }
    }
}