package com.example.demorest.repository;

import com.example.demorest.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    // métodos básicos CRUD já fornecidos pelo JpaRepository
}