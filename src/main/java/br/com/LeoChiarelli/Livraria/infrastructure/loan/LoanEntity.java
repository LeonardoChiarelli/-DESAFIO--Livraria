package br.com.LeoChiarelli.Livraria.infrastructure.loan;

import br.com.LeoChiarelli.Livraria.domain.book.Book;
import br.com.LeoChiarelli.Livraria.domain.client.Client;
import br.com.LeoChiarelli.Livraria.infrastructure.book.BookEntity;
import br.com.LeoChiarelli.Livraria.infrastructure.client.ClientEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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

    @OneToMany()
    private List<BookEntity> books;

    @OneToOne
    private ClientEntity client;

    private LocalDate loanDate;
    private LocalDate devolutionDate;
}
