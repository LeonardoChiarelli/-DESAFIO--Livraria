package br.com.LeoChiarelli.Livraria.domain.loan;

import br.com.LeoChiarelli.Livraria.application.ValidationException;
import br.com.LeoChiarelli.Livraria.domain.book.Book;
import br.com.LeoChiarelli.Livraria.domain.client.Client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Loan {
    private final UUID uuid;
    private final List<Book> books = new ArrayList<>();
    private final Client client;
    private final LocalDate loanDate;
    private final LocalDate devolutionDate;

    private Loan(List<Book> books, Client client) {
        if (books == null || client == null) {
            throw new ValidationException("All core loan details must be provided.");
        }
        this.uuid = UUID.randomUUID();
        this.books.addAll(books);
        this. client = client;
        this. loanDate = LocalDate.now();
        this.devolutionDate = LocalDate.now().plusDays(7);
    }

    public static LoanBuilder builder() {
        return new LoanBuilder();
    }

    public UUID getUuid() {
        return uuid;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Client getClient() {
        return client;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getDevolutionDate() {
        return devolutionDate;
    }

    @Override
    public String toString() {
        return String.format("""
                UUID: %s
                Book: %s
                Client: %s
                Loan Date: %s
                Devolution Date: %s
                """,
                getUuid(),
                getBooks(),
                getClient().getName(),
                getLoanDate(),
                getDevolutionDate());
    }

    public static class LoanBuilder {
        private List<Book> books = new ArrayList<>();
        private Client client;

        public LoanBuilder() {}

        public LoanBuilder withBooks(List<Book> books) {
            this.books.addAll(books);
            return this;
        }

        public LoanBuilder withClient(Client client) {
            this.client = client;
            return this;
        }

        public Loan build() {
            if (books == null) {
                throw new ValidationException("Loan book must be provided.");
            }

            if (client == null) {
                throw new ValidationException("Loan client must be provided.");
            }

            return new Loan(this.books, this.client);
        }
    }
}
