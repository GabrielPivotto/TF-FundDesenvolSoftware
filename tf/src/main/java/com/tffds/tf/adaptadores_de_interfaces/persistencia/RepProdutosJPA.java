package com.tffds.tf.adaptadores_de_interfaces.persistencia;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.tffds.tf.adaptadores_de_interfaces.persistencia.obj_persistencia.Produto;
import com.tffds.tf.dominio.interfaces_persistencia.InterfaceRepProdutos;
import com.tffds.tf.dominio.modelos.ProdutoModel;

@Repository
public class RepProdutosJPA implements InterfaceRepProdutos{
    private InterfaceRepProdutoJPA repProd;

    public RepProdutosJPA(InterfaceRepProdutoJPA repProd) {
        this.repProd = repProd;
    }

    @Override
    public List<ProdutoModel> todos() {
        List<Produto> prods = repProd.findAll();
        if(prods.size() == 0) {
            return new LinkedList<ProdutoModel>();
        } else {
            return prods.stream().map(p -> Produto.toProdutoModel(p)).toList();
        }
    }

    @Override
    public ProdutoModel consultaPorId(long id) {
        Optional<Produto> prod = repProd.findById(id);
        if(!prod.isPresent()) {
            return null;
        } else {
            return Produto.toProdutoModel(prod.get());
        }

    }
    
}