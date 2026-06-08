package br.com.isaacpatrocinio.desafiotodolist.controllers;

import br.com.isaacpatrocinio.desafiotodolist.domain.Todo;
import br.com.isaacpatrocinio.desafiotodolist.services.TodoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Todo>> findAll() {
        return ResponseEntity.ok().body(todoService.listAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Todo> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(todoService.findById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Todo> create(@RequestBody Todo obj, HttpServletRequest request) {
        todoService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path(request.getContextPath())
                .buildAndExpand()
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Todo> update(@RequestBody Todo obj) {
        todoService.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
