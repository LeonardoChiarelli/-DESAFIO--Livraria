package br.com.LeoChiarelli.Livraria.application.author;

import br.com.LeoChiarelli.Livraria.infrastructure.book.BookEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record RegistryAuthorDTO(

        Long id,

        @NotBlank(message = "Author´s name is required")
        String name,

        @NotNull(message = "Author´s birthday is required")
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate birthday,

        @NotNull(message = "To be an author you need to have a book")
        List<BookEntity> books
) {
}
