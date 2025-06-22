package com.tffds.tf.aplicacao.casos_de_uso;

import java.util.List;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.tffds.tf.aplicacao.dtos.OrcamentoDTO;
import com.tffds.tf.dominio.servicos.ServicoOrcamento;

@Component
public class OrcamentosEfetuadosUC {
    private final ServicoOrcamento servicoOrcamento;

    @Autowired
    public OrcamentosEfetuadosUC(ServicoOrcamento servicoOrcamento) {
        this.servicoOrcamento = servicoOrcamento;
    }

    public List<OrcamentoDTO> run(boolean efetuado) {

        return servicoOrcamento.orcamentos()
        .stream()
        .filter(o -> o.isEfetivado() == efetivado)
        .map(o -> OrcamentoDTO.fromModel(o))
        .toList();
       
    }
}