package com.tffds.tf.aplicacao.casos_de_uso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tffds.tf.aplicacao.dtos.ProdutoDTO;
import com.tffds.tf.dominio.servicos.ServicoProduto;

import java.util.List;

@Component
public class CatalogoProdutosUC {
    private final ServicoProduto servicoProd;

    @Autowired
    public CatalogoProdutosUC(ServicoProduto servicoProd) {
        this.servicoProd = servicoProd;
    }

    public List<ProdutoDTO> run() {
        return servicoProd.entregaCatalogo().stream().map(p -> ProdutoDTO.fromProdutoModel(p)).toList();
    }
}
