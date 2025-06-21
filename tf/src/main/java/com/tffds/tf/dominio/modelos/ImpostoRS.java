package com.tffds.tf.dominio.modelos;

import java.util.List;

public class ImpostoRS implements Imposto{

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
        if (precoTotal < 100){return impostoGeral;}
        impostoGeral = (precoTotal - 100) * 0.1;
        return impostoGeral;
    }

}
