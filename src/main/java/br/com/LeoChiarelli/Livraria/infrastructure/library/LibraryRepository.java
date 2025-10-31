package br.com.LeoChiarelli.Livraria.infrastructure.library;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<LibraryEntity, Long> {
}
