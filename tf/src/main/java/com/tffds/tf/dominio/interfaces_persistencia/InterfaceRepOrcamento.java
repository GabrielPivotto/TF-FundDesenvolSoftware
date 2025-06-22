package com.tffds.tf.dominio.interfaces_persistencia;

import java.util.List;

import com.tffds.tf.dominio.modelos.OrcamentoModel;

public interface InterfaceRepOrcamento {
    List<OrcamentoModel> todos();
    void cadastra(OrcamentoModel orcamento);
    OrcamentoModel recuperaPorId(long id);
    void marcaComoEfetivado(long id);
}
