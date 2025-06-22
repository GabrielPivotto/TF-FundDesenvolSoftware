package com.tffds.tf.dominio.modelos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PedidoModel {
    private List<ItemPedidoModel> itens;
    private String pais;
    private String estado;


    public PedidoModel(long id, List<ItemPedidoModel> itens, String pais, String estado) {
        this.id = id;
        this.itens = itens;
        this.pais = pais;
        this.estado = estado;
    }


    public List<ItemPedidoModel> getItens() {
        return this.itens;
    }

    public void setItens(List<ItemPedidoModel> itens) {
        this.itens = itens;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
   
}