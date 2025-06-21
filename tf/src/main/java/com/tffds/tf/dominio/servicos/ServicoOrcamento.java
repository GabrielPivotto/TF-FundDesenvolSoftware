package com.tffds.tf.dominio.servicos;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tffds.tf.dominio.interfaces_persistencia.InterfaceRepItemDeEstoque;
import com.tffds.tf.dominio.modelos.ItemDeEstoqueModel;
import com.tffds.tf.dominio.modelos.ProdutoModel;

@Service
public class ServicoOrcamento{
    private InterfaceRepOrcamento orcamento;
    
    @Autowired
    public ServicoItemDeEstoque(InterfaceRepOrcamento orcamento) {
        this.orcamento = orcamento;
    }

}
