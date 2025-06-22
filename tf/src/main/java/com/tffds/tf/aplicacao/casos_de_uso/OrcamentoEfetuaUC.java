package com.tffds.tf.aplicacao.casos_de_uso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.tffds.tf.dominio.servicos.ServicoOrcamento;

@Component
public class OrcamentoEfetuaUC {
    private final ServicoOrcamento servicoOrcamento;

    @Autowired
    public OrcamentoEfetuaUC(ServicoOrcamento servicoOrcamento) {
        this.servicoOrcamento = servicoOrcamento;
    }

    public boolean run(long id) {

        return servicoOrcamento.efetuaOrcamento(id);
    }
}