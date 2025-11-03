package br.com.LeoChiarelli.Livraria.infrastructure.loan;

import br.com.LeoChiarelli.Livraria.infrastructure.book.BookEntity;
import br.com.LeoChiarelli.Livraria.infrastructure.client.ClientEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Loan")
@Table(name = "loans")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class LoanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany
    private List<BookEntity> books = new ArrayList<>();

    @OneToOne
    private ClientEntity client;

    private LocalDate loanDate;
    private LocalDate devolutionDate;

    public LoanEntity(List<BookEntity> books, ClientEntity client, LocalDate loanDate, LocalDate devolutionDate) {
        this.books = books;
        this.client = client;
        this.loanDate = loanDate;
        this.devolutionDate = devolutionDate;
    }
}
