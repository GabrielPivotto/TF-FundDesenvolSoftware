package com.tffds.tf.aplicacao;

import java.util.Map;

import com.tffds.tf.aplicacao.dtos.ProdutoDTO;

public class RelatorioHTML implements InterfaceRelatorio{

    public RelatorioHTML() {}

    @Override
    public String gerarRelatorio(Map<ProdutoDTO, Integer> valores) {
        StringBuilder relatorioHtml = new StringBuilder();
        relatorioHtml.append("<html><body>");
        relatorioHtml.append("<h1>Relatório de Vendas</h1>");
        relatorioHtml.append("<table border='1'><tr><th>ID</th><th>Data</th><th>Cliente</th><th>Valor</th></tr>");
                
        for(ProdutoDTO chave : valores.keySet()) {
            int qtd = valores.get(chave); 

            relatorioHtml.append(String.format("<tr><td>Nome do Produto: %s</td><td>ID: %d</td><td>Quantidade total vendida: %d</td><td>Lucro (calculo unitario): %.2f</td></tr>", 
                chave.getDescricao(), 
                chave.getId(), 
                qtd, 
                chave.getPrecoUnitario()*qtd));
        }
                
        relatorioHtml.append("</table></body></html>");
                
        return relatorioHtml.toString();
    }
    
}
