package com.tffds.tf.adaptadores_de_interfaces.persistencia.obj_persistencia;

import java.time.LocalDate;
import java.util.List;

import com.tffds.tf.dominio.modelos.ItemDeEstoqueModel;
import com.tffds.tf.dominio.modelos.OrcamentoModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Orcamento {

    @Id
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemPedido> itens;

    private String pais;
    private String estado;
    private double custoItens;
    private double impFederal;
    private double impEstadual;
    private double desconto;
    private LocalDate dataCriacao;
    private double custoConsumidor;
    private boolean efetivado;

    protected Orcamento() {}

    public Orcamento(long id, List<ItemPedido> itens, String pais, String estado, double custoItens, double impFederal, double impEstadual, double desconto, LocalDate dataCriacao, double custoConsumidor, boolean efetivado) {
        this.id = id;
        this.itens = itens;
        this.pais = pais;
        this.estado = estado;
        this.custoItens = custoItens;
        this.impFederal = impFederal;
        this.impEstadual = impEstadual;
        this.desconto = desconto;
        this.dataCriacao = dataCriacao;
        this.custoConsumidor = custoConsumidor;
        this.efetivado = efetivado;
    }

    public long getId() {return id;}

    public List<ItemPedido> getItens() {return itens;}

    public String getPais() {return pais;}

    public String getEstado() {return estado;}

    public double getCustoItens() {return custoItens;}

    public double getImpFederal() {return impFederal;}

    public double getImpEstadual() {return impEstadual;}

    public double getDesconto() {return desconto;}

    public LocalDate getDataCriacao() {return dataCriacao;}

    public double getCustoConsumidor() {return custoConsumidor;}

    public boolean isEfetivado() {return efetivado;}

    public void setEfetivado(boolean efetivado) {this.efetivado = efetivado;}

    public static Orcamento fromModel (OrcamentoModel orcModel) {
        return new Orcamento(orcModel.getId(), orcModel.getItens());
    }
     public static OrcamentoModel toModel (Orcamento orc) {
        return new OrcamentoModel(IE.getId(), Produto.toProdutoModel(IE.getProduto()), IE.getQuantidade(), IE.getEstoqueMin(), IE.getEstoqueMax());
    }
}