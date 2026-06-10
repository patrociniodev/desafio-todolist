package br.com.isaacpatrocinio.desafiotodolist.services;

import br.com.isaacpatrocinio.desafiotodolist.domain.Todo;
import br.com.isaacpatrocinio.desafiotodolist.repositories.TodoRepository;
import br.com.isaacpatrocinio.desafiotodolist.services.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Transactional
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
    public Todo listById(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id doesn't exist"));
    }

    @Transactional
    public Todo update(Long id, Todo todo) {
        Todo existentTodo = listById(id);
        existentTodo.setName(todo.getName());
        existentTodo.setDescription(todo.getDescription());
        existentTodo.setDone(todo.isDone());
        existentTodo.setPriority(todo.getPriority());

        return todoRepository.save(existentTodo);
    }

    @Transactional
    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);
        return listAll();
    }
}
