package com.tffds.tf.dominio.modelos;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class OrcamentoModel {
    private long id;
    private List<ItemPedidoModel> itens;
    private double custoItens;
    private double impFederal;
    private double impEstadual;
    private double desconto;
    private LocalDate dataCriacao;
    private double custoConsumidor;
    private boolean efetivado;  // sempre checar se é efetivado pois se chegar de
                                // um repositorio, deve ser declarado como final

    public OrcamentoModel(long id, List<ItemPedidoModel> its, Imposto federal, Imposto estadual, Desconto desconto) {
        this.id = id;
        this.itens = its;
        this.efetivado = false;
        dataCriacao = LocalDate.now();
        custoItens = 0;

        impFederal = federal.calcula(itens);
        impEstadual = estadual.calcula(itens);

        this.desconto = desconto.calcula(itens);

        for (ItemPedidoModel item : itens) {
            custoItens += item.getPreco();
        }
        custoConsumidor = custoItens + impEstadual + impFederal - this.desconto;


        


    }

    // constructor que transfere de outros tipos para model
    public OrcamentoModel(long id, String pais, String estado, List<ItemPedidoModel> itens, boolean efetivado) {
        this.id = id;
        this.itens = itens;
        this.efetivado = efetivado;
        dataCriacao = LocalDate.now();
    }

    public void addItensPedido(PedidoModel pedido){
        for(ItemPedidoModel itemPedido:pedido.getItens()){
            itens.add(itemPedido);
}
    }

    public List<ItemPedidoModel> getItens(){return itens;}

    public long getId() {return id;}
    public void setId(long id){this.id = id;}

    public double getCustoItens() {return custoItens;}
    public void setCustoItens(double custoItens){this.custoItens = custoItens;}

    /*retirar setters de pais e estado se a estrategia de deixar as 
      instancias de orcamento efetivados como final nao funcionar  */
    //public double getImposto() {return imposto;}

    //public void setImposto(double imposto) {this.imposto = imposto;}

    //public double getDesconto() {return desconto;}

    //public void setDesconto(double desconto) {this.desconto = desconto;}

    //public double getCustoConsumidor() {return custoConsumidor + imposto * desconto;}

    //public void setCustoConsumidor(double custoConsumidor) {this.custoConsumidor = custoConsumidor;}

    public boolean isEfetivado() {return efetivado;}

    public void efetiva() {efetivado = true;}

    public String getDataCriacao() {return dataCriacao.toString();}
}

