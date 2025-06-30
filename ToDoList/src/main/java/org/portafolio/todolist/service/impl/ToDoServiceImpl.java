package org.portafolio.todolist.service.impl;

import lombok.RequiredArgsConstructor;
import org.portafolio.todolist.dto.ToDoRequest;
import org.portafolio.todolist.dto.ToDoResponse;
import org.portafolio.todolist.exception.ResourceNotFoundException;
import org.portafolio.todolist.model.entities.ToDo;
import org.portafolio.todolist.repository.ToDoRepository;
import org.portafolio.todolist.service.ToDoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService {
    private final ToDoRepository repository;

    @Override
    public List<ToDoResponse> getAll() {
        return repository.findAll().stream()
                .map(todo -> new ToDoResponse(todo.getId(), todo.getText(), todo.getCompleted()))
                .toList();
    }

    @Override
    public ToDoResponse create(ToDoRequest request) {
        ToDo saved = repository.save(ToDo.builder()
                .text(request.getText())
                .completed(request.getCompleted())
                .build());
        return new ToDoResponse(saved.getId(), saved.getText(), saved.getCompleted());
    }

    @Override
    public ToDoResponse update(Long id, ToDoRequest request) {
        ToDo existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada"));

        existing.setText(request.getText());
        existing.setCompleted(request.getCompleted());
        ToDo updated = repository.save(existing);
        return new ToDoResponse(updated.getId(), updated.getText(), updated.getCompleted());
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("No se encontró tarea con ID: " + id);
        }
        repository.deleteById(id);
    }
}
