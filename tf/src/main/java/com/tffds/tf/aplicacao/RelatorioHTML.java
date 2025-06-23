package com.tffds.tf.aplicacao;

import java.util.Map;

import com.tffds.tf.aplicacao.dtos.ProdutoDTO;

public class RelatorioHTML implements InterfaceRelatorio{

    public RelatorioHTML() {}

    @Override
    public String gerarRelatorio(Map<ProdutoDTO, Integer> valores) {
        StringBuilder relatorioHtml = new StringBuilder();
        relatorioHtml.append("<html><body>");
        relatorioHtml.append("<h1>Relatorio de Vendas</h1>");
        relatorioHtml.append("<table border='1'><tr><th>Nome do Produto</th><th>ID</th><th>Quantidade total vendida</th><th>Lucro (calculo unitario)</th></tr>");
                
        for(ProdutoDTO chave : valores.keySet()) {
            int qtd = valores.get(chave); 

            relatorioHtml.append(String.format("<tr><td>%s</td><td>%d</td><td>%d</td><td>%.2f</td></tr>", 
                chave.getDescricao(), 
                chave.getId(), 
                qtd, 
                chave.getPrecoUnitario()*qtd));
        }
                
        relatorioHtml.append("</table></body></html>");
                
        return relatorioHtml.toString();
    }
}