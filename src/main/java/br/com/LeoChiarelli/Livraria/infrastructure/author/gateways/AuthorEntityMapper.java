package br.com.LeoChiarelli.Livraria.infrastructure.author.gateways;

import br.com.LeoChiarelli.Livraria.domain.author.Author;
import br.com.LeoChiarelli.Livraria.infrastructure.author.AuthorEntity;
import br.com.LeoChiarelli.Livraria.infrastructure.book.gateways.BookEntityMapper;

public class AuthorEntityMapper {
    public static AuthorEntity toEntity(Author domainAuthor) {
        return new AuthorEntity(domainAuthor.getName(), domainAuthor.getBirthday(), BookEntityMapper.toEntity(domainAuthor.getBooks()));
    }

    public static Author toDomain(AuthorEntity authorEntity) {
        return Author.builder()
                .withName(authorEntity.getName())
                .withBirthday(authorEntity.getBirthday())
                .withBooks(BookEntityMapper.toDomain(authorEntity.getBooks()))
                .build();
    }
}
