package com.tffds.tf.adaptadores_de_interfaces.persistencia;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.tffds.tf.adaptadores_de_interfaces.persistencia.obj_persistencia.ItemDeEstoque;

public interface InterfaceRepItemDeEstoqueJPA extends ListCrudRepository<ItemDeEstoque, Long>{

    Optional<ItemDeEstoque> findByProdutoId(Long id);
    
}
