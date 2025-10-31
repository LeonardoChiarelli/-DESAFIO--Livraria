package br.com.LeoChiarelli.Livraria.infrastructure.book;

import br.com.LeoChiarelli.Livraria.application.book.RegistryBookDTO;
import br.com.LeoChiarelli.Livraria.infrastructure.author.AuthorEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "Book")
@Table(name = "books")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    private AuthorEntity author;

    private boolean available;
    private LocalDate registrationDate;
    private LocalDate updateDate;

    public BookEntity(RegistryBookDTO dto) {
        this.title = dto.title();
        this.author = new AuthorEntity(dto.author());
        this.available = true;
        this.registrationDate = LocalDate.now();
        this.updateDate = dto.updateDate();
    }

    public BookEntity(String title, AuthorEntity author, LocalDate updateDate) {
        this.title = title;
        this.author = author;
        this.available = true;
        this.registrationDate = LocalDate.now();
        this.updateDate = updateDate;
    }
}
