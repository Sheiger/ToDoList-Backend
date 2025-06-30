package org.portafolio.todolist.service;

import org.portafolio.todolist.dto.ToDoRequest;
import org.portafolio.todolist.dto.ToDoResponse;

import java.util.List;

public interface ToDoService {
    List<ToDoResponse> getAll();
    ToDoResponse create(ToDoRequest request);
    ToDoResponse update(Long id, ToDoRequest request);
    void delete(Long id);
}
