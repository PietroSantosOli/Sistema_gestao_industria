import dao.FuncionariosDAO;
import dao.RelatorioDAO;
import file.EscritaArquivo;
import menu.FuncionarioMenu;
import menu.ProducaoMenu;
import menu.ProdutoMenu;
import menu.SetorMenu;
import model.Relatorio;

import java.util.Scanner;

public class AppIndustria {
    public static void main(String[] args) {

//        setorDAO setorDAO = new setorDAO();
//
//        ArrayList<model.Setor> setores = setorDAO.listar();
//
//        for (model.Setor setor: setores){
//            System.out.println(setor);
//        }
//
//        System.out.println("+".repeat(100));
//
//        model.Setor setor = setorDAO.buscarPorId(5);
//        System.out.println(setor);
//
//        System.out.println("+".repeat(100));
//
////        model.Setor novoSetor = new model.Setor();
////        novoSetor.setIdSetor(6);
////        novoSetor.setNome("Recursos Humanos");
////        novoSetor.setResponsavel("Fabio");
////        Boolean foiCadastrado = setorDAO.cadastrar(novoSetor);
////        System.out.println("Foi cadastrado "+foiCadastrado);
//
////        Boolean foiAtualizado = setorDAO.atualizar(novoSetor);
////        System.out.println("Foi atualizado "+foiAtualizado);
//
//        Boolean retornoExclusao = setorDAO.remover(6);
//        System.out.println("Foi deletado" + retornoExclusao);
//
//
//
//
//        //model.Produtos DAO
//        dao.produtosDAO dao.produtosDAO = new dao.produtosDAO();
//
////        LISTAR
//        ArrayList<model.Produtos> produtos = dao.produtosDAO.listar();
//
//        for (model.Produtos produtos1: produtos){
//            System.out.println(produtos1);
//        }
//
//        System.out.println("+".repeat(100));
//
////        LISTAGEM ESPECIFICA
//        model.Produtos produtos1 = dao.produtosDAO.buscarPorId(5);
//        System.out.println(produtos1);
//
//        System.out.println("+".repeat(100));
//
////      CADASTRO
//        model.Produtos novoProduto = new model.Produtos();
//        novoProduto.setNomeProdutos("prego sem ponta");
//        novoProduto.setDescricao("não é pontudo");
//
//        Boolean foiCadastrado = dao.produtosDAO.cadastrar(novoProduto);
//        System.out.println("Foi cadastrado "+foiCadastrado);
//
//        System.out.println("+".repeat(100));
////      ATUALIZAR
//        novoProduto.setIdProdutos(23);
//        novoProduto.setNomeProdutos("prego com ponta");
//        novoProduto.setDescricao("agora é pontudo");
//
//        Boolean foiAtualizado = dao.produtosDAO.atualizar(novoProduto);
//        System.out.println("Foi atualizado "+foiAtualizado);
//
//        System.out.println("+".repeat(100));
////      EXCLUIR
//        Boolean retornoExclusao = dao.produtosDAO.remover(21);
//        System.out.println("Foi deletado" + retornoExclusao);

//        //FuncionariosDAO
//        dao.funcionariosDAO dao.funcionariosDAO = new dao.funcionariosDAO();
//
////        LISTAR
//        ArrayList<model.Funcionario> funcionarios = dao.funcionariosDAO.listar();
//
//        for (model.Funcionario funcionario: funcionarios){
//            System.out.println(funcionario);
//        }
//
//        System.out.println("+".repeat(100));
//
////        LISTAGEM ESPECIFICA
//        model.Funcionario funcionario = dao.funcionariosDAO.buscarPorId(5);
//        System.out.println(funcionario);
//
//        System.out.println("+".repeat(100));
//
////      CADASTRO
//        model.Funcionario novoFuncionario = new model.Funcionario();
//        novoFuncionario.setNome("Poatan");
//        novoFuncionario.setcargo("Boxeador");
//        novoFuncionario.setSetor(new model.Setor(10,null,null));
//
//        Boolean foiCadastrado = dao.funcionariosDAO.cadastrar(novoFuncionario);
//        System.out.println("Foi cadastrado "+foiCadastrado);
//
//        System.out.println("+".repeat(100));
////      ATUALIZAR
//        novoFuncionario.setIdFuncionario(10);
//        novoFuncionario.setNome("Bolsonaro");
//        novoFuncionario.setcargo("Presidente");
//        novoFuncionario.setSetor(new model.Setor(10,null,null));
//
//        Boolean foiAtualizado = dao.funcionariosDAO.atualizar(novoFuncionario);
//        System.out.println("Foi atualizado "+foiAtualizado);
//
//        System.out.println("+".repeat(100));
////      EXCLUIR
//        Boolean retornoExclusao = dao.funcionariosDAO.remover(21);
//        System.out.println("Foi deletado" + retornoExclusao);

//        //producaoDAO
//        funcionariosDAO funcionariosDAO = new funcionariosDAO();
//
////        LISTAR
//        ArrayList<Funcionario> funcionarios = funcionariosDAO.listar();
//
//        for (Funcionario funcionario: funcionarios){
//            System.out.println(funcionario);
//        }
//
//        System.out.println("+".repeat(100));
//
////        LISTAGEM ESPECIFICA
//        Funcionario funcionario = funcionariosDAO.buscarPorId(5);
//        System.out.println(funcionario);
//
//        System.out.println("+".repeat(100));
//
////      CADASTRO
//        Funcionario novoFuncionario = new Funcionario();
//        novoFuncionario.setNome("Poatan");
//        novoFuncionario.setcargo("Boxeador");
//        novoFuncionario.setSetor(new Setor(10,null,null));
//
//        Boolean foiCadastrado = funcionariosDAO.cadastrar(novoFuncionario);
//        System.out.println("Foi cadastrado "+foiCadastrado);
//
//        System.out.println("+".repeat(100));
////      ATUALIZAR
//        novoFuncionario.setIdFuncionario(10);
//        novoFuncionario.setNome("Bolsonaro");
//        novoFuncionario.setcargo("Presidente");
//        novoFuncionario.setSetor(new Setor(10,null,null));
//
//        Boolean foiAtualizado = funcionariosDAO.atualizar(novoFuncionario);
//        System.out.println("Foi atualizado "+foiAtualizado);
//
//        System.out.println("+".repeat(100));
////      EXCLUIR
//        Boolean retornoExclusao = funcionariosDAO.remover(21);
//        System.out.println("Foi deletado" + retornoExclusao);

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("=====MENU PRINCIPAL=====");
            System.out.println("[1] Produção");
            System.out.println("[2] Funcionário");
            System.out.println("[3] Setor");
            System.out.println("[4] Produto");
            System.out.println("[5] Relatório");
            System.out.println("[0] Sair");
            System.out.print("Opção: ");
            Integer opcao = sc.nextInt();

            if (opcao == 0){
                System.out.println("Programa finalizado com sucesso!");
                break;
            }
            if(opcao == 1){
                ProducaoMenu.main(args);
            }
            if (opcao == 2){
                FuncionarioMenu.main(args);
            }
            if (opcao == 3){
                SetorMenu.main(args);
            }
            if (opcao == 4){
                ProdutoMenu.main(args);
            }
            if (opcao == 5){
                RelatorioDAO relatorioDAO = new RelatorioDAO();
                Relatorio relatorio = new Relatorio(relatorioDAO);
                System.out.println(relatorio.gerarRelatorioGeral());
                EscritaArquivo escritaArquivo = new EscritaArquivo();
                escritaArquivo.salvarCSV(relatorio.gerarRelatorioGeral());
            }
        }

    }
}