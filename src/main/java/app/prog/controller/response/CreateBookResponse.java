package app.prog.controller.response;

import app.prog.model.AuthorEntity;
import app.prog.model.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class CreateBookResponse {
    private AuthorEntity author;
    private List<CategoryEntity> categories;
    private String title;
}
