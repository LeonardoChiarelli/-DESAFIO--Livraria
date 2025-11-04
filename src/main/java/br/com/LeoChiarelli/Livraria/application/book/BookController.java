package br.com.LeoChiarelli.Livraria.application.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping("/registry")
    public ResponseEntity<BookDTO> registryABook(@RequestBody RegistryBookDTO dto, UriComponentsBuilder uriBuilder) {
        var bookDTO = service.registryABook(dto);
        var uri = uriBuilder.path("/{id}").buildAndExpand(bookDTO.id()).toUri();

        return ResponseEntity.created(uri).body(bookDTO);
    }

    @GetMapping
    public ResponseEntity<Page<BookDTO>> listAllBooks(Pageable pageable) {
        return ResponseEntity.ok(service.listAllBooks(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> detailABook(@PathVariable Long id) {
        return ResponseEntity.ok(service.detailAnBook(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteABook(@PathVariable Long id) {
        service.deleteABook(id);

        return ResponseEntity.noContent().build();
    }
}
