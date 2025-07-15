package dao;


import model.Funcionario;
import model.Produtos;
import model.Producao;
import config.ConexaoMySQL;
import dao.ProdutosDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProducaoDAO {
    private Connection conn = ConexaoMySQL.getConnection();
    private ProdutosDAO produtoDAO = new ProdutosDAO();
    private FuncionariosDAO funcionarioDAO = new FuncionariosDAO();

    public ArrayList<Producao> listar() {
        try {
            ArrayList<Producao> producaos = new ArrayList<>();

            String sql = "SELECT * FROM producao;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id_producao");
                Integer idProduto = rs.getInt("id_produto");
                Integer idFuncionario = rs.getInt("id_funcionario");
                String dataProducao = rs.getString("data_producao");
                Integer quantidade = rs.getInt("quantidade");

                // id_produto, id_funcionario, dataProducao, quantidade

                Produtos produto = produtoDAO.buscarPorId(idProduto);
                Funcionario funcionario = funcionarioDAO.buscarPorId(idFuncionario);

                producaos.add(new Producao(id, funcionario,produto, quantidade,dataProducao));
            }
            return producaos;
        } catch (SQLException e) {
            System.out.println("Erro ao listar os Produções: " + e.getMessage());
        }
        return null;
    }

    public Producao buscarPorId(Integer id) {
        try {
            String sql = "SELECT * FROM producao WHERE id_producao = ? ;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {

                Integer idProduto = rs.getInt("id_produto");
                Integer idFuncionario = rs.getInt("id_funcionario");
                String dataProducao = rs.getString("data_producao");
                Integer quantidade = rs.getInt("quantidade");

                Produtos produto = produtoDAO.buscarPorId(idProduto);
                Funcionario funcionario = funcionarioDAO.buscarPorId(idFuncionario);

                Producao producao = new Producao(id, funcionario,produto, quantidade,dataProducao);
                return producao;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar pelo ID. " + e.getMessage());
        }
        return null;
    }

    public Boolean cadastrar(Producao producao) {
        try {
            String sql = "INSERT INTO producao (id_produto, id_funcionario, data_producao, quantidade) VALUES (?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, producao.getProduto().getIdProdutos());
            ps.setInt(2, producao.getFuncionario().getIdFuncionario());
            ps.setString(3, producao.getDataProducao());
            ps.setInt(4, producao.getQuantidade());

            int qtdeLinhas = ps.executeUpdate();
            if (qtdeLinhas > 0) {
                return true;
            }
            return false;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar Produção: " + e.getMessage());
        }
        return false;
    }

    public Boolean atualizar(Producao producao) {
        try {
            String sql = "UPDATE producao SET id_produto = ?, id_funcionario = ?, data_producao = ?, quantidade = ? WHERE id_producao = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, producao.getProduto().getIdProdutos());
            ps.setInt(2, producao.getFuncionario().getIdFuncionario());
            ps.setString(3, producao.getDataProducao());
            ps.setInt(4, producao.getQuantidade());
            ps.setInt(5, producao.getId());

            int qtdeAtualizacao = ps.executeUpdate();

            if (qtdeAtualizacao > 0) {
                return true;
            }
            return false;


        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Produção: " + e.getMessage());
        }
        return null;
    }

    public Boolean remover(Integer id) {
        try {
            String sql = "DELETE FROM producao WHERE id_producao = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            Producao producaoRetornado = buscarPorId(id);
            if (producaoRetornado != null) {
                ps.executeUpdate();
                return true;
            }
            return false;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar Produção: " + e.getMessage());
        }
        return false;
    }
}

