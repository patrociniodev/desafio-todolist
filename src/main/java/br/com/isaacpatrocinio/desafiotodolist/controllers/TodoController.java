package br.com.isaacpatrocinio.desafiotodolist.controllers;

import br.com.isaacpatrocinio.desafiotodolist.domain.Todo;
import br.com.isaacpatrocinio.desafiotodolist.services.TodoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<List<Todo>> create(@RequestBody @Valid Todo obj, HttpServletRequest request) {
        List<Todo> list = todoService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path(request.getContextPath())
                .buildAndExpand()
                .toUri();
        return ResponseEntity.created(uri).body(list);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<List<Todo>> update(@RequestBody Todo obj) {
        List<Todo> list = todoService.update(obj);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<List<Todo>> delete(@PathVariable Long id) {
        List<Todo> list = todoService.delete(id);
        return ResponseEntity.ok().body(list);
    }
}
