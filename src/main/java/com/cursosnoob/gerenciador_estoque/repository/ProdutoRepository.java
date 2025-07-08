package com.cursosnoob.gerenciador_estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cursosnoob.gerenciador_estoque.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}