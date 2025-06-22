package com.tffds.tf.aplicacao.casos_de_uso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tffds.tf.aplicacao.dtos.ItemDeEstoqueDTO;
import com.tffds.tf.aplicacao.dtos.ProdutoDTO;
import com.tffds.tf.dominio.servicos.ServicoItemDeEstoque;

import java.util.List;

@Component
public class ProdutosAcabandoUC {
    private final ServicoItemDeEstoque servicoEst;

    @Autowired
    public ProdutosAcabandoUC(ServicoItemDeEstoque servicoEst) {
        this.servicoEst = servicoEst;
    }

    public List<ItemDeEstoqueDTO> run() {
        return servicoEst.podutosDisponiveis().stream().sorted((p1, p2) -> Double
        .compare((p1.getQuantidade()-p1.getEstoqueMin())/(p1.getEstoqueMax()-p1.getEstoqueMin()), (p2.getQuantidade()-p2.getEstoqueMin())/(p2.getEstoqueMax()-p2.getEstoqueMin()))) 
        .map(p -> ItemDeEstoqueDTO.fromModel(p)).toList();
    }
}
