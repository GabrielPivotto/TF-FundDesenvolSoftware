package com.tffds.tf.adaptadores_de_interfaces.persistencia;

import org.springframework.data.repository.ListCrudRepository;

public interface InterfaceRepProdutoJPA extends ListCrudRepository<Produto, Long>{
    
}
