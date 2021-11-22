package com.claro.entity;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "todo")
public class Todo extends AbstractEntity {

    @NotEmpty(message = "A todo task bust be set.")
    @Size(min= 5, max = 150, message = "The minimum length should be between 3 and 150 characters")
    private String task;


    private LocalDate dateCreated;

    @NotNull(message = "Due date must be set")
    @FutureOrPresent(message = "Du data must be in the present or in the future")
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDate dueDate; // yyyy-mm-dd eg 2021-10-31

    private boolean completed;
    private boolean archive;
    private boolean remind;

    @ManyToOne
    @JoinColumn(name = "todo_user_id")
    private TodoUser todoOwner; // many todos can belong to one todoUser


}
