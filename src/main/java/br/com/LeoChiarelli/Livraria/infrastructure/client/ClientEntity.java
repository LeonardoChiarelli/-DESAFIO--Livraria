package br.com.LeoChiarelli.Livraria.infrastructure.client;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Client")
@Table(name = "clients")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;
    private String ssn;

    public ClientEntity(RegistryClientDTO dto) {
        this.name = dto.name();
        this.email = dto.email();
        this.ssn = dto.ssn();
    }

    public ClientEntity(String name, String email, String ssn) {
        this.name = name;
        this.email = email;
        this.ssn = ssn;
    }
}
