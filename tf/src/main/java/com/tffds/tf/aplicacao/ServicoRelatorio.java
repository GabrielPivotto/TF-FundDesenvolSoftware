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

    @Autowired
    public ServicoRelatorio(InterfaceRepOrcamento repOrc) {
        this.repOrc = repOrc;
    }

    public String gerarRelatorioTexto() {
        List<OrcamentoModel> orc = repOrc.todos();
        List<OrcamentoDTO> vendas = new LinkedList<>();

        // pega os OrcamentoModel efetivado e transforma em OrcamentoDTO
        for(OrcamentoModel oM : orc) {
            if (oM.isEfetivado()) {vendas.add(OrcamentoDTO.fromModel(oM));} 
        }

        Map<ProdutoDTO, Integer> valorVendas = new HashMap<ProdutoDTO, Integer>();

        // coloca os ProdutoDTO dentro do HashMap (ou incrementando no valor)
        for(OrcamentoDTO orcEfetivado : vendas) {
            List<ItemPedidoDTO> itens = orcEfetivado.getItens();

            // loop para checar cada ProdutoDTO dentro de ItemPedidoDTO
            for(ItemPedidoDTO pedido : itens) {
                if(valorVendas.containsKey(pedido.getProduto())) {
                    valorVendas.put(pedido.getProduto(), valorVendas.get(pedido.getProduto()) + pedido.getQtdade());
                }
                else {valorVendas.put(pedido.getProduto(), pedido.getQtdade());}
            }
        }
        
        //gerando texto para o relatorio
        StringBuilder relatorioTexto = new StringBuilder();
        relatorioTexto.append("Relatorio de Vendas:\n");
        
        for (ProdutoDTO chave : valorVendas.keySet()) {
            int qtd = valorVendas.get(chave); 

            relatorioTexto.append(String.format("Nome do Produto: %s \n ID: %d \n Quantidade total vendida: %d \n Lucro (calculo unitario): %.2f\n\n", 
                chave.getDescricao(), 
                chave.getId(), 
                qtd, 
                chave.getPrecoUnitario()*qtd));
        }
        
        return relatorioTexto.toString();
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