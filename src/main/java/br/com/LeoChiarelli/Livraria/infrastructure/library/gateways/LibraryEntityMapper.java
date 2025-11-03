package br.com.LeoChiarelli.Livraria.infrastructure.library.gateways;

import br.com.LeoChiarelli.Livraria.domain.library.Library;
import br.com.LeoChiarelli.Livraria.infrastructure.author.gateways.AuthorEntityMapper;
import br.com.LeoChiarelli.Livraria.infrastructure.book.gateways.BookEntityMapper;
import br.com.LeoChiarelli.Livraria.infrastructure.library.LibraryEntity;
import br.com.LeoChiarelli.Livraria.infrastructure.loan.gateways.LoanEntityMapper;

public class LibraryEntityMapper {
    public static Library toDomain(LibraryEntity libraryEntity) {
        return Library.builder()
                .withBooks(BookEntityMapper.toDomain(libraryEntity.getBooks()))
                .build();
    }

    public static LibraryEntity toEntity(Library library) {
        return new LibraryEntity(
                library.getAuthors().stream()
                        .map(AuthorEntityMapper::toEntity)
                        .toList(),
                BookEntityMapper.toEntity(library.getBooks()),
                LoanEntityMapper.toEntity(library.getLoans())
        );
    }
}
