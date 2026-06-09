package br.com.isaacpatrocinio.desafiotodolist;

import br.com.isaacpatrocinio.desafiotodolist.domain.Todo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = DesafioTodolistApplication.class //
)
public class DesafioTodolistApplicationTests {

    private WebTestClient webTestClient;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        this.webTestClient = WebTestClient.bindToServer()
                .baseUrl("http://localhost:" + port)
                .build();
    }

    @Test
    void testCreateTodoSuccess() {
        var todo = new Todo("Tarefa 6", "Lembretes pra mais tarde", false, 1);

        webTestClient
                .post()
                .uri("/todos")
                .bodyValue(todo)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$[0].name").isEqualTo(todo.getName())
                .jsonPath("$[0].description").isEqualTo(todo.getDescription())
                .jsonPath("$[0].done").isEqualTo(todo.isDone())
                .jsonPath("$[0].priority").isEqualTo(todo.getPriority());
    }

    @Test
    void testCreateTodoError() {
        webTestClient
                .post()
                .uri("/todos")
                .bodyValue(new Todo("", "", false, 0))
                .exchange()
                .expectStatus().isBadRequest();
    }
}