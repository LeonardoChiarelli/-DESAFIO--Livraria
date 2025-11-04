package br.com.LeoChiarelli.Livraria.application.book;

import br.com.LeoChiarelli.Livraria.application.ValidationException;
import br.com.LeoChiarelli.Livraria.infrastructure.book.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public BookDTO registryABook(RegistryBookDTO dto) {
        var existsBook = repository.existsByTitle(dto.title());
        if (existsBook) {
            throw new ValidationException("Book already exists");
        }

        var book = new BookEntity(dto);
        repository.save(book);

        return new BookDTO(book);
    }

    public Page<BookDTO> listAllBooks(Pageable pageable) { return repository.findAll(pageable).map(BookDTO::new); }

    public BookDTO detailAnBook(Long id) {
        var book = repository.findById(id).orElseThrow(() -> new ValidationException("Book not found"));

        return new BookDTO(book);
    }

    public void deleteABook(Long id) {
        repository.deleteById(id);
    }
}
