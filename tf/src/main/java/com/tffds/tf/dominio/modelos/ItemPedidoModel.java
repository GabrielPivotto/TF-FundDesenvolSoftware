package com.tffds.tf.dominio.modelos;

public class ItemPedidoModel {
    private ProdutoModel produto;
    private int quantidade;
    private double preco;

    public ItemPedidoModel(ProdutoModel produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = produto.getPrecoUnitario() * quantidade;
    }

    public ProdutoModel getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco(){
        return preco;
    }

    public void setPreco(double valor){
        preco = valor;
    }


    @Override
    public String toString() {
        return "ItemPedido [produto=" + produto + ", quantidade=" + quantidade + "]";
    }
}
