package br.com.LeoChiarelli.Livraria.application.book.gateways;

import br.com.LeoChiarelli.Livraria.infrastructure.book.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryOfBook extends JpaRepository<BookEntity, Long> {
}
