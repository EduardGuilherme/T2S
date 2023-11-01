package com.testeT2s.T2s.DTOs;

import com.testeT2s.T2s.Model.Relatorio;

public record RelatorioDTO(
        String cliente,
        String tipodemovimentacao,
        long totaldeMovimentacao) {
    public RelatorioDTO(Relatorio relatorio){
        this(relatorio.getCliente(),relatorio.getTipodemovimentacao(),relatorio.getTotaldeMovimentacao());
    }
}
