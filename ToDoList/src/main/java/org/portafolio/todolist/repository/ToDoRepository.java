package org.portafolio.todolist.repository;

import org.portafolio.todolist.model.entities.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
