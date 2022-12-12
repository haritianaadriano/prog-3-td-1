package app.prog.controller.response;

import app.prog.model.AuthorEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BookResponse {
    private int id;
    private AuthorEntity author;
    private String title;
    private boolean hasAuthor;
}
