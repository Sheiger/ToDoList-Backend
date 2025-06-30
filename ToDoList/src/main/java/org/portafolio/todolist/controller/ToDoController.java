package org.portafolio.todolist.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.portafolio.todolist.dto.ToDoRequest;
import org.portafolio.todolist.dto.ToDoResponse;
import org.portafolio.todolist.service.ToDoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:5173")
public class ToDoController {

    private final ToDoService service;

    @GetMapping
    @Operation(summary = "Listar todas las tareas")
    public ResponseEntity<List<ToDoResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<ToDoResponse> create(@Valid @RequestBody ToDoRequest request) {
        return ResponseEntity.status(201).body(service.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoResponse> update(@PathVariable Long id, @Valid @RequestBody ToDoRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
