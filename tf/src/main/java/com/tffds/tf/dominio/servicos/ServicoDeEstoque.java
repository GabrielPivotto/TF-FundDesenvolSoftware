package com.tffds.tf.dominio.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tffds.tf.dominio.interfaces_persistencia.InterfaceRepEstoque;
import com.tffds.tf.dominio.interfaces_persistencia.InterfaceRepProdutos;
import com.tffds.tf.dominio.modelos.ItemDeEstoqueModel;
import com.tffds.tf.dominio.modelos.ProdutoModel;

//@Service
public class ServicoDeEstoque{
    private InterfaceRepEstoque estoque;
    private InterfaceRepProdutos produtos;
    
//    @Autowired
    public ServicoDeEstoque(InterfaceRepProdutos produtos,InterfaceRepEstoque estoque){
        this.produtos = produtos;
        this.estoque = estoque;
    }
 
    //public List<ProdutoModel> produtosDisponiveis(){
    //    return estoque.findAll().stream()
    //        .filter(item -> item.getQuantidade() > 0)
    //        .map(ItemDeEstoqueModel::getProduto)
    //        .toList();
    //}
//
    //public ProdutoModel produtoPorCodigo(long id){
    //    return this.produtos.consultaPorId(id);
    //}
//
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
