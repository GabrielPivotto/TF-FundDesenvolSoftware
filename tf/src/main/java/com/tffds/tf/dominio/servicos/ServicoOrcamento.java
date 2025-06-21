package com.tffds.tf.dominio.servicos;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tffds.tf.dominio.interfaces_persistencia.InterfaceOrcamento;
import com.tffds.tf.dominio.interfaces_persistencia.InterfaceRepOrcamento;
import com.tffds.tf.dominio.modelos.ProdutoModel;
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
    
    @Autowired
    public ServicoItemDeEstoque(InterfaceRepOrcamento orcamento) {
        this.orcamento = orcamento;
    }

    public OrcamentoModel buildOrcamento(PedidoModel pedido, String pais, String estado){

        Imposto fed = null;
        Imposto est = null;

        switch (pais.toLowerCase()) {
            case "brasil":
                fed = new ImpostoBrasil();
                break;
        
            default:
                return null;
        }


        switch (estado.toLowerCase()) {
            case "rio grande do sul":
                est = new ImpostoRS();
                break;

            case "são paulo":
                est = new ImpostoSP();
                break;

            case "pernambuco":
                est = new ImpostoPernambuco();
                break;
                
            default:
                return null;
        }

        return new OrcamentoModel(pedido.getId(), pedido.getItens(), pais, estado, fed, est, new DescontoPadrao());
    }

}
