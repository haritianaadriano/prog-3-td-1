package app.prog.controller.mapper;

import app.prog.controller.response.*;
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
    public AuthorEntity toDomain(CreateAuthorResponse rest){
        return AuthorEntity.builder()
                .name(rest.getName())
                .particularity(rest.getParticularity())
                .birthDate(rest.getBirthdate())
                .build();
    }
    public AuthorEntity toDomain(UpdateAuthorResponse rest){
        return AuthorEntity.builder()
                .id(rest.getId())
                .name(rest.getName())
                .particularity(rest.getParticularity())
                .birthDate(rest.getBirthdate())
                .build();
    }
}
