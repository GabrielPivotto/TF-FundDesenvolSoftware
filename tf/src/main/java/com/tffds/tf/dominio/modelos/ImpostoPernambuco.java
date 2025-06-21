package com.tffds.tf.dominio.modelos;

import java.util.List;

public class ImpostoPernambuco implements Imposto{

    double impostoGeral;

    @Override
    public double impostoGeral() {
        return impostoGeral;
    }

    @Override
    public double calcula(List<ItemPedidoModel> pedidos) {
        impostoGeral = 0;
        for (ItemPedidoModel item : pedidos) {
            String pedidoNome = item.getProduto().getDescricao();
            if(pedidoNome.charAt(pedidoNome.length()-1)== '*'){
                impostoGeral += item.getPreco()*0.05;
            }
            else {impostoGeral += item.getPreco()*0.15;}
        }
        return impostoGeral;
    }

}
