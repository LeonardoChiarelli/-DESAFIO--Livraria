package br.com.LeoChiarelli.Livraria.domain.library;

import br.com.LeoChiarelli.Livraria.application.ValidationException;
import br.com.LeoChiarelli.Livraria.domain.author.Author;
import br.com.LeoChiarelli.Livraria.domain.book.Book;
import br.com.LeoChiarelli.Livraria.domain.client.Client;
import br.com.LeoChiarelli.Livraria.domain.loan.Loan;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<>();;
    private final List<Author> authors = new ArrayList<>();;
    private final List<Loan> loans = new ArrayList<>();

    private Library(List<Book> books) {
        if (books.isEmpty()) {
            throw new ValidationException("Library books must be provided.");
        }

        for (Book book : books) {
            this.books.add(book);
            this.authors.add(book.getAuthor());
        }
    }

    public static LibraryBuilder builder() {
        return new LibraryBuilder();
    }

    public void doALoan(Book book, Client client) {
        this.loans.add(Loan.builder()
                .withBook(book)
                .withClient(client)
                .build());
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    @Override
    public String toString() {
        return String.format("""
                Books: %s \n
                Author: %s \n
                """, getBooks(), getAuthors());
    }

    public static class LibraryBuilder {
        private List<Book> books = new ArrayList<>();

        public LibraryBuilder() {}

        public LibraryBuilder withBooks(List<Book> books) {
            this.books.addAll(books);
            return this;
        }

        public Library build() {
            if (books == null) {
                throw new ValidationException("Library books must be provided.");
            }

            return new Library(this.books);
        }
    }
}
