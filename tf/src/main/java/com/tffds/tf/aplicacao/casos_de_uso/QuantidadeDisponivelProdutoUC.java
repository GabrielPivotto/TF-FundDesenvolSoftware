package com.tffds.tf.aplicacao.casos_de_uso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tffds.tf.aplicacao.dtos.ItemDeEstoqueDTO;
import com.tffds.tf.dominio.servicos.ServicoItemDeEstoque;

@Component
public class QuantidadeDisponivelProdutoUC {
    private final ServicoItemDeEstoque servicoItemEstoque;

    @Autowired
    public QuantidadeDisponivelProdutoUC(ServicoItemDeEstoque servicoItemEstoque) {
        this.servicoItemEstoque = servicoItemEstoque;
    }

    public List<ItemDeEstoqueDTO> run() {
        return servicoItemEstoque.podutosDisponiveis().stream().map(ie -> ItemDeEstoqueDTO.fromModel(ie)).toList();
    }
}
