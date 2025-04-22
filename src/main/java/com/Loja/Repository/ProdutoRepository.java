package com.Loja.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Loja.Entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
