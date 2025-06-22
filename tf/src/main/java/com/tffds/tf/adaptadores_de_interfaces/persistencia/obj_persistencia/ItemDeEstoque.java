package com.tffds.tf.adaptadores_de_interfaces.persistencia.obj_persistencia;

import com.tffds.tf.dominio.modelos.ItemDeEstoqueModel;
import com.tffds.tf.dominio.modelos.ProdutoModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemDeEstoque {
    @Id
    private long id;
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Produto produto;
    private int quantidade;
    private int estoqueMin;
    private int estoqueMax;

    protected ItemDeEstoque() {}

    public ItemDeEstoque(long id, Produto produto, int quantidade, int estoqueMin, int estoqueMax) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.estoqueMin = estoqueMin;
        this.estoqueMax = estoqueMax;
    }
    
    public long getId() {return id;}

    public Produto getProduto() {return produto;}

    public int getQuantidade() {return quantidade;}
    public void setQuantidade(int quantidade) {this.quantidade = quantidade;}
    
    public int getEstoqueMin() {return estoqueMin;}
    public void setEstoqueMin(int estoqueMin) {this.estoqueMin = estoqueMin;}
    
    public int getEstoqueMax() {return estoqueMax;}
    public void setEstoqueMax(int estoqueMax) {this.estoqueMax = estoqueMax;}

    public static ItemDeEstoque fromModel (ItemDeEstoqueModel IEModel) {
        return new ItemDeEstoque(IEModel.getId(), Produto.fromProdutoModel(IEModel.getProduto()), IEModel.getQuantidade(), IEModel.getEstoqueMin(), IEModel.getEstoqueMax());
    }
     public static ItemDeEstoqueModel toModel (ItemDeEstoque IE) {
        return new ItemDeEstoqueModel(IE.getId(), Produto.toProdutoModel(IE.getProduto()), IE.getQuantidade(), IE.getEstoqueMin(), IE.getEstoqueMax());
    }
}
