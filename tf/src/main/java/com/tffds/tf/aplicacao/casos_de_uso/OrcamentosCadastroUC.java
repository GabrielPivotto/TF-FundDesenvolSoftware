package com.tffds.tf.aplicacao.casos_de_uso;

import java.util.List;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.tffds.tf.aplicacao.dtos.OrcamentoDTO;
import com.tffds.tf.aplicacao.dtos.PedidoDTO;
import com.tffds.tf.dominio.servicos.ServicoOrcamento;

@Component
public class OrcamentosCadastroUC {
    private final ServicoOrcamento servicoOrcamento;

    @Autowired
    public OrcamentosEfetivadosUC(ServicoOrcamento servicoOrcamento) {
        this.servicoOrcamento = servicoOrcamento;
    }

    public OrcamentoDTO run(PedidoDTO pedido) {

        return OrcamentoDTO.fromModel(servicoOrcamento.buildOrcamento(PedidoDTO.toModel(pedido)));
        
    }
}