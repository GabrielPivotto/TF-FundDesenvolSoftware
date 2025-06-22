package com.tffds.tf.aplicacao.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.tffds.tf.dominio.modelos.ItemPedidoModel;
import com.tffds.tf.dominio.modelos.PedidoModel;

public class PedidoDTO {
    private long id;
    private List<ItemPedidoDTO> itens;
    private String pais;
    private String estado;


    // constructor que transfere de outros tipos para DTO
    public PedidoDTO(long id, List<ItemPedidoDTO> itens, String pais, String estado) {
        this.id = id;
        this.itens = itens;
        this.estado = estado;
        this.pais = pais;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<ItemPedidoDTO> getItens(){return itens;}


    public String getPais(){return pais;}
    public String getEstado() {return estado;}

    public static PedidoDTO fromModel(PedidoModel pedido){
        List<ItemPedidoDTO> itens = new ArrayList<>(pedido.getItens().size());
        for(ItemPedidoModel ip:pedido.getItens()){
            itens.add(ItemPedidoDTO.fromModel(ip));
        }

        return new PedidoDTO(pedido.getId(), itens, pedido.getPais(), pedido.getEstado());
    }
    
    public static PedidoModel toModel(PedidoDTO pedido){
        List<ItemPedidoModel> itens = new ArrayList<>(pedido.getItens().size());
        for(ItemPedidoDTO ip:pedido.getItens()){
            itens.add(ItemPedidoDTO.toModel(ip));
        }

        return new PedidoModel(pedido.getId(), itens, pedido.getPais(), pedido.getEstado());
    }
}

