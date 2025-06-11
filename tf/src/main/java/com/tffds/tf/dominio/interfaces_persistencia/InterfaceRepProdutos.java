package com.tffds.tf.dominio.interfaces_persistencia;

import com.tffds.tf.dominio.modelos.ProdutoModel;

import java.util.List;

public interface InterfaceRepProdutos {
    List<ProdutoModel> todos();
    ProdutoModel consultaPorId(long codigo);
}
