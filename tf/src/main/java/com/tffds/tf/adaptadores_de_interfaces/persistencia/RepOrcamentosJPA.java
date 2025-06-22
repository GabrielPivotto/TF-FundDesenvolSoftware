package com.tffds.tf.adaptadores_de_interfaces.persistencia;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tffds.tf.adaptadores_de_interfaces.persistencia.obj_persistencia.Orcamento;
import com.tffds.tf.adaptadores_de_interfaces.persistencia.obj_persistencia.Produto;
import com.tffds.tf.dominio.interfaces_persistencia.InterfaceRepOrcamento;
import com.tffds.tf.dominio.interfaces_persistencia.InterfaceRepProdutos;
import com.tffds.tf.dominio.modelos.OrcamentoModel;

@Repository
public class RepOrcamentosJPA implements InterfaceRepOrcamento{
    private InterfaceRepOrcamentosJPA repOrc;
    private InterfaceRepProdutos repProd;

    @Autowired
    public RepOrcamentosJPA(InterfaceRepOrcamentosJPA repOrc, InterfaceRepProdutos repProd) {
        this.repOrc = repOrc;
        this.repProd = repProd;
    }


    @Override
    public List<OrcamentoModel> todos() {
        List<Orcamento> orc = repOrc.findAll();
        if(orc.size() == 0) {
            return new LinkedList<OrcamentoModel>();
        } else {
            return orc.stream().map(orc -> Orcamento.toModel(orc)).toList();
        }
    }

    @Override
    public OrcamentoModel cadastra(OrcamentoModel orcamento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cadastra'");
    }

    @Override
    public OrcamentoModel recuperaPorId(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'recuperaPorId'");
    }
    
}
