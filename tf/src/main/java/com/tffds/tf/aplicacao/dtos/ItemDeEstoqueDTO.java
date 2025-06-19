package com.tffds.tf.aplicacao.dtos;

import com.tffds.tf.dominio.modelos.ItemDeEstoqueModel;
import com.tffds.tf.dominio.modelos.ProdutoModel;

public class ItemDeEstoqueDTO {
    private long id;
    private ProdutoModel produto;
    private int quantidade;
    private int estoqueMin;
    private int estoqueMax;

    public ItemDeEstoqueDTO(long id, ProdutoModel produto, int quantidade, int estoqueMin, int estoqueMax) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.estoqueMin = estoqueMin;
        this.estoqueMax = estoqueMax;
    }

    public long getId() {return id;}
    public ProdutoModel getProduto() {return produto;}
    public int getQuantidade() {return quantidade;}
    public int getEstoqueMin() {return estoqueMin;}
    public int getEstoqueMax() {return estoqueMax;}

    public static ItemDeEstoqueDTO fromModel(ItemDeEstoqueModel ieModel){
        return new ItemDeEstoqueDTO(ieModel.getId(), ieModel.getProduto(), ieModel.getQuantidade(), ieModel.getEstoqueMin(), ieModel.getEstoqueMax());
    }
     public static ItemDeEstoqueModel toModel (ItemDeEstoqueDTO ieDTO) {
        return new ItemDeEstoqueModel(ieDTO.getId(), ieDTO.getProduto(), ieDTO.getQuantidade(), ieDTO.getEstoqueMin(), ieDTO.getEstoqueMax());
    }
}
