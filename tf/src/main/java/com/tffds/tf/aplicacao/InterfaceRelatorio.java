package com.tffds.tf.aplicacao;

import java.util.Map;

import com.tffds.tf.aplicacao.dtos.ProdutoDTO;

public interface InterfaceRelatorio {
    String gerarRelatorio(Map<ProdutoDTO, Integer> valores);
}
