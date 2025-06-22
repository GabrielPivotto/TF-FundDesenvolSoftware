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

import com.tffds.tf.aplicacao.casos_de_uso.CatalogoProdutosUC;
import com.tffds.tf.aplicacao.casos_de_uso.EntradaEmEstoqueUC;
import com.tffds.tf.aplicacao.casos_de_uso.OrcamentoEfetuaUC;
import com.tffds.tf.aplicacao.casos_de_uso.OrcamentoEntreDatasUC;
import com.tffds.tf.aplicacao.casos_de_uso.QuantidadeDisponivelProdutoUC;
import com.tffds.tf.aplicacao.casos_de_uso.QuantidadeProdutosEspecificoUC;
import com.tffds.tf.aplicacao.dtos.ItemDeEstoqueDTO;
import com.tffds.tf.aplicacao.dtos.ItemPedidoDTO;
import com.tffds.tf.aplicacao.dtos.OrcamentoDTO;
import com.tffds.tf.aplicacao.dtos.ProdutoDTO;

import java.util.List;


@RestController
public class Controller {
    private CatalogoProdutosUC catalogo;
    private QuantidadeDisponivelProdutoUC qtdProd;
    private QuantidadeProdutosEspecificoUC qtdProdEsp;
    private EntradaEmEstoqueUC entradaEmEstoque;
    private OrcamentoEfetuaUC OrcamentoEfetua;
    private OrcamentoEntreDatasUC OrcEntreDatas;
    

    @Autowired
    public Controller(CatalogoProdutosUC catalogo,
                      QuantidadeDisponivelProdutoUC qtdProd,
                      QuantidadeProdutosEspecificoUC qtdProdEsp,
                      EntradaEmEstoqueUC entradaEmEstoque,
                      OrcamentoEfetuaUC OrcamentoEfetua,
                      OrcamentoEntreDatasUC OrcEntreDatas) {

        this.catalogo = catalogo;
        this.qtdProd = qtdProd;
        this.qtdProdEsp = qtdProdEsp;
        this.entradaEmEstoque = entradaEmEstoque;
        this.OrcamentoEfetua = OrcamentoEfetua;
        this.OrcEntreDatas = OrcEntreDatas;
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

    @GetMapping("efetuaOrcamento/id/{idOrcamento}")
    @CrossOrigin(origins = "*")
    public boolean efetuaOrcamento(@PathVariable long idOrcamento) {
        return OrcamentoEfetua.run(idOrcamento);
    }

    @GetMapping("OrcamentosEntre/from/{from}/to/{to}")
    @CrossOrigin(origins = "*")
    public List<OrcamentoDTO> efetuaOrcamento(@PathVariable String from,
                                            @PathVariable String to) {
        return OrcEntreDatas.run(from, to);
    }
}