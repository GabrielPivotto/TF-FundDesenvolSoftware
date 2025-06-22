package com.tffds.tf.adaptadores_de_interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.tffds.tf.aplicacao.casos_de_uso.OrcamentosCadastroUC;
import com.tffds.tf.aplicacao.casos_de_uso.OrcamentosEfetivadosUC;
import com.tffds.tf.aplicacao.casos_de_uso.QuantidadeDisponivelProdutoUC;
import com.tffds.tf.aplicacao.casos_de_uso.QuantidadeProdutosEspecificoUC;
import com.tffds.tf.aplicacao.casos_de_uso.RelatorioUC;
import com.tffds.tf.aplicacao.dtos.ItemDeEstoqueDTO;
import com.tffds.tf.aplicacao.dtos.ItemPedidoDTO;
import com.tffds.tf.aplicacao.dtos.OrcamentoDTO;
import com.tffds.tf.aplicacao.dtos.PedidoDTO;
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
    private OrcamentoEfetuaUC OrcamentoEfetiva;
    private OrcamentoEntreDatasUC OrcEntreDatas;
    private ServicoOrcamento orc;
    private OrcamentosEfetivadosUC efetivados;
    private RelatorioUC relatorio;
    private OrcamentosCadastroUC cadastro;
    private OrcamentoPaisEstadoUC OrcPaisEstado;

    @Autowired
    public Controller(CatalogoProdutosUC catalogo,
                      QuantidadeDisponivelProdutoUC qtdProd,
                      QuantidadeProdutosEspecificoUC qtdProdEsp,
                      EntradaEmEstoqueUC entradaEmEstoque,
                      ServicoOrcamento orc,
                      OrcamentoEfetuaUC OrcamentoEfetiva,
                      OrcamentoEntreDatasUC OrcEntreDatas,
                      OrcamentosEfetivadosUC efetivados,
                      RelatorioUC relatorio,
                      OrcamentosCadastroUC cadastro,
                      OrcamentoPaisEstadoUC OrcPaisEstado) {

        this.catalogo = catalogo;
        this.qtdProd = qtdProd;
        this.qtdProdEsp = qtdProdEsp;
        this.entradaEmEstoque = entradaEmEstoque;
        this.orc = orc;
        this.OrcamentoEfetiva = OrcamentoEfetiva;
        this.OrcEntreDatas = OrcEntreDatas;
        this.efetivados = efetivados;
        this.relatorio = relatorio;
        this.cadastro = cadastro;
        this.OrcPaisEstado = OrcPaisEstado;
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
    public OrcamentoDTO cadastrar(@RequestBody PedidoDTO ped){
        //orc.cadastraOrc(OrcamentoDTO.toModel(o));
        cadastro.run(ped);
    }

    @GetMapping("efetivaOrcamento/id/{idOrcamento}")
    @CrossOrigin(origins = "*")
    public boolean EfetivaOrcamento(@PathVariable long idOrcamento) {
        return OrcamentoEfetiva.run(idOrcamento);
    }

    @GetMapping("orcamentosEntre/from/{from}/to/{to}")
    @CrossOrigin(origins = "*")
    public List<OrcamentoDTO> orcamentosEntre(@PathVariable String from,
                                    @PathVariable String to) {
        return OrcEntreDatas.run(from, to);
    } 


    @GetMapping("orcamentosDe/pais/{pais}/estado/{estado}")
    @CrossOrigin(origins = "*")
    public List<OrcamentoDTO> orcamentosDe(@PathVariable String pais,
                                    @PathVariable String estado) {
        return OrcPaisEstado.run(pais, estado);
    } 

    @GetMapping("orcamentosEfetivados/{Efetiva}")
    @CrossOrigin(origins = "*")
    public List<OrcamentoDTO> orcamentosEfetivados(@PathVariable boolean efetiva) {
        return efetivados.run(efetiva);
    }

    @GetMapping("relatorioDeVendas")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> geraRelatorio() {
        return ResponseEntity.ok()
                             .header("Content-Type", "text/plain")
                             .body(relatorio.run());
    }
}