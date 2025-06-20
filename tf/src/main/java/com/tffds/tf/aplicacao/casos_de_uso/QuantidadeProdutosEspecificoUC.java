package com.tffds.tf.aplicacao.casos_de_uso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tffds.tf.aplicacao.dtos.ItemDeEstoqueDTO;
import com.tffds.tf.aplicacao.dtos.ProdutoDTO;
import com.tffds.tf.dominio.modelos.ProdutoModel;
import com.tffds.tf.dominio.servicos.ServicoItemDeEstoque;

@Component
public class QuantidadeProdutosEspecificoUC {
    private final ServicoItemDeEstoque servicoItemEstoque;

    @Autowired
    public QuantidadeProdutosEspecificoUC(ServicoItemDeEstoque servicoItemEstoque) {
        this.servicoItemEstoque = servicoItemEstoque;
    }

    public List<ItemDeEstoqueDTO> run(List<ProdutoDTO> prod) {
        List<ProdutoModel> lista = prod.stream().map(p -> ProdutoDTO.toProdutoModel(p)).toList(); // transforma a lista de ProdutoDTo em lista de ProdutoModel para entrar na camada de dominio
        
        // servicoItemEstoque vai transformar a lista de ProdutoModel em uma lista de ItemDeEstoqueModel na qual vira ItemDeEstoqueDTO
        return servicoItemEstoque.qtdadeEmEstoqueLista(lista).stream().map(ie -> ItemDeEstoqueDTO.fromModel(ie)).toList();
    }
}