package com.tffds.tf.aplicacao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tffds.tf.aplicacao.dtos.ItemPedidoDTO;
import com.tffds.tf.aplicacao.dtos.OrcamentoDTO;
import com.tffds.tf.aplicacao.dtos.ProdutoDTO;
import com.tffds.tf.dominio.interfaces_persistencia.InterfaceRepOrcamento;
import com.tffds.tf.dominio.interfaces_persistencia.InterfaceRepProdutos;
import com.tffds.tf.dominio.modelos.OrcamentoModel;

@Service
public class ServicoRelatorio {
    private InterfaceRepOrcamento repOrc;
    private InterfaceRelatorio relatorio;

    @Autowired
    public ServicoRelatorio(InterfaceRepOrcamento repOrc) {
        this.repOrc = repOrc;
        
    }

    public String gerarRelatorio(String tipo) {
        switch(tipo) {
            case "html": {
                relatorio = new RelatorioHTML();
                break;
            }
            case "txt": {
                relatorio = new RelatorioTexto();
                break;
            }
        }
        
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

            return relatorio.gerarRelatorio(valorVendas);
    }
}