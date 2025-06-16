package com.tffds.tf.aplicacao.casos_de_uso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tffds.tf.aplicacao.dtos.ItemPedidoDTO;
import com.tffds.tf.aplicacao.dtos.OrcamentoDTO;
import com.tffds.tf.dominio.modelos.ItemPedidoModel;
import com.tffds.tf.dominio.modelos.OrcamentoModel;
import com.tffds.tf.dominio.modelos.PedidoModel;
import com.tffds.tf.dominio.modelos.ProdutoModel;
import com.tffds.tf.dominio.servicos.ServicoDeEstoque;
import com.tffds.tf.dominio.servicos.ServicoOrcamento;

@Component
public class SolicitarOrcamentoUC {
    private final ServicoOrcamento servicoOrcamento;
    private final ServicoDeEstoque servicoEstoque;
    
    @Autowired
    public SolicitarOrcamentoUC(ServicoOrcamento servicoOrcamento,ServicoDeEstoque servicoEstoque){
        this.servicoOrcamento = servicoOrcamento;
        this.servicoEstoque = servicoEstoque;
    }

    public OrcamentoDTO run(List<ItemPedidoDTO> itens){
        PedidoModel pedido = new PedidoModel(0); // cria PedidoModel
        for(ItemPedidoDTO item:itens){ //transforma ItemPedidoDTO -> ItemPedidoModel
            ProdutoModel produto = servicoEstoque.produtoPorCodigo(item.getIdProduto()); //recupera o produto usando seu id
            ItemPedidoModel itemPedido = new ItemPedidoModel(produto, item.getQtdade()); //cria pedido usando id e objeto recem recuperado
            pedido.addItem(itemPedido); // adiciona ItemPedidoModel em PedidoModel
        }
        OrcamentoModel orcamento = servicoOrcamento.criaOrcamento(pedido); // cria orcamentoModel
        return OrcamentoDTO.fromModel(orcamento); // devolve como OrcamentoDTO
    }
}