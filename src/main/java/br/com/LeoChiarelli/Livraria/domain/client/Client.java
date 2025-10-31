package br.com.LeoChiarelli.Livraria.domain.client;

import br.com.LeoChiarelli.Livraria.application.ValidationException;

import java.util.UUID;

public class Client {
    private final UUID uuid;
    private final String name;
    private final String email;
    private final String ssn;

    private Client (String name, String email, String ssn) {
        if (name == null || email == null || ssn == null) {
            throw new ValidationException("All core client details must be provided.");
        }
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.ssn = ssn;
    }

    public static ClientBuilder builder() {
        return new ClientBuilder();
    }

    public UUID getUUID() { return this.uuid; }

    public String getName() { return this.name; }

    public String getEmail() { return email; }

    public String getSsn() { return ssn; }

    @Override
    public String toString() {
        return String.format("""
                UUID: %s
                Name: %s
                Email: %s
                SSN: %s
                """,
                getUUID(),
                getName(),
                getEmail(),
                getSsn());
    }

    public static class ClientBuilder {
        private String name;
        private String email;
        private String ssn;

        public ClientBuilder() {}

        public ClientBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ClientBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public ClientBuilder withSSN(String ssn) {
            this.ssn = ssn;
            return this;
        }

        public Client build() {
            if (name == null || name.trim().isEmpty()) {
                throw new ValidationException("Client name must be provided.");
            }

            if (email == null || email.trim().isEmpty()) {
                throw new ValidationException("Client email must be provided.");
            }

            if (ssn == null || ssn.isEmpty()) {
                throw new ValidationException("Client SSN must be provided.");
            }

            return new Client(this.name, this.email, this.ssn);
        }
    }
}
