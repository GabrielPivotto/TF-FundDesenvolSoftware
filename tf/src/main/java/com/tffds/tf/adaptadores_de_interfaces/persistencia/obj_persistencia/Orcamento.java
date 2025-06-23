package com.tffds.tf.adaptadores_de_interfaces.persistencia.obj_persistencia;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import com.tffds.tf.dominio.modelos.ItemPedidoModel;
import com.tffds.tf.dominio.modelos.OrcamentoModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Orcamento {

    @Id
    private long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "orcamento_id")
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

    public void incId() {this.id++;}

    public long getId() {return id;}

    public void incId() {this.id++;}

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
        List<ItemPedidoModel> listItemPedM = orcModel.getItens();
        List<ItemPedido> listItemPed = new ArrayList<>(listItemPedM.size());
        for(ItemPedidoModel itemPedM : listItemPedM) {
            listItemPed.add(ItemPedido.fromModel(itemPedM));
        }
        
        return new Orcamento(orcModel.getId(), listItemPed, orcModel.getPais(), orcModel.getEstado(), orcModel.getCustoItens(), orcModel.getImpFederal(), orcModel.getImpEstadual(), orcModel.getDesconto(), orcModel.getDataCriacao(), orcModel.getCustoConsumidor(), orcModel.isEfetivado());
    }

     public static OrcamentoModel toModel (Orcamento orc, List<ItemPedidoModel> lista) {
        return new OrcamentoModel(orc.getId(), lista, orc.getPais(), orc.getEstado(), orc.getCustoItens(), orc.getImpFederal(), orc.getImpEstadual(), orc.getDesconto(), orc.getDataCriacao(), orc.getCustoConsumidor(), orc.isEfetivado());
    }
}