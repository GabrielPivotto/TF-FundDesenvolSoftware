package com.tffds.tf.adaptadores_de_interfaces.persistencia;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tffds.tf.adaptadores_de_interfaces.persistencia.obj_persistencia.ItemDeEstoque;
import com.tffds.tf.dominio.interfaces_persistencia.InterfaceRepItemDeEstoque;
import com.tffds.tf.dominio.modelos.ItemDeEstoqueModel;
@Repository
public class RepItemDeEstoqueJPA implements InterfaceRepItemDeEstoque {
    private InterfaceRepItemDeEstoqueJPA repItemEstoque;

    @Autowired
    public RepItemDeEstoqueJPA(InterfaceRepItemDeEstoqueJPA repItemEstoque) {
        this.repItemEstoque = repItemEstoque;
    }

    @Override
    public List<ItemDeEstoqueModel> emEstoque() {
        List<ItemDeEstoque> itens = repItemEstoque.findAll().stream().filter(ie -> ie.getQuantidade() > 0).toList();
        if(itens.size() == 0) {
            return new LinkedList<ItemDeEstoqueModel>();
        } else {
            return itens.stream().map(ie -> ItemDeEstoque.toItemDeEstoqueModel(ie)).toList();
        }
    }
    
}
