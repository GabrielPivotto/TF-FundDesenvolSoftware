package com.tffds.tf.aplicacao.casos_de_uso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tffds.tf.aplicacao.dtos.ItemDeEstoqueDTO;
import com.tffds.tf.aplicacao.dtos.ProdutoDTO;
import com.tffds.tf.dominio.servicos.ServicoItemDeEstoque;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

@Component
public class ProdutosAcabandoUC {
    private final ServicoItemDeEstoque servicoEst;

    @Autowired
    public ProdutosAcabandoUC(ServicoItemDeEstoque servicoEst) {
        this.servicoEst = servicoEst;
    }

    public List<ItemDeEstoqueDTO> run() {
        List<ItemDeEstoqueDTO> list = servicoEst.podutosDisponiveis().stream()
        .map(p -> ItemDeEstoqueDTO.fromModel(p)).toList();


        list = new ArrayList<>(list);

        //list.sort(Comparator.comparingDouble(p1 ->(double)(p1.getQuantidade()-p1.getEstoqueMin())/(double)(p1.getEstoqueMax())-p1.getEstoqueMin()));

        list.sort(Comparator.comparingDouble(p1 ->(double)(p1.getQuantidade()-p1.getEstoqueMin())/(double)(p1.getEstoqueMax()-p1.getEstoqueMin())));
        return list;
    }
}
