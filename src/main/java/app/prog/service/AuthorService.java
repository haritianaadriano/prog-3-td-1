package app.prog.service;

import app.prog.model.AuthorEntity;
import app.prog.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {
    private AuthorRepository repository;

    public List<AuthorEntity> getAllAuthor(){
        return repository.findAll();
    }

    public List<AuthorEntity> createAuthor(List<>)
}
