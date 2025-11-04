package br.com.LeoChiarelli.Livraria.application.author;

import br.com.LeoChiarelli.Livraria.application.ValidationException;
import br.com.LeoChiarelli.Livraria.infrastructure.author.AuthorEntity;
import br.com.LeoChiarelli.Livraria.infrastructure.author.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;


    public AuthorDTO registryAnAuthor(RegistryAuthorDTO dto) {
        var existisAuthor = repository.existsByName(dto.name());
        if (existisAuthor) { throw new ValidationException("Author already exists"); }

        var author = new AuthorEntity(dto);
        repository.save(author);
        return new AuthorDTO(author);
    }

    public Page<AuthorDTO> listAllAuthors(Pageable pageable) { return repository.findAll(pageable).map(AuthorDTO::new); }

    public AuthorDTO detailAnAuthor(Long id) {
        var authorEntity = repository.findById(id).orElseThrow(() -> new ValidationException("Author not found"));

        return new AuthorDTO(authorEntity);
    }

    public void deleteAnAuthor(Long id) {
        repository.deleteById(id);
    }
}
