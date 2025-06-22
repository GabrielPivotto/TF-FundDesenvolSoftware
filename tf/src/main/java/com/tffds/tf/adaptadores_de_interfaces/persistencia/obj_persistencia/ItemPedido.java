package com.tffds.tf.adaptadores_de_interfaces.persistencia.obj_persistencia;

import com.tffds.tf.dominio.modelos.ItemPedidoModel;
import com.tffds.tf.dominio.modelos.ProdutoModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idProduto;
    private int quantidade;
    private double preco;

    protected ItemPedido() {}

    public ItemPedido(long idProduto, int quantidade, double preco) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public long getId() {return id;}

    public long getIdProduto() {return idProduto;}
    public void setIdProduto(long idProduto) {this.idProduto = idProduto;}

    public int getQuantidade() {return quantidade;}
    public void setQuantidade(int quantidade) {this.quantidade = quantidade;}

    public double getPreco() {return preco;}
    public void setPreco(double preco) {this.preco = preco;}

    public static ItemPedido fromModel (ItemPedidoModel ipModel) {
        return new ItemPedido(ipModel.getProduto().getId(), ipModel.getQuantidade(), ipModel.getPreco());
    }
     public static ItemPedidoModel toModel (ItemPedido ie, ProdutoModel prod) {
        return new ItemPedidoModel(prod ,ie.getQuantidade());
    }
}