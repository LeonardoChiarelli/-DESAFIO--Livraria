package br.com.LeoChiarelli.Livraria.infrastructure.library;

import br.com.LeoChiarelli.Livraria.infrastructure.author.AuthorEntity;
import br.com.LeoChiarelli.Livraria.infrastructure.book.BookEntity;
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
     private List<AuthorEntity> authors = new ArrayList<>();

     @ManyToMany
     private List<BookEntity> books = new ArrayList<>();

     @ManyToMany
     private List<LoanEntity> loans = new ArrayList<>();

     
}
