package com.tffds.tf.dominio.modelos;

import java.util.List;

public class ImpostoBrasil implements Imposto{

    double impostoGeral;

    @Override
    public double impostoGeral() {
        return impostoGeral;
    }

    @Override
    public double calcula(List<ItemPedidoModel> pedidos) {
        impostoGeral = 0;
        for (ItemPedidoModel item : pedidos) {
            impostoGeral += item.getPreco() * 0.15;
        }
        return impostoGeral;
    }

}
