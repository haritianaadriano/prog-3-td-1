package app.prog.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@Builder
public class CreateAuthorResponse {
    private String name;
    private LocalDate birthdate;
    private String particularity;
}
