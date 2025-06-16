package com.tffds.tf.dominio.servicos;

import com.tffds.tf.dominio.interfaces_persistencia.InterfaceRepProdutos;
import com.tffds.tf.dominio.modelos.ProdutoModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoProduto {
    private InterfaceRepProdutos produtos;

    @Autowired
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
