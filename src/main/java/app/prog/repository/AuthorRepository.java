package app.prog.repository;

import app.prog.model.AuthorEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, String> {
    public AuthorEntity findByNameContainingIgnoreCase(String name);
    public List<AuthorEntity> findAll(Sort sort);
}
