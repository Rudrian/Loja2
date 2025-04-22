package com.Loja.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Loja.Entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
