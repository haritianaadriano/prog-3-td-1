package app.prog.service;

import app.prog.model.AuthorEntity;
import app.prog.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorService {
    private AuthorRepository repository;

    public List<AuthorEntity> getAllAuthor(){
        return repository.findAll();
    }

    public List<AuthorEntity> createAuthor(List<AuthorEntity> toCreate){
        return repository.saveAll(toCreate);
    }

    public List<AuthorEntity> updateAuthor(List<AuthorEntity> toUpdate){
        return repository.saveAll(toUpdate);
    }

    public ResponseEntity<AuthorEntity> deleteAuthor(int authorId) {
        Optional<AuthorEntity> optional = repository.findById(String.valueOf(authorId));
        if (optional.isPresent()) {
            repository.delete(optional.get());
            AuthorEntity book = optional.get();
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new AuthorEntity(), HttpStatus.NOT_FOUND);
        }
    }
}
