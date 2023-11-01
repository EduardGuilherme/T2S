package com.testeT2s.T2s.Controller;

import com.testeT2s.T2s.DTOs.RelatorioDTO;
import com.testeT2s.T2s.Service.RelatorioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relatorio")
public class RelatorioController {
    final RelatorioService relatorioService;

    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @GetMapping("/movimentacoes")
    public List<RelatorioDTO> relatorioMovimentacoesAgrupadas() {
        return relatorioService.gerarRelatorioAgrupadoPorClienteETipoMovimentacao();
    }
}
