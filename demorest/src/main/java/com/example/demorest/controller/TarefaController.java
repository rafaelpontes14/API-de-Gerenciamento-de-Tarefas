package com.example.demorest.controller;

import com.example.demorest.model.Tarefa;
import com.example.demorest.repository.TarefaRepository;
import com.example.demorest.exception.ResourceNotFoundException;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    private final TarefaRepository repo;

    public TarefaController(TarefaRepository repo) {
        this.repo = repo;
    }

    // Criar tarefa
    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@Valid @RequestBody Tarefa tarefa) {
        Tarefa saved = repo.save(tarefa);
        return ResponseEntity.created(URI.create("/api/tarefas/" + saved.getId())).body(saved);
    }

    // Listar todas
    @GetMapping
    public List<Tarefa> listarTarefas() {
        return repo.findAll();
    }

    // Consultar por id
    @GetMapping("/{id}")
    public Tarefa obterPorId(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada com id " + id));
    }

    // Atualizar
    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(@PathVariable Long id, @Valid @RequestBody Tarefa dados) {
        return repo.findById(id).map(t -> {
            t.setNome(dados.getNome());
            t.setDataEntrega(dados.getDataEntrega());
            t.setResponsavel(dados.getResponsavel());
            return repo.save(t);
        }).orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada com id " + id));
    }

    // Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        return repo.findById(id).map(t -> {
            repo.delete(t);
            return ResponseEntity.noContent().<Void>build();
        }).orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada com id " + id));
    }
}
