package dao;

import config.ConexaoMySQL;
import model.Funcionario;
import model.Setor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionariosDAO {
    private Connection conn = ConexaoMySQL.getConnection();

    SetorDAO setorDAO = new SetorDAO();

    public ArrayList<Funcionario> listar() {
        try {
            ArrayList<Funcionario> funcionarios = new ArrayList<>();
            String sql = "SELECT * FROM funcionarios;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cargo = rs.getString("cargo");
                Integer idSetor = rs.getInt("id_setor");

                Setor setor = setorDAO.buscarPorId(idSetor);
                Funcionario funcionario = new Funcionario(id,nome,cargo,setor);

                funcionarios.add(funcionario);
            }
            return funcionarios;

        } catch (SQLException e) {
            System.out.println("Deu ruim em listar os funcionarios. " + e.getMessage());
            return null;
        }
    }

    public Funcionario buscarPorId(Integer id) {
        try {
            String sql = "SELECT * FROM funcionarios WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Integer idFuncionario = rs.getInt("id");
                String nome = rs.getString("nome");
                String cargo = rs.getString("cargo");
                Integer idSetor = rs.getInt("id_setor");

                Setor setor = setorDAO.buscarPorId(idSetor);

                Funcionario funcionario = new Funcionario(idFuncionario,nome,cargo,setor);
                return funcionario;
            }
        }catch (SQLException e){
            System.out.println("Erro ao buscar o funcionário pelo ID" + e.getMessage());
        }
        return null;
    }

    public Boolean cadastrar(Funcionario funcionario) {
        try {
            String sql = "INSERT INTO funcionarios (nome,cargo,id_setor) VALUES(?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getcargo());
            ps.setInt(3, funcionario.getSetor().getIdSetor());
            int qtdeLinha = ps.executeUpdate();
            if(qtdeLinha > 0){
                return true;
            }
            return false;
        }catch (SQLException e){
            System.out.println("Erro ao cadastrar funcionário " + e.getMessage());
        }
        return false;
    }

    public Boolean atualizar(Funcionario funcionario) {
        try {
            String sql = "UPDATE funcionarios SET nome = ?, cargo = ? WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,funcionario.getNome());
            ps.setString(2,funcionario.getcargo());
            ps.setInt(3,funcionario.getSetor().getIdSetor());
            int qtdeAtualizacoes = ps.executeUpdate();

            if (qtdeAtualizacoes > 0){
                return true;
            }
        }catch (SQLException e){
            System.out.println("Erro ao atualizar o funcionario" + e.getMessage());
        }
        return false;
    }

    public Boolean remover(Integer id) {
        try {
            String sql = "DELETE FROM funcionarios WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            Funcionario produtoRetornado = buscarPorId(id);
            if (produtoRetornado != null) {
                ps.executeUpdate();
                return true;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao deletar o produto" + e.getMessage());

        }
        return false;
    }
}
