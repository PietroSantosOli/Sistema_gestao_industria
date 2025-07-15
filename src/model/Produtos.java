package model;

public class Produtos {
    private Integer idProdutos;

    private String nomeProdutos;

    private String descricao;

    public Produtos(Integer idProdutos, String nomeProdutos, String descricao) {
        this.idProdutos = idProdutos;
        this.nomeProdutos = nomeProdutos;
        this.descricao = descricao;
    }

    public Produtos() {
    }

    public Integer getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(Integer idProdutos) {
        this.idProdutos = idProdutos;
    }

    public String getNomeProdutos() {
        return nomeProdutos;
    }

    public void setNomeProdutos(String nomeProdutos) {
        this.nomeProdutos = nomeProdutos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "{"
                + "\"idProduto\": " + idProdutos + ", "
                + "\"nomeProduto\": \"" + nomeProdutos + "\", "
                + "\"Descrição\": \"" + descricao + "\", "
                + "}";
    }
}
