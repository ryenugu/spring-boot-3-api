package org.frolicbits.service;

import org.frolicbits.controller.models.Post;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Flux;

public interface JsonService {
    @GetExchange("/posts")
    Flux<Post> fetchPosts();

}
