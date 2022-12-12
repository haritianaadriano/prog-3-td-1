package app.prog.controller;

import app.prog.controller.mapper.AuthorRestMapper;
import app.prog.controller.response.AuthorResponse;
import app.prog.controller.response.CreateAuthorResponse;
import app.prog.controller.response.UpdateAuthorResponse;
import app.prog.controller.response.UpdateBookResponse;
import app.prog.model.AuthorEntity;
import app.prog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/authors")
    public List<AuthorResponse> createAuthor(@RequestBody List<CreateAuthorResponse> newAuthors){
        List<AuthorEntity> thisAuthor = newAuthors.stream()
                .map(mapper::toDomain).toList();
        return service.createAuthor(thisAuthor).stream()
                .map(mapper::toRest).toList();
    }

    @PutMapping("/authors")
    public List<AuthorResponse> updateAuthor(@RequestBody List<UpdateAuthorResponse> authorUpdated){
        List<AuthorEntity> thisAuthor = authorUpdated.stream()
                .map(mapper::toDomain).toList();
        return service.updateAuthor(thisAuthor).stream()
                .map(mapper::toRest).toList();
    }

    @DeleteMapping("/authors/{author_id}")
    public ResponseEntity<AuthorEntity> deleteAuthor(@PathVariable(name = "author_id")int authorId){
        return service.deleteAuthor(authorId);
    }
}
