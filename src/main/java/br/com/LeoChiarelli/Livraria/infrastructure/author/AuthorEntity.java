package br.com.LeoChiarelli.Livraria.infrastructure.author;

import br.com.LeoChiarelli.Livraria.application.author.RegistryAuthorDTO;
import br.com.LeoChiarelli.Livraria.infrastructure.book.BookEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Author")
@Table(name = "authors")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private LocalDate birthday;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BookEntity> books = new ArrayList<>();

    public AuthorEntity(RegistryAuthorDTO dto) {
        this.name = dto.name();
        this.birthday = dto.birthday();
        this.books.addAll(dto.books());
    }

    public AuthorEntity(String name, String birthday, List<BookEntity> books) {
        this.name = name;
        this.birthday = LocalDate.parse(birthday);
        this.books.addAll(books);
    }
}
