package com.tffds.tf.adaptadores_de_interfaces.persistencia;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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
            return itens.stream().map(ie -> ItemDeEstoque.toModel(ie)).toList();
        }
    }

    @Override
    public ItemDeEstoqueModel pegaPorId(Long id) {
        Optional<ItemDeEstoque> item = repItemEstoque.findByProdutoId(id);

        if(item.isEmpty()) {
            return null;
        } else {return ItemDeEstoque.toModel(item.get());}
    }

    @Override
    public boolean entradaEmEstoque(ItemDeEstoqueModel itemEstoque) {
        ItemDeEstoque item = ItemDeEstoque.fromModel(itemEstoque);
        repItemEstoque.save(item);
        return true;
    }

    @Override
    public boolean baixaEmEstoque(ItemDeEstoqueModel ieM, int qtd) {
        ItemDeEstoque itemEstoque = ItemDeEstoque.fromModel(ieM);
        if(itemEstoque.getQuantidade() - qtd < itemEstoque.getEstoqueMin()) {return false;}
        itemEstoque.setQuantidade(itemEstoque.getQuantidade() - qtd);
        repItemEstoque.save(itemEstoque);
        return true;
    }
}
