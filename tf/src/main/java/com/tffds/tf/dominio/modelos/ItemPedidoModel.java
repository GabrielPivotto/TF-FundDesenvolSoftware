package com.tffds.tf.dominio.modelos;

public class ItemPedidoModel {
    private ProdutoModel produto;
    private int quantidade;
    private double precoBase;
    private double precoComImposto;

    public ItemPedidoModel(ProdutoModel produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoBase = produto.getPrecoUnitario() * quantidade;
        precoComImposto = precoBase;
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

    public double getPrecoBase(){
        return precoBase;
    }

    public double getPrecoComImposto(){
        return precoComImposto;
    }

    public void addImposto(double valor){
        precoComImposto += valor;
    }

    public void setPreco(double valor){
        precoBase = valor;
    }

    public void setPrecoComImposto(double Valor){
        precoComImposto = valor;
    }


    @Override
    public String toString() {
        return "ItemPedido [produto=" + produto + ", quantidade=" + quantidade + "]";
    }
}
