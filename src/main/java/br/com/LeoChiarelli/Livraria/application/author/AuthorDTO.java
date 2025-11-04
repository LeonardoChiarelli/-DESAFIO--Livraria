package br.com.LeoChiarelli.Livraria.application.author;

import br.com.LeoChiarelli.Livraria.infrastructure.author.AuthorEntity;
import br.com.LeoChiarelli.Livraria.infrastructure.book.BookEntity;
import br.com.LeoChiarelli.Livraria.infrastructure.library.LibraryEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public record AuthorDTO(Long id, String name, LocalDate birthday, List<BookEntity> books, Set<LibraryEntity> libraries) {

    public AuthorDTO(AuthorEntity author) {
        this(author.getId(), author.getName(), author.getBirthday(), author.getBooks(), author.getLibraries());
    }
}
