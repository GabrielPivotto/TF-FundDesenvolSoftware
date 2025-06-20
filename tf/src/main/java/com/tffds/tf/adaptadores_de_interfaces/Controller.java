package com.tffds.tf.adaptadores_de_interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tffds.tf.aplicacao.casos_de_uso.CatalogoProdutosUC;
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

    @Autowired
    public Controller(CatalogoProdutosUC catalogo,
                      QuantidadeDisponivelProdutoUC qtdProd,
                      QuantidadeProdutosEspecificoUC qtdProdEsp) {

        this.catalogo = catalogo;
        this.qtdProd = qtdProd;
        this.qtdProdEsp = qtdProdEsp;
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
}