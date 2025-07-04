package com.tffds.tf.dominio.interfaces_persistencia;

import com.tffds.tf.dominio.modelos.ItemDeEstoqueModel;
import com.tffds.tf.dominio.modelos.ProdutoModel;

import java.util.List;

public interface InterfaceRepItemDeEstoque {
    List<ItemDeEstoqueModel> emEstoque();
    ItemDeEstoqueModel pegaPorId(Long id);
    boolean entradaEmEstoque(ItemDeEstoqueModel itemEstoque);
    boolean baixaEmEstoque(ItemDeEstoqueModel itemEstoque, int qtd);
}
