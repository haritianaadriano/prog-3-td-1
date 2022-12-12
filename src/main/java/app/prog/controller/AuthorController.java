package app.prog.controller;

import app.prog.controller.mapper.AuthorRestMapper;
import app.prog.controller.response.AuthorResponse;
import app.prog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorController {
    private AuthorService service;
    private AuthorRestMapper mapper;

    @GetMapping("/authors")
    public List<AuthorResponse> getAuthors(){
        return service.getAllAuthor().stream()
                .map(mapper::toRest).toList();
    }
}