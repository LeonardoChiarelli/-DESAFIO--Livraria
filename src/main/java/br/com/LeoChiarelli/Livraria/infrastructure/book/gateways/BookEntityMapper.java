package br.com.LeoChiarelli.Livraria.infrastructure.book.gateways;

import br.com.LeoChiarelli.Livraria.domain.author.Author;
import br.com.LeoChiarelli.Livraria.domain.book.Book;
import br.com.LeoChiarelli.Livraria.infrastructure.author.gateways.AuthorEntityMapper;
import br.com.LeoChiarelli.Livraria.infrastructure.book.BookEntity;

import java.time.LocalDate;
import java.util.List;

public class BookEntityMapper {
    public static List<BookEntity> toEntity(List<Book> domainBooks) {
        return domainBooks.stream()
                .map(book -> { return new BookEntity(book.getTitle(), AuthorEntityMapper.toEntity(book.getAuthor()), LocalDate.parse(book.getUpdateDate())); })
                .toList();
    }

    public static List<Book> toDomain(List<BookEntity> bookEntities) {
        return bookEntities.stream()
                .map(bookEntity -> { return Book.builder()
                        .withTitle(bookEntity.getTitle())
                        .withAuthor(Author.builder()
                                .withName(bookEntity.getAuthor().getName())
                                .withBirthday(bookEntity.getAuthor().getBirthday())
                                .build())
                        .withUpdateDate(bookEntity.getUpdateDate())
                        .build(); })
                .toList();
    }
}
