package app.prog.controller.mapper;

import app.prog.controller.response.BookResponse;
import app.prog.controller.response.CreateBookResponse;
import app.prog.controller.response.UpdateBookResponse;
import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import app.prog.repository.AuthorRepository;
import org.springframework.stereotype.Component;

@Component
public class BookRestMapper {
    private AuthorRepository authorRepository;
    public BookResponse toRest(BookEntity domain) {
        return BookResponse.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .categories(domain.getCategories())
                .author(domain.getAuthor() == null ? null : domain.getAuthor().getName())
                .hasAuthor(domain.hasAuthor())
                .build();
    }

    public BookEntity toDomain(CreateBookResponse rest) {
        AuthorEntity THIS_AUTHOR = authorRepository.findByNameContainingIgnoreCase(rest.getAuthor());
        return BookEntity.builder()
                .title(rest.getTitle())
                .categories(rest.getCategories())
                .pageNumber(0) //Constraint not null in database, default value is 0
                .author(THIS_AUTHOR)
                .build();
    }

    public BookEntity toDomain(UpdateBookResponse rest) {
        AuthorEntity THIS_AUTHOR = authorRepository.findByNameContainingIgnoreCase(rest.getAuthor());
        return BookEntity.builder()
                .id(rest.getId())
                .author(THIS_AUTHOR)
                .title(rest.getTitle())
                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
    }
}
