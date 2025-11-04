package br.com.LeoChiarelli.Livraria.application.book;

import br.com.LeoChiarelli.Livraria.infrastructure.book.BookEntity;

import java.time.LocalDate;

public record BookDTO(Long id, String title, String author, boolean available, LocalDate registrationDate, LocalDate updateDate) {
    public BookDTO(BookEntity book) {
        this(book.getId(), book.getTitle(), book.getAuthor().getName(), book.isAvailable(), book.getRegistrationDate(), book.getUpdateDate());
    }
}
