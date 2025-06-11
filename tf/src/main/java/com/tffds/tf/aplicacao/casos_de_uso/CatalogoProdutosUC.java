package com.tffds.tf.aplicacao.casos_de_uso;

import org.springframework.stereotype.Component;

import com.tffds.tf.aplicacao.dtos.ProdutoDTO;
import com.tffds.tf.dominio.servicos.ServicoProduto;

import java.util.List;

@Component
public class CatalogoProdutosUC {
    private final ServicoProduto servicoProd;

    CatalogoProdutosUC(ServicoProduto servicoProd) {
        this.servicoProd = servicoProd;
    }

    public List<ProdutoDTO> run() {
        return servicoProd.entregaCatalogo().stream().map(p -> ProdutoDTO.fromProdutoModel(p)).toList();
    }
}
