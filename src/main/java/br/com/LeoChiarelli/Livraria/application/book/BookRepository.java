package br.com.LeoChiarelli.Livraria.application.book;

import br.com.LeoChiarelli.Livraria.infrastructure.book.BookEntity;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    Boolean existsByTitle(@NotBlank(message = "Book title is required") String title);
}
