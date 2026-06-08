package br.com.isaacpatrocinio.desafiotodolist.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private boolean made;

    private Integer priority;

    public Todo() {
    }

    public Todo(String name, String description, Integer priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
    }

    public Todo(String name, String description, boolean made, Integer priority) {
        this.name = name;
        this.description = description;
        this.made = made;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isMade() {
        return made;
    }

    public void setMade(boolean made) {
        this.made = made;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        Todo todo = (Todo) o;
        return Objects.equals(id, todo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
