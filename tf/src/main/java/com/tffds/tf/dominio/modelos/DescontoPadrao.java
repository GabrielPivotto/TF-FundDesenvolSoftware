package com.tffds.tf.dominio.modelos;

import java.util.List;

public class DescontoPadrao implements Desconto{

    @Override
    public double calcula(List<ItemPedidoModel> pedidos) {
        double orcamentoTotal = 0;
        double descontado = 0;
        int quantidadeItems = 0;


        for (ItemPedidoModel item : pedidos) {

            if (item.getQuantidade()>3){descontado += item.getPreco() * 0.95;}
            else {descontado += item.getPreco();}
            orcamentoTotal += item.getPreco();
            quantidadeItems++;
        }
        if (quantidadeItems > 10) {descontado *= 0.9;}

        return orcamentoTotal - descontado;
    }

}
