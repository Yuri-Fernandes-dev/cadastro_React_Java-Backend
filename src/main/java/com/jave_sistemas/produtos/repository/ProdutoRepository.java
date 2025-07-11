package com.jave_sistemas.produtos.repository;

import com.jave_sistemas.produtos.model.ProdutoModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModelo, Long> {
}
