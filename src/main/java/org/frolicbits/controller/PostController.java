package org.frolicbits.controller;

import lombok.RequiredArgsConstructor;
import org.frolicbits.controller.models.Post;
import org.frolicbits.service.JsonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/v1/api")
@RequiredArgsConstructor
public class PostController {
    private final JsonService jsonService;

    @GetMapping("/posts")
    public Flux<Post> generateSample() {

        return jsonService.fetchPosts().filter(post -> post.id() < 5);
    }
}
