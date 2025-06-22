package com.tffds.tf.dominio.modelos;

import java.util.List;

public interface Desconto {
    double calcula(List<ItemPedidoModel> pedidos);
}
