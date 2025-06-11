package com.tffds.tf.dominio.interfaces_persistencia;

import com.tffds.tf.dominio.modelos.ProdutoModel;

import java.util.List;

public interface InterfaceRepEstoque {
    List<ProdutoModel> todos();
    List<ProdutoModel> todosComEstoque();
    int quantidadeEmEstoque(long codigo);
    void baixaEstoque(long codProd, int qtdade);
    void chegadaEstoque(long codProd, int qtdade);
}
