package com.tffds.tf.dominio.modelos;

import java.time.LocalDate;
import java.util.List;

public class OrcamentoModel {
    private long id;
    private List<ItemPedidoModel> itens;
    private String pais;
    private String estado;
    private double custoItens;
    private double impFederal;
    private double impEstadual;
    private double desconto;
    private LocalDate dataCriacao;
    private double custoConsumidor;
    private boolean efetivado;  // sempre checar se é efetivado pois se chegar de
                                // um repositorio, deve ser declarado como final

    public OrcamentoModel(long id, List<ItemPedidoModel> its, String pais, String estado, Imposto federal, Imposto estadual, Desconto desconto) {
        this.id = id;
        this.itens = its;
        this.efetivado = false;
        dataCriacao = LocalDate.now();
        custoItens = 0;
        this.estado = estado;
        this.pais = pais;

        impFederal = federal.calcula(itens);
        impEstadual = estadual.calcula(itens);

        this.desconto = desconto.calcula(itens);

        for (ItemPedidoModel item : itens) {
            custoItens += item.getPreco();
        }
        custoConsumidor = custoItens + impEstadual + impFederal - this.desconto;
    }

    // constructor que transfere de outros tipos para model
    public OrcamentoModel(long id, List<ItemPedidoModel> itens, String pais, String estado, double custoItens, double impFederal, double impEstadual, double desconto, LocalDate dataCriacao, double custoConsumidor, boolean efetivado) {
        this.id = id;
        this.itens = itens;
        this.estado = estado;
        this.pais = pais;
        this.custoItens = custoItens;
        this.impFederal = impFederal;
        this.impEstadual = impEstadual;
        this.desconto = desconto;
        this.dataCriacao = dataCriacao;
        this.custoConsumidor = custoConsumidor;
        this.efetivado = efetivado;
    }

    public List<ItemPedidoModel> getItens(){return itens;}


    public long getId() {
        return this.id;
    }

    public String getPais(){return pais;}
    public String getEstado() {return estado;}


    public double getCustoItens() {
        return this.custoItens;
    }

    public double getImpFederal() {
        return this.impFederal;
    }

    public void recalculaImpFederal(Imposto Federal) {
        this.impFederal = Federal.calcula(itens);
        custoConsumidor = custoItens + impEstadual + impFederal - desconto;
    }

    public double getImpEstadual() {
        return this.impEstadual;
    }

    public void recalculaImpEstadual(Imposto Estadual) {
        this.impEstadual = Estadual.calcula(itens);
        custoConsumidor = custoItens + impEstadual + impFederal - desconto;
    }

    public double getDesconto() {
        return this.desconto;
    }

    public void recalculaDesconto(Desconto desconto) {
        this.desconto = desconto.calcula(itens);
        custoConsumidor = custoItens + impEstadual + impFederal - this.desconto;
    }

    public LocalDate getDataCriacao() {
        return this.dataCriacao;
    }

    public double getCustoConsumidor() {
        return this.custoConsumidor;
    }


    public boolean isEfetivado() {
        return this.efetivado;
    }

    public void setEfetivado(boolean efetivado) {
        this.efetivado = efetivado;
    }
    
}

