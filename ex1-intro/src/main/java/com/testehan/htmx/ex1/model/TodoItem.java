package com.testehan.htmx.ex1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class TodoItem {

    private UUID id;
    private String task;
    private boolean completed;

    public void toggle(){
        this.completed = !this.completed;
    }
}
