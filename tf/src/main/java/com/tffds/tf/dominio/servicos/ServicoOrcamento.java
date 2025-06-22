package com.tffds.tf.dominio.servicos;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tffds.tf.dominio.interfaces_persistencia.InterfaceRepItemDeEstoque;
import com.tffds.tf.dominio.interfaces_persistencia.InterfaceRepOrcamento;
import com.tffds.tf.dominio.modelos.ProdutoModel;
import com.tffds.tf.dominio.modelos.ItemPedidoModel;
import com.tffds.tf.dominio.modelos.ItemDeEstoqueModel;
import com.tffds.tf.dominio.modelos.DescontoPadrao;
import com.tffds.tf.dominio.modelos.OrcamentoModel;
import com.tffds.tf.dominio.modelos.PedidoModel;
import com.tffds.tf.dominio.modelos.Imposto;
import com.tffds.tf.dominio.modelos.ImpostoRS;
import com.tffds.tf.dominio.modelos.ImpostoSP;
import com.tffds.tf.dominio.modelos.ImpostoPernambuco;
import com.tffds.tf.dominio.modelos.ImpostoBrasil;

@Service
public class ServicoOrcamento{
    private InterfaceRepOrcamento orcamento;
    private InterfaceRepItemDeEstoque itemEstoque;
    
    @Autowired
    public ServicoOrcamento(InterfaceRepOrcamento orcamento, InterfaceRepItemDeEstoque itemEstoque) {
        this.orcamento = orcamento;
        this.itemEstoque = itemEstoque;
    }

    //REMOVER DEPOIS=(ou nao)========================
    public List<OrcamentoModel> todos() {               
        return orcamento.todos();
    }
    public OrcamentoModel pegaPorId(Long id) {
        return orcamento.recuperaPorId(id);
    }
    public void cadastraOrc(OrcamentoModel orcM) {
        orcamento.cadastra(orcM);
    }
    //==============================================

    public OrcamentoModel buildOrcamento(PedidoModel pedido, String pais, String estado){

        Imposto fed = null;
        Imposto est = null;

        switch (pais) {
            case "BR":
                fed = new ImpostoBrasil();
                break;
        
            default:
                return null;
        }


        switch (estado) {
            case "RS":
                est = new ImpostoRS();
                break;

            case "SP":
                est = new ImpostoSP();
                break;

            case "PE":
                est = new ImpostoPernambuco();
                break;

            default:
                return null;
        }

        OrcamentoModel orca = new OrcamentoModel(pedido.getId(), pedido.getItens(), pais, estado, fed, est, new DescontoPadrao());
        orcamento.cadastra(orca);
        return orca;
    }

    public List<OrcamentoModel>  orcamentos(){
        return orcamento.todos();
    }


    public boolean efetuaOrcamento(long id){
        OrcamentoModel orca = orcamento.recuperaPorId(id);
        if (orca == null) return false;
        if (orca.isEfetivado()) return false;

        for (ItemPedidoModel item : orca.getItens()) {
            ItemDeEstoqueModel aux = itemEstoque.pegaPorId(item.getProduto().getId());
            if (aux == null) return false;
            if (aux.getQuantidade() < item.getQuantidade()) {return false;}
        }
        for (ItemPedidoModel item : orca.getItens()) {
            ItemDeEstoqueModel aux = itemEstoque.pegaPorId(item.getProduto().getId());
            itemEstoque.baixaEmEstoque(aux, item.getQuantidade());
        }

        orcamento.marcaComoEfetivado(id);


        return true;
    }
}
