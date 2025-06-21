package com.tffds.tf.dominio.modelos;

import java.util.List;

public class ImpostoSP implements Imposto{

    double impostoGeral;

    @Override
    public double impostoGeral() {
        return impostoGeral;
    }

    @Override
    public double calcula(List<ItemPedidoModel> pedidos) {
        impostoGeral = 0;
        double precoTotal = 0;
        for (ItemPedidoModel item : pedidos) {
            precoTotal += item.getPreco();
        }
        impostoGeral = precoTotal * 0.12;
        return impostoGeral;
    }

}
