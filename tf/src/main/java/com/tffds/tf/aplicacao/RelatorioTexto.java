package com.tffds.tf.aplicacao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.tffds.tf.aplicacao.dtos.ItemPedidoDTO;
import com.tffds.tf.aplicacao.dtos.OrcamentoDTO;
import com.tffds.tf.aplicacao.dtos.ProdutoDTO;
import com.tffds.tf.dominio.interfaces_persistencia.InterfaceRepOrcamento;
import com.tffds.tf.dominio.modelos.OrcamentoModel;

public class RelatorioTexto implements InterfaceRelatorio{
    
    public RelatorioTexto() {}
        
    public String gerarRelatorio(Map<ProdutoDTO, Integer> valores) {
        
        //gerando texto para o relatorio
        StringBuilder relatorioTexto = new StringBuilder();
        
        relatorioTexto.append("Relatorio de Vendas:\n");

        for(ProdutoDTO chave : valores.keySet()) {
            int qtd = valores.get(chave); 

            relatorioTexto.append(String.format("Nome do Produto: %s \n ID: %d \n Quantidade total vendida: %d \n Lucro (calculo unitario): %.2f\n\n", 
                chave.getDescricao(), 
                chave.getId(), 
                qtd, 
                chave.getPrecoUnitario()*qtd));
        }
        
        return relatorioTexto.toString();
    }
}