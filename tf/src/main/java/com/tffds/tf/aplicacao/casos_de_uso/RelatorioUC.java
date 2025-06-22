package com.tffds.tf.aplicacao.casos_de_uso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tffds.tf.aplicacao.ServicoRelatorio;

@Component
public class RelatorioUC {
    private final ServicoRelatorio servicoRelatorio;

    @Autowired
    public RelatorioUC(ServicoRelatorio servicoRelatorio) {
        this.servicoRelatorio = servicoRelatorio;
    }

    public String run(String formato) {
        return servicoRelatorio.gerarRelatorio(formato);
    }
}