package com.tffds.tf.dominio.modelos;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class OrcamentoModel {
    private long id;
    private List<ItemPedidoModel> itens;
    private double custoItens;
    private String pais;
    private String estado;

    /*talvez imposto e desconto devem ser aplicados ao OrcamentoModel usando servicos ao inves
       dele guardar eles pois isso pode causar problema de multiplos atores na classe?        */
    //private double imposto;   
    //private double desconto; 
    private LocalDate dataCriacao;
    private double custoConsumidor;
    private boolean efetivado;  // sempre checar se é efetivado pois se chegar de
                                // um repositorio, deve ser declarado como final

    public OrcamentoModel(long id, String pais, String estado) {
        this.id = id;
        this.itens = new LinkedList<>();
        this.efetivado = false;
        dataCriacao = LocalDate.now();
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
    public String getPais() {return pais;}
    public void setPais(String pais) {this.pais = pais;}

    public String getEstado() {return estado;}
    public void setEstado(String estado) {this.estado = estado;}

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

