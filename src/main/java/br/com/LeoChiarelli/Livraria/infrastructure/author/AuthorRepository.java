package br.com.LeoChiarelli.Livraria.infrastructure.author;

import br.com.LeoChiarelli.Livraria.domain.book.Book;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
    Boolean existsByName(@NotBlank(message = "Author´s name is required") String name);
}
