package br.com.isaacpatrocinio.desafiotodolist.repositories;


import br.com.isaacpatrocinio.desafiotodolist.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository
extends JpaRepository<Todo, Long> {

}
