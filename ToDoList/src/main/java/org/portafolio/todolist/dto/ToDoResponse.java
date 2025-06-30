package org.portafolio.todolist.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoResponse {
    private Long id;
    private String text;
    private Boolean completed;
}
