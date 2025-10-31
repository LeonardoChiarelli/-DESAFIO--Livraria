package br.com.LeoChiarelli.Livraria.domain.author;

import br.com.LeoChiarelli.Livraria.application.ValidationException;
import br.com.LeoChiarelli.Livraria.domain.book.Book;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Author {
	private final UUID uuid;
	private final String name;
	private final LocalDate birthday;
    private final List<Book> books = new ArrayList<>();

	private Author (String name, LocalDate birthday, List<Book> books) {
        if (name == null || birthday == null || books == null) {
            throw new ValidationException("All core author details must be provided.");
        }
        this.uuid = UUID.randomUUID();
        this.name = name;
		this.birthday = birthday;
        this.books.addAll(books);
	}

    public Author(String name, LocalDate birthday) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.birthday = birthday;
    }

    public static AuthorBuilder builder() {
        return new AuthorBuilder();
    }

	public UUID getUUID() {
        return this.uuid;
    }

	public String getName() {
        return this.name;
    }

	public String getBirthday() {
		var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return this.birthday.format(formatter);
	}

    public List<Book> getBooks() {
        return this.books;
    }

    public void addBooks(List<Book> books) {
        this.books.addAll(books);
    }

	@Override
	public String toString() {
		return String.format("""
			UUID: %s
			Name: %s
			Birthday: %s
			Books: %s
			""", getUUID(), getName(), getBirthday(), getBooks());
	}

    public static class AuthorBuilder {
        private String name;
        private LocalDate birthday;
        private List<Book> books;

        public AuthorBuilder() {}

        public AuthorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public AuthorBuilder withBirthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public AuthorBuilder withBooks(List<Book> books) {
            this.books.addAll(books);
            return this;
        }

        public Author build() {
            if (name == null || name.trim().isEmpty()) {
                throw new ValidationException("Author name must be provided.");
            }
            if (birthday ==  null) {
                throw new ValidationException("Author birthday must be provided.");
            }
            if (books != null) {
                return new Author(this.name, this.birthday, this.books);
            }

            return new Author(this.name, this.birthday);
        }
    }
}
