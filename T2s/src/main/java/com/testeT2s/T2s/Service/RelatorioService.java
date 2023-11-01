package com.testeT2s.T2s.Service;

import com.testeT2s.T2s.DTOs.RelatorioDTO;
import com.testeT2s.T2s.Repository.MovimentacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RelatorioService {

    final MovimentacoesRepository movimentacoesRepository;

    public RelatorioService(MovimentacoesRepository movimentacoesRepository) {
        this.movimentacoesRepository = movimentacoesRepository;
    }

    public List<RelatorioDTO> gerarRelatorioAgrupadoPorClienteETipoMovimentacao() {
        List<Object[]> results = movimentacoesRepository.gerarRelatorioAgrupadoPorClienteETipoMovimentacao();
        List<RelatorioDTO> relatorioDTOList = new ArrayList<>();
        if(results.isEmpty()){
            return relatorioDTOList;
        }else{
            for (Object[] result : results) {
                String cliente = (String) result[0];
                String typeMovimentacao = (String) result[1];
                long totalMovimentacoes = (Long) result[2];

                RelatorioDTO relatorioDTO = new RelatorioDTO(cliente, typeMovimentacao, totalMovimentacoes);
                relatorioDTOList.add(relatorioDTO);
            }

            return relatorioDTOList;
        }
    }
}
