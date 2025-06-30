package org.portafolio.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoRequest {

    @NotBlank(message = "El texto no puede estar vacío")
    private String text;
    private Boolean completed = false;
}
