package com.tffds.tf.aplicacao.dtos;

import com.tffds.tf.adaptadores_de_interfaces.persistencia.obj_persistencia.Produto;
import com.tffds.tf.dominio.modelos.ProdutoModel;

public class ProdutoDTO {
    private long id;
    private String descricao;
    private double precoUnitario;

    public ProdutoDTO(long id, String descricao, double precoUnitario) {
        this.id = id;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
    }

    public long getId() {return this.id;}
    public String getDescricao() {return this.descricao;}
    public double getPrecoUnitario() {return this.precoUnitario;}

    public static ProdutoDTO fromProdutoModel(ProdutoModel produto){
        return new ProdutoDTO(produto.getId(), produto.getDescricao(), produto.getPrecoUnitario());
    }
     public static ProdutoModel toProdutoModel (ProdutoDTO prod) {
        return new ProdutoModel(prod.getId(), prod.getDescricao(), prod.getPrecoUnitario());
    }
}
