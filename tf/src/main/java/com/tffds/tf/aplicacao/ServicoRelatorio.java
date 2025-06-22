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
            case "xml": {
                relatorio = new RelatorioXML();
                break;
            }

            return relatorio.gerarRelatorio();
        }
    }

    //public String gerarRelatorioHtml(LocalDateTime startDate, LocalDateTime endDate) {
    //    List<Venda> vendas = vendaRepository.findVendasBetweenDates(startDate, endDate);
    //    
    //    StringBuilder relatorioHtml = new StringBuilder();
    //    relatorioHtml.append("<html><body>");
    //    relatorioHtml.append("<h1>Relatório de Vendas</h1>");
    //    relatorioHtml.append("<table border='1'><tr><th>ID</th><th>Data</th><th>Cliente</th><th>Valor</th></tr>");
    //    
    //    for (Venda venda : vendas) {
    //        relatorioHtml.append(String.format("<tr><td>%d</td><td>%s</td><td>%s</td><td>%s</td></tr>", 
    //            venda.getId(), 
    //            venda.getData(), 
    //            venda.getCliente(), 
    //            venda.getValor()));
    //    }
    //    
    //    relatorioHtml.append("</table></body></html>");
    //    
    //    return relatorioHtml.toString();
    //}
//
    //public String gerarRelatorioXml(LocalDate startDate, LocalDate endDate) throws JAXBException {
    //    List<Venda> vendas = vendaRepository.findVendasBetweenDates(startDate, endDate);
//
    //    // Criando um objeto que contém as vendas para ser transformado em XML
    //    VendasWrapper wrapper = new VendasWrapper(vendas);
    //    
    //    // Convertendo para XML usando JAXB
    //    StringWriter writer = new StringWriter();
    //    JAXBContext context = JAXBContext.newInstance(VendasWrapper.class);
    //    Marshaller marshaller = context.createMarshaller();
    //    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    //    marshaller.marshal(wrapper, writer);
    //    
    //    return writer.toString();
    //}
}