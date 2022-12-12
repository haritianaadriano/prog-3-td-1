package app.prog.controller.mapper;

import app.prog.controller.response.AuthorResponse;
import app.prog.controller.response.BookResponse;
import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;

public class AuthorRestMapper {
    public AuthorResponse toRest(AuthorEntity domain) {
        return AuthorResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .particularity(domain.getParticularity())
                .hasParticularity(domain.hasParticularity())
                .build();
    }
}