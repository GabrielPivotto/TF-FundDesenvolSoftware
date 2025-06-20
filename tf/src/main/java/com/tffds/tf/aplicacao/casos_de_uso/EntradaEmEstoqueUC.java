package com.tffds.tf.aplicacao.casos_de_uso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tffds.tf.dominio.servicos.ServicoItemDeEstoque;

@Component
public class EntradaEmEstoqueUC {
    private final ServicoItemDeEstoque servicoItemEstoque;

    @Autowired
    public EntradaEmEstoqueUC(ServicoItemDeEstoque servicoItemEstoque) {
        this.servicoItemEstoque = servicoItemEstoque;
    }
    
    public boolean run(Long id, int qtd) {
        return servicoItemEstoque.entradaEstoque(id, qtd);
    }
}