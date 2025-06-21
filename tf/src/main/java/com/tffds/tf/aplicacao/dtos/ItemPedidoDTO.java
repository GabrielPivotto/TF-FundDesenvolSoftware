package com.tffds.tf.aplicacao.dtos;

import com.tffds.tf.dominio.modelos.ItemPedidoModel;

public class ItemPedidoDTO {
    private ProdutoDTO produto;
    private int qtdade;

    /**public ItemPedidoDTO(long idProduto, int qtdade) {
        this.idProduto = idProduto;
        this.qtdade = qtdade;
    }*/

    public ItemPedidoDTO(ProdutoDTO produto, int qtdade) {
        this.produto = produto;
        this.qtdade = qtdade;
    }


    public long getIdProduto() {
        return produto.getId();
    }
    
     public ProdutoDTO getProduto() {
        return produto;
    }

    public int getQtdade() {
        return qtdade;
    }

    @Override
    public String toString() {
        return "ItemPedidoDTO [idProduto=" + getIdProduto() + ", qtdade=" + qtdade + "]";
    }    

    //item pedido sempre chegara do front, sem necessidade de transformar de DTO para model
    public static ItemPedidoDTO fromModel(ItemPedidoModel item){
        return new ItemPedidoDTO(ProdutoDTO.fromProdutoModel(item.getProduto()),item.getQuantidade());
    }

    public static ItemPedidoModel toModel(ItemPedidoDTO item){
        return new ItemPedidoModel(ProdutoDTO.toProdutoModel(item.getProduto()),item.getQtdade());
    }
}