package br.com.LeoChiarelli.Livraria.application.book;

import br.com.LeoChiarelli.Livraria.infrastructure.author.AuthorEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RegistryBookDTO(

        Long id,

        @NotBlank(message = "Book title is required")
        String title,

        @NotNull(message = "Book author is required")
        AuthorEntity author,

        @JsonFormat(pattern = "dd/MM/yyyy")
        @NotNull(message = "Book update date is required")
        LocalDate updateDate
) {
}
