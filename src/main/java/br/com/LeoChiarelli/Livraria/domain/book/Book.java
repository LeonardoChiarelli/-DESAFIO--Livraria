package br.com.LeoChiarelli.Livraria.domain.book;

import br.com.LeoChiarelli.Livraria.application.ValidationException;
import br.com.LeoChiarelli.Livraria.domain.author.Author;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Book {
	private final UUID uuid;
	private final String title;
	private final Author author;
	private final boolean available;
	private final LocalDate registrationDate;
	private final LocalDate updateDate;


    private Book(String title, Author author, LocalDate updateDate) {
        if (title == null || author == null || updateDate == null) {
            throw new ValidationException("All core book details must be provided.");
        }
        this.uuid = UUID.randomUUID();
        this.title = title;
		this.author = author;
		this.available = true;
		this.registrationDate = LocalDate.now();
		this.updateDate = updateDate;
	}

    public static BookBuilder builder() {
        return new BookBuilder();
    }

	public UUID getUUID() {
        return this.uuid;
    }

    public String getTitle() {
        return this.title;
    }

	public Author getAuthor() {
        return this.author;
    }

	public String getAvailable() { // Modificar depois
		if (this.available) {
			return "Available";
		} else {
			return "Unavailable";
		}
	}

	public String getRegistrationDate() {
	
		var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Extratir para outra lógica
		
		return this.registrationDate.format(formatter);
	}	
	
	public String getUpdateDate() {
		var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return this.updateDate.format(formatter);
	}


	@Override
	public String toString() {
		return String.format("""
			UUID: %s
			Title: %s
			Author: %s
			Avaiable: %s
			Registration Date: %s
			Update Date: %s
			""", getUUID(), getTitle(), getAuthor(), getAvailable(), getRegistrationDate(), getUpdateDate());
	}

    public static class BookBuilder {
        private String title;
        private Author author;
        private LocalDate updateDate;

        public BookBuilder() {}

        public BookBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder withAuthor(Author author) {
            this.author = author;
            return this;
        }

        public BookBuilder withUpdateDate(LocalDate updateDate) {
            this.updateDate = updateDate;
            return this;
        }

        public Book build() {
            if (title == null || title.trim().isEmpty()) {
                throw new ValidationException("Book title must be provided.");
            }
            if (author == null) {
                throw new ValidationException("Book author must be provided.");
            }
            if (updateDate == null) {
                throw new ValidationException("Book update date must be provided.");
            }

            return new Book(this.title, this.author, this.updateDate);
        }
    }
}
