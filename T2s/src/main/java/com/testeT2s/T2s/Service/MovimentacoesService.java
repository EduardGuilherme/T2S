package com.testeT2s.T2s.Service;

import com.testeT2s.T2s.DTOs.MovimentacoesDTO;
import com.testeT2s.T2s.Model.Container;
import com.testeT2s.T2s.Model.Movimentacoes;
import com.testeT2s.T2s.Repository.ContainerRepository;
import com.testeT2s.T2s.Repository.MovimentacoesRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class MovimentacoesService {
    final MovimentacoesRepository movimentacoesRepository;

    final ContainerRepository containerRepository;

    public MovimentacoesService(MovimentacoesRepository movimentacoesRepository, ContainerRepository containerRepository) {
        this.movimentacoesRepository = movimentacoesRepository;
        this.containerRepository = containerRepository;
    }

    @Transactional
    public Movimentacoes saveMovimentacoes(MovimentacoesDTO movimentacoesDTO){
        Optional<Container> containerFound = containerRepository.findById(movimentacoesDTO.container().getId());
        if(containerFound.isPresent()){
            Movimentacoes movimentacoes = new Movimentacoes(
                    movimentacoesDTO.typeMovimentacao(),
                    movimentacoesDTO.dataStart(),
                    movimentacoesDTO.dateFinal(),
                    containerFound.get()
            );
            return movimentacoesRepository.save(movimentacoes);
        }else{
            throw new IllegalArgumentException("Nenhum Container encontrado para movimentação!");
        }
    }

    public Movimentacoes updateMovimentacoes(UUID id,MovimentacoesDTO movimentacoesDTO){
        Optional<Movimentacoes> movimentacoes = movimentacoesRepository.findById(id);
        Optional<Container> containerFound = containerRepository.findById(movimentacoesDTO.container().getId());
        if(movimentacoes.isPresent()){
            Movimentacoes movimentacao = movimentacoes.get();
            movimentacao.setContainer(movimentacoesDTO.container());
            movimentacao.setTypeMovimentacao(movimentacoesDTO.typeMovimentacao());
            movimentacao.setDataStart(movimentacoesDTO.dataStart());
            movimentacao.setDateFinal(movimentacoesDTO.dateFinal());

            return movimentacoesRepository.save(movimentacao);
        }else{
            throw new IllegalArgumentException("Movimentação não encontrada!");
        }
    }

    public void deleteMovimentacoes(Movimentacoes movimentacoes){
        movimentacoesRepository.delete(movimentacoes);
    }
    public Page<Movimentacoes> findAllMovimentacoes(Pageable pageable){
        return movimentacoesRepository.findAll(pageable);
    }
    public Optional<Movimentacoes> findByMovimentaooesID(UUID id){
        return movimentacoesRepository.findById(id);
    }
}
