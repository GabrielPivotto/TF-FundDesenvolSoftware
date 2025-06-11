package com.tffds.tf.dominio.servicos;

import com.tffds.tf.dominio.interfaces_persistencia.InterfaceRepProdutos;
import com.tffds.tf.dominio.modelos.ProdutoModel;

import java.util.List;

public class ServicoProduto {
    private InterfaceRepProdutos produtos;

    public ServicoProduto (InterfaceRepProdutos produtos) {
        this.produtos = produtos;
    }

    public List<ProdutoModel> entregaCatalogo() {
        return this.produtos.todos();
    }

    public ProdutoModel produtoPorCodigo(long id){
        return this.produtos.consultaPorId(id);
    }
}
