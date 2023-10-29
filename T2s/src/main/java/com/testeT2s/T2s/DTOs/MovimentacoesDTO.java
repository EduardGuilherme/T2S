package com.testeT2s.T2s.DTOs;

import com.testeT2s.T2s.Model.Container;
import com.testeT2s.T2s.Model.Movimentacoes;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public record MovimentacoesDTO(
        String typeMovimentacao,
        Date dataStart,
        Date dateFinal,
        Container container) {
    public MovimentacoesDTO(Movimentacoes movimentacoes){
        this(movimentacoes.getTypeMovimentacao(),movimentacoes.getDataStart(),movimentacoes.getDateFinal(),movimentacoes.getContainer());
    }
}
