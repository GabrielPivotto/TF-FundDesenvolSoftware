package com.tffds.tf.aplicacao.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.tffds.tf.dominio.modelos.ItemPedidoModel;
import com.tffds.tf.dominio.modelos.OrcamentoModel;

public class OrcamentoDTO {
    private long id;
    private List<ItemPedidoDTO> itens;
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


    // constructor que transfere de outros tipos para DTO
    public OrcamentoDTO(long id, List<ItemPedidoDTO> itens, String pais, String estado, double custoItens, double impFederal, double impEstadual, double desconto, LocalDate dataCriacao, double custoConsumidor, boolean efetivado) {
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

    public List<ItemPedidoDTO> getItens(){return itens;}


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

    public double getImpEstadual() {
        return this.impEstadual;
    }

    public double getDesconto() {
        return this.desconto;
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


    public static OrcamentoDTO fromModel(OrcamentoModel orcamento){
        List<ItemPedidoDTO> itens = new ArrayList<>(orcamento.getItens().size());
        for(ItemPedidoModel ip:orcamento.getItens()){
            itens.add(ItemPedidoDTO.fromModel(ip));
        }

        return new OrcamentoDTO(orcamento.getId(), itens, orcamento.getPais(), orcamento.getEstado(), orcamento.getCustoItens(), orcamento.getImpFederal(), orcamento.getImpEstadual(), orcamento.getDesconto(), orcamento.getDataCriacao(), orcamento.getCustoConsumidor(), orcamento.isEfetivado());
    }
    
    public static OrcamentoModel toModel(OrcamentoDTO orcamento){
        List<ItemPedidoModel> itens = new ArrayList<>(orcamento.getItens().size());
        for(ItemPedidoDTO ip:orcamento.getItens()){
            itens.add(ItemPedidoDTO.toModel(ip));
        }

        return new OrcamentoModel(orcamento.getId(), itens, orcamento.getPais(), orcamento.getEstado(), orcamento.getCustoItens(), orcamento.getImpFederal(), orcamento.getImpEstadual(), orcamento.getDesconto(), orcamento.getDataCriacao(), orcamento.getCustoConsumidor(), orcamento.isEfetivado());
    }
}

