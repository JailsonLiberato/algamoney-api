package com.algaworks.algamoneyapi.repository;

import com.algaworks.algamoneyapi.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
