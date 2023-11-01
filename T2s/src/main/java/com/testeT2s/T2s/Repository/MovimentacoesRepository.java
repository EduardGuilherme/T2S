package com.testeT2s.T2s.Repository;

import com.testeT2s.T2s.Model.Movimentacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface MovimentacoesRepository extends JpaRepository<Movimentacoes, UUID> {
    @Query("SELECT m.container.cliente, m.typeMovimentacao, COUNT(m) FROM Movimentacoes m " +
            "GROUP BY m.container.cliente, m.typeMovimentacao")
    List<Object[]> gerarRelatorioAgrupadoPorClienteETipoMovimentacao();
}
