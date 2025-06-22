package com.tffds.tf.aplicacao.casos_de_uso;

import java.util.List;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.tffds.tf.aplicacao.dtos.OrcamentoDTO;
import com.tffds.tf.dominio.servicos.ServicoOrcamento;

@Component
public class OrcamentoEntreDatasUC {
    private final ServicoOrcamento servicoOrcamento;

    @Autowired
    public OrcamentoEntreDatasUC(ServicoOrcamento servicoOrcamento) {
        this.servicoOrcamento = servicoOrcamento;
    }

    public List<OrcamentoDTO> run(String from, String to) {

        return null;
        //return servicoOrcamento.orcamentos()
        //.stream()
        //.filter(o -> o.getDataCriacao().isAfter(LocalDate.parse(from)))
        //.filter(o -> o.getDataCriacao().isBefore(LocalDate.parse(to)))
        //.map(o -> OrcamentoDTO.fromModel(o))
        //.toList();
       
    }
}