package br.com.LeoChiarelli.Livraria.infrastructure.client.gateways;

import br.com.LeoChiarelli.Livraria.domain.client.Client;
import br.com.LeoChiarelli.Livraria.infrastructure.client.ClientEntity;

public class ClientEntityMapper {

    public static ClientEntity toEntity(Client client) {
        return new ClientEntity(client.getName(), client.getEmail(), client.getSsn());
    }

    public static Client toDomain(ClientEntity clientEntity) {
        return Client.builder()
                .withName(clientEntity.getName())
                .withEmail(clientEntity.getEmail())
                .withSSN(clientEntity.getSsn())
                .build();
    }
}
