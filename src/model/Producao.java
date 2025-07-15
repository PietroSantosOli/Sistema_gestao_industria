package model;

import java.time.LocalDate;

public class Producao {

    private int id;
    private Funcionario funcionario;
    private Produtos produto;
    private int quantidade;
    private String dataProducao;

    // Construtor padrão
    public Producao() {}

    // Construtor completo
    public Producao(int id, Funcionario funcionario, Produtos produto, int quantidade, String dataProducao) {
        this.id = id;
        this.funcionario = funcionario;
        this.produto = produto;
        this.quantidade = quantidade;
        this.dataProducao = dataProducao;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDataProducao() {
        return dataProducao;
    }

    public void setDataProducao(String dataProducao) {
        this.dataProducao = dataProducao;
    }
}