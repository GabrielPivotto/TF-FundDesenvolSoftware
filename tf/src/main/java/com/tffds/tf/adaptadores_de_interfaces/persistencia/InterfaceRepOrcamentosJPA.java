package com.tffds.tf.adaptadores_de_interfaces.persistencia;

import org.springframework.data.repository.ListCrudRepository;

import com.tffds.tf.adaptadores_de_interfaces.persistencia.obj_persistencia.Orcamento;

public interface InterfaceRepOrcamentosJPA extends ListCrudRepository<Orcamento, Long>{
    
}