package com.tffds.tf.dominio.modelos;


import java.util.List;

public interface Imposto {
    double impostoGeral();
    double calcula(List<ItemPedidoModel> pedidos);
}
