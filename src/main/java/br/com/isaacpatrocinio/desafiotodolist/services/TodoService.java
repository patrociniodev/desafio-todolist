package br.com.isaacpatrocinio.desafiotodolist.services;

import br.com.isaacpatrocinio.desafiotodolist.domain.Todo;
import br.com.isaacpatrocinio.desafiotodolist.repositories.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo) {
        todoRepository.save(todo);
        return listAll();
    }

    @Transactional
    public List<Todo> listAll() {
        Sort sort = Sort.by("priority").descending().and(Sort.by("name").ascending());
        var list = todoRepository.findAll(sort);
        return list;
    }

    @Transactional
    public Todo findById(Long id) {
        return todoRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Todo> update(Todo todo) {
        todoRepository.save(todo);
        return listAll();
    }

    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);
        return listAll();
    }
}
