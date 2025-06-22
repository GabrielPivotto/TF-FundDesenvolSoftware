package com.tffds.tf.adaptadores_de_interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tffds.tf.adaptadores_de_interfaces.persistencia.obj_persistencia.Orcamento;
import com.tffds.tf.aplicacao.casos_de_uso.CatalogoProdutosUC;
import com.tffds.tf.aplicacao.casos_de_uso.EntradaEmEstoqueUC;
import com.tffds.tf.aplicacao.casos_de_uso.OrcamentoEfetuaUC;
import com.tffds.tf.aplicacao.casos_de_uso.OrcamentoEntreDatasUC;
import com.tffds.tf.aplicacao.casos_de_uso.OrcamentosEfetuadosUC;
import com.tffds.tf.aplicacao.casos_de_uso.QuantidadeDisponivelProdutoUC;
import com.tffds.tf.aplicacao.casos_de_uso.QuantidadeProdutosEspecificoUC;
import com.tffds.tf.aplicacao.dtos.ItemDeEstoqueDTO;
import com.tffds.tf.aplicacao.dtos.ItemPedidoDTO;
import com.tffds.tf.aplicacao.dtos.OrcamentoDTO;
import com.tffds.tf.aplicacao.dtos.ProdutoDTO;
import com.tffds.tf.dominio.modelos.OrcamentoModel;
import com.tffds.tf.dominio.servicos.ServicoOrcamento;

import java.util.ArrayList;
import java.util.List;


@RestController
public class Controller {
    private CatalogoProdutosUC catalogo;
    private QuantidadeDisponivelProdutoUC qtdProd;
    private QuantidadeProdutosEspecificoUC qtdProdEsp;
    private EntradaEmEstoqueUC entradaEmEstoque;
    private OrcamentoEfetuaUC OrcamentoEfetua;
    private OrcamentoEntreDatasUC OrcEntreDatas;
    private ServicoOrcamento orc;
    private OrcamentosEfetuadosUC efetuados;

    @Autowired
    public Controller(CatalogoProdutosUC catalogo,
                      QuantidadeDisponivelProdutoUC qtdProd,
                      QuantidadeProdutosEspecificoUC qtdProdEsp,
                      EntradaEmEstoqueUC entradaEmEstoque,
                      ServicoOrcamento orc,
                      OrcamentoEfetuaUC OrcamentoEfetua,
                      OrcamentoEntreDatasUC OrcEntreDatas,
                      OrcamentosEfetuadosUC efetuados) {

        this.catalogo = catalogo;
        this.qtdProd = qtdProd;
        this.qtdProdEsp = qtdProdEsp;
        this.entradaEmEstoque = entradaEmEstoque;
        this.orc = orc;
        this.OrcamentoEfetua = OrcamentoEfetua;
        this.OrcEntreDatas = OrcEntreDatas;
        this.efetuados = efetuados;
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String welcomeMessage(){
        return("Bem vindo as lojas ACME");
    }

    @GetMapping("catalogo")
    @CrossOrigin(origins = "*")
    public List<ProdutoDTO> produtosDisponiveis(){
        return catalogo.run();
    }    

    @GetMapping("quantidadeDisponivelProduto")
    @CrossOrigin(origins = "*")
    public List<ItemDeEstoqueDTO> qtdDisponivelProd(){
        return qtdProd.run();
    }

    @PostMapping("procuraItensEstoquePorId")
    @CrossOrigin(origins = "*")
    public List<ItemDeEstoqueDTO> qtdDisponivelProdEsp(@RequestBody List<ProdutoDTO> itens){
        return qtdProdEsp.run(itens);
    }

    @GetMapping("entradaEmEstoque/id/{idProduto}/qtd/{qtd}")
    @CrossOrigin(origins = "*")
    public boolean entradaEmEstoque(@PathVariable long idProduto,
                                  @PathVariable int qtd) {
        return entradaEmEstoque.run(idProduto, qtd);
    }

    @GetMapping("todos")
    @CrossOrigin(origins = "*")
    public List<OrcamentoDTO> todos() {
        List<OrcamentoModel> list = orc.todos();
        List<OrcamentoDTO> list2 = new ArrayList<>(list.size());
        for(OrcamentoModel orcM : list) {
            list2.add(OrcamentoDTO.fromModel(orcM));
        }
        
        return list2;
    }

    @GetMapping("procurarPorId/id/{idProduto}")
    @CrossOrigin(origins = "*")
    public OrcamentoDTO procurarPorId(@PathVariable long idProduto) {
        return OrcamentoDTO.fromModel(orc.pegaPorId(idProduto));
    }

    @PostMapping("cadastraOrcamento")
    @CrossOrigin(origins = "*")
    public void cadastrar(@RequestBody OrcamentoDTO o){
        orc.cadastraOrc(OrcamentoDTO.toModel(o));
    }

    @GetMapping("efetuaOrcamento/id/{idOrcamento}")
    @CrossOrigin(origins = "*")
    public boolean efetuaOrcamento(@PathVariable long idOrcamento) {
        return OrcamentoEfetua.run(idOrcamento);
    }

    @GetMapping("orcamentosEntre/from/{from}/to/{to}")
    @CrossOrigin(origins = "*")
    public List<OrcamentoDTO> orcamentosEntre(@PathVariable String from,
                                    @PathVariable String to) {
        return OrcEntreDatas.run(from, to);
    }

    @GetMapping("orcamentosEfetuados/{efetuados}")
    @CrossOrigin(origins = "*")
    public List<OrcamentoDTO> orcamentosEfetuados(@PathVariable boolean efetua) {
        return efetuados.run(efetua);
    }
}