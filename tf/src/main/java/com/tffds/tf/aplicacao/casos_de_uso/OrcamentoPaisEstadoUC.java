package com.tffds.tf.aplicacao.casos_de_uso;

import java.util.List;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.tffds.tf.aplicacao.dtos.OrcamentoDTO;
import com.tffds.tf.dominio.servicos.ServicoOrcamento;

@Component
public class OrcamentoPaisEstadoUC {
    private final ServicoOrcamento servicoOrcamento;

    @Autowired
    public OrcamentoPaisEstadoUC(ServicoOrcamento servicoOrcamento) {
        this.servicoOrcamento = servicoOrcamento;
    }

    public List<OrcamentoDTO> run(String pais, String estado) {

        return servicoOrcamento.orcamentos()
        .stream()
        .filter(o -> o.getPais().equalsIgnoreCase(pais))
        .filter(o -> o.getEstado().equalsIgnoreCase(estado))
        .map(o -> OrcamentoDTO.fromModel(o))
        .toList();
       
    }
}