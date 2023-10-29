package com.testeT2s.T2s.Repository;

import com.testeT2s.T2s.Model.Movimentacoes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovimentacoesRepository extends JpaRepository<Movimentacoes, UUID> {
}
