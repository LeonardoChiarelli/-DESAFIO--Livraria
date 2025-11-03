package br.com.LeoChiarelli.Livraria.infrastructure.library;

import br.com.LeoChiarelli.Livraria.infrastructure.author.AuthorEntity;
import br.com.LeoChiarelli.Livraria.infrastructure.book.BookEntity;
import br.com.LeoChiarelli.Livraria.infrastructure.loan.LoanEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Library")
@Table(name = "libraries")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class LibraryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

     @ManyToMany
     @JoinTable(
             name = "library_author",
             joinColumns = @JoinColumn(name = "library_id"),
             inverseJoinColumns = @JoinColumn(name = "author_id")
     )
     private List<AuthorEntity> authors = new ArrayList<>();

     @ManyToMany
     @JoinTable(
             name = "library_book",
             joinColumns = @JoinColumn(name = "library_id"),
             inverseJoinColumns = @JoinColumn(name = "book_id")
     )
     private List<BookEntity> books = new ArrayList<>();

     @ManyToMany
     @JoinTable(
             name = "library_loan",
             joinColumns = @JoinColumn(name = "library_id"),
             inverseJoinColumns = @JoinColumn(name = "loan_id")
     )
     private List<LoanEntity> loans = new ArrayList<>();


    public LibraryEntity(List<AuthorEntity> authorEntities, List<BookEntity> bookEntities, List<LoanEntity> loanEntities) {
        this.authors.addAll(authorEntities);
        this.books.addAll(bookEntities);
        this.loans.addAll(loanEntities);
    }
}

