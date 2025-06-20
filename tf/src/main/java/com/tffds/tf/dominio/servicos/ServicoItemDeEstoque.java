package com.tffds.tf.dominio.servicos;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tffds.tf.dominio.interfaces_persistencia.InterfaceRepItemDeEstoque;
import com.tffds.tf.dominio.modelos.ItemDeEstoqueModel;
import com.tffds.tf.dominio.modelos.ProdutoModel;

@Service
public class ServicoItemDeEstoque{
    private InterfaceRepItemDeEstoque estoque;
    
    @Autowired
    public ServicoItemDeEstoque(InterfaceRepItemDeEstoque estoque) {
        this.estoque = estoque;
    }
 
    public List<ItemDeEstoqueModel> podutosDisponiveis() {
        return estoque.emEstoque();
    }

    public List<ItemDeEstoqueModel> qtdadeEmEstoqueLista(List<ProdutoModel> prods) {
        List<ItemDeEstoqueModel> lista = new ArrayList<>(prods.size()); // cria lista de ItemDeEstoqueModel pela quantidade de itens

        for(ProdutoModel prod : prods) { // para cada produto na lista
            ItemDeEstoqueModel item = estoque.pegaPorId(prod.getId()); // pega sua contraparte em ItemDeEstoqueModel
            if(item != null) {lista.add(item);}
        }

        return lista;
    }

    public boolean entradaEstoque(long id,int qtd){
        ItemDeEstoqueModel item = estoque.pegaPorId(id);
        
        if(item != null) {
            if(item.getQuantidade() + qtd > item.getEstoqueMax()) {return false;}

            item.setQuantidade(item.getQuantidade() + qtd); 

            estoque.entradaEmEstoque(item);
            return true;
        }
        
        return false;
    }  
}
