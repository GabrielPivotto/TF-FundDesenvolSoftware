package com.tffds.tf.dominio.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tffds.tf.dominio.interfaces_persistencia.InterfaceRepItemDeEstoque;
import com.tffds.tf.dominio.interfaces_persistencia.InterfaceRepProdutos;
import com.tffds.tf.dominio.modelos.ItemDeEstoqueModel;
import com.tffds.tf.dominio.modelos.ProdutoModel;

@Service
public class ServicoItemDeEstoque{
    private InterfaceRepItemDeEstoque estoque;
    private InterfaceRepProdutos produtos;
    
    @Autowired
    public ServicoItemDeEstoque(InterfaceRepProdutos produtos,InterfaceRepItemDeEstoque estoque){
        this.produtos = produtos;
        this.estoque = estoque;
    }
 
    public List<ItemDeEstoqueModel> podutosDisponiveis(){
        return estoque.emEstoque();
    }

    //public int qtdadeEmEstoque(long id){
    //    ItemDeEstoqueModel item = estoque.findByProdutoId(id).orElse(null);
    //    if(item != null){
    //        return item.getQuantidade();
    //    }
    //    return 0;
    //}
//
    //public boolean baixaEstoque(long id,int qtdade){
    //    ItemDeEstoqueModel item = estoque.findById(id).orElse(null);
    //    if(item != null) {
    //        if((item.getQuantidade() - qtdade) < 0) {return false;} //ADICIONADO
    //        item.setQuantidade(item.getQuantidade() - qtdade);
    //        estoque.save(item);
    //        return true;
    //    }
//
    //    return false;
    //}  
//
    //public void entradaEstoque(long id,int qtdade){
    //    //ache primeiro todos os itens de mesmo id
    //    ItemDeEstoqueModel item = estoque.findById(id).orElse(null);
    //    
    //    if(item != null) {
    //        //acrescenta a qtd existente com a nova e salva novamente no BD
    //        item.setQuantidade(item.getQuantidade() + qtdade); 
    //        estoque.save(item);
    //    }
    //}  
}
