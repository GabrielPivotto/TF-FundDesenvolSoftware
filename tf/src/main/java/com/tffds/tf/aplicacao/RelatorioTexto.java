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
    private InterfaceRepOrcamento repOrc;

    public RelatorioTexto(InterfaceRepOrcamento repOrc) {
        this.repOrc = repOrc;
    }
        
    public String gerarRelatorio() {
        List<OrcamentoModel> orc = repOrc.todos();
        List<OrcamentoDTO> vendas = new LinkedList<>();

        // pega os OrcamentoModel efetivado e transforma em OrcamentoDTO
        for(OrcamentoModel oM : orc) {
            if (oM.isEfetivado()) {vendas.add(OrcamentoDTO.fromModel(oM));} 
        }

        Map<ProdutoDTO, Integer> valorVendas = new HashMap<ProdutoDTO, Integer>();

        // coloca os ProdutoDTO dentro do HashMap (ou incrementando no valor)
        for(OrcamentoDTO orcEfetivado : vendas) {
            List<ItemPedidoDTO> itens = orcEfetivado.getItens();

            // loop para checar cada ProdutoDTO dentro de ItemPedidoDTO
            for(ItemPedidoDTO pedido : itens) {
                if(valorVendas.containsKey(pedido.getProduto())) {
                    valorVendas.put(pedido.getProduto(), valorVendas.get(pedido.getProduto()) + pedido.getQtdade());
                }
                else {valorVendas.put(pedido.getProduto(), pedido.getQtdade());}
            }
        }
        //gerando texto para o relatorio
        StringBuilder relatorioTexto = new StringBuilder();
        
        relatorioTexto.append("Relatorio de Vendas:\n");

        for (ProdutoDTO chave : valorVendas.keySet()) {
            int qtd = valorVendas.get(chave); 
            relatorioTexto.append(String.format("Nome do Produto: %s \n ID: %d \n Quantidade total vendida: %d \n Lucro (calculo unitario): %.2f\n\n", 
                chave.getDescricao(), 
                chave.getId(), 
                qtd, 
                chave.getPrecoUnitario()*qtd));
        }
        
        return relatorioTexto.toString();
    }
}
