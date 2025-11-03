package br.com.LeoChiarelli.Livraria.infrastructure.loan.gateways;

import br.com.LeoChiarelli.Livraria.domain.loan.Loan;
import br.com.LeoChiarelli.Livraria.infrastructure.book.gateways.BookEntityMapper;
import br.com.LeoChiarelli.Livraria.infrastructure.client.gateways.ClientEntityMapper;
import br.com.LeoChiarelli.Livraria.infrastructure.loan.LoanEntity;

import java.util.List;

public class LoanEntityMapper {
    public static Loan toDomain(LoanEntity loanEntity) {
        return Loan.builder()
                .withBooks(BookEntityMapper.toDomain(loanEntity.getBooks()))
                .withClient(ClientEntityMapper.toDomain(loanEntity.getClient()))
                .build();
    }

    public static List<LoanEntity> toEntity(List<Loan> loans) {
        return loans.stream()
                .map(l -> {
                    return new LoanEntity(BookEntityMapper.toEntity(l.getBooks()), ClientEntityMapper.toEntity(l.getClient()), l.getLoanDate(), l.getDevolutionDate());
                })
                .toList();
    }
}
