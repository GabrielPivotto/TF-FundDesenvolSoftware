package com.tffds.tf.adaptadores_de_interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tffds.tf.aplicacao.casos_de_uso.CatalogoProdutosUC;
import com.tffds.tf.aplicacao.casos_de_uso.ChegadaDeProdutosUC;
import com.tffds.tf.aplicacao.casos_de_uso.SolicitarOrcamentoUC;
import com.tffds.tf.aplicacao.dtos.ItemPedidoDTO;
import com.tffds.tf.aplicacao.dtos.ProdutoDTO;

import java.util.List;


@RestController
public class Controller {
    private CatalogoProdutosUC catalogo;
    private ChegadaDeProdutosUC chegadaDeProdutos;
    private SolicitarOrcamentoUC solicitarOrcamento;

    @Autowired
    public Controller(CatalogoProdutosUC catalogo) {

        this.catalogo = catalogo;
        //this.chegadaDeProdutos = chegadaDeProdutos;
        //this.solicitarOrcamento = solicitarOrcamento;
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

    //@PostMapping("novoOrcamento")
    //@CrossOrigin(origins = "*")
    //public boolean novoOrcamento(@RequestBody List<ItemPedidoDTO> itens){
    //    return true;
    //}
//
    //@GetMapping("efetivaOrcamento/{id}")
    //@CrossOrigin(origins = "*")
    //public boolean efetivaOrcamento(@PathVariable(value="id") long idOrcamento){
    //    return true;
    //}
}