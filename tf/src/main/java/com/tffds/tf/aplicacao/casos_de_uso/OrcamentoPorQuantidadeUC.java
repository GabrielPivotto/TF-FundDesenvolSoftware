package com.tffds.tf.aplicacao.casos_de_uso;

import java.util.List;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.tffds.tf.aplicacao.dtos.OrcamentoDTO;
import com.tffds.tf.dominio.servicos.ServicoOrcamento;

import com.tffds.tf.dominio.modelos.ItemPedidoModel;

@Component
public class OrcamentoPorQuantidadeUC {
    private final ServicoOrcamento servicoOrcamento;

    @Autowired
    public OrcamentoPorQuantidadeUC(ServicoOrcamento servicoOrcamento) {
        this.servicoOrcamento = servicoOrcamento;
    }

    public List<OrcamentoDTO> run(int min, int max) {

        return servicoOrcamento.orcamentos()
        .stream()
        .filter(o -> {
            List<ItemPedidoModel> itens = o.getItens();
            int count = 0;
            for (ItemPedidoModel itemPedidoModel : itens) {
                count += itemPedidoModel.getQuantidade();
            }
            return (count>=min)&&(count<=max);
        })
        .map(o -> OrcamentoDTO.fromModel(o))
        .toList();
       
    }
}