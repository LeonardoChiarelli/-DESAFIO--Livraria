package br.com.LeoChiarelli.Livraria.application.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService service;

    @PostMapping("/registry")
    public ResponseEntity<AuthorDTO> registryAnAuthor(@RequestBody RegistryAuthorDTO dto, UriComponentsBuilder uriBuilder) {
        var authorDTO = service.registryAnAuthor(dto);
        var uri = uriBuilder.path("/{id}").buildAndExpand(authorDTO.id()).toUri();

        return ResponseEntity.created(uri).body(authorDTO);
    }

    @GetMapping
    public ResponseEntity<Page<AuthorDTO>> listAllAuthors(Pageable pageable) {
        return ResponseEntity.ok(service.listAllAuthors(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> detailAnAuthor(@PathVariable Long id) {
        return ResponseEntity.ok(service.detailAnAuthor(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnAuthor(@PathVariable Long id) {
        service.deleteAnAuthor(id);

        return ResponseEntity.noContent().build();
    }
}
