package dao;

import config.ConexaoMySQL;
import model.Produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosDAO {
    private Connection conn = ConexaoMySQL.getConnection();

    public ArrayList<Produtos> listar() {
        try {
            ArrayList<Produtos> produtos = new ArrayList<>();
            String sql = "SELECT * FROM produtos;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id_produtos");
                String nome = rs.getString("nome_produto");
                String descricao = rs.getString("descricao");

                Produtos produto = new Produtos(id, nome, descricao);

                produtos.add(produto);
            }
            return produtos;

        } catch (SQLException e) {
            System.out.println("Deu ruim em listar os produtos. " + e.getMessage());
        }
        return null;
    }

    public Produtos buscarPorId(Integer id) {
        try {
            String sql = "SELECT * FROM produtos WHERE id_produtos = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Integer idProduto = rs.getInt("id_produtos");
                String nome = rs.getString("nome_produto");
                String descricao = rs.getString("descricao");

                Produtos produto = new Produtos(idProduto,nome, descricao);
                return produto;
            }
        }catch (SQLException e){
            System.out.println("Erro ao buscar o produto pelo ID" + e.getMessage());
        }
        return null;
    }

    public Boolean cadastrar(Produtos produtos) {
        try {
            String sql = "INSERT INTO produtos (nome_produto, descricao) VALUES(?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, produtos.getNomeProdutos());
            ps.setString(2, produtos.getDescricao());
            int qtdeLinha = ps.executeUpdate();
            if(qtdeLinha > 0){
                return true;
            }
            return false;
        }catch (SQLException e){
            System.out.println("Erro ao cadastrar produto " + e.getMessage());
        }
        return false;
    }

    public Boolean atualizar(Produtos produtos) {
        try {
            String sql = "UPDATE produtos SET nome_produto = ?, descricao = ? WHERE id_produtos = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,produtos.getNomeProdutos());
            ps.setString(2,produtos.getDescricao());
            ps.setInt(3,produtos.getIdProdutos());
            int qtdeAtualizacoes = ps.executeUpdate();

            if (qtdeAtualizacoes > 0){
                return true;
            }
        }catch (SQLException e){
            System.out.println("Erro ao atualizar o setor" + e.getMessage());
        }
        return false;
    }

    public Boolean remover(Integer id) {
        try {
            String sql = "DELETE FROM produtos WHERE id_produtos = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);

            Produtos produtoRetornado = buscarPorId(id);
            if (produtoRetornado != null){
                ps.executeUpdate();
                return true;
            }

        }catch (SQLException e){
            System.out.println("Erro ao deletar o produto" + e.getMessage());

        }
        return false;
    }
}
