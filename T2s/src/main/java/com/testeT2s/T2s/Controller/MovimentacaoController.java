package com.testeT2s.T2s.Controller;

import com.testeT2s.T2s.DTOs.MovimentacoesDTO;
import com.testeT2s.T2s.Model.Movimentacoes;
import com.testeT2s.T2s.Service.MovimentacoesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("movimentacoes")
@CrossOrigin(origins = "*")
public class MovimentacaoController {
    final MovimentacoesService movimentacoesService;

    public MovimentacaoController(MovimentacoesService movimentacoesService) {
        this.movimentacoesService = movimentacoesService;
    }
    @PostMapping
    public Movimentacoes createMovimentacoes(@RequestBody MovimentacoesDTO movimentacoesDTO){
        return movimentacoesService.saveMovimentacoes(movimentacoesDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movimentacoes> updateMovimentacoes(@PathVariable UUID id, @RequestBody MovimentacoesDTO movimentacoesDTO){
        Movimentacoes updateMovimentacoes = movimentacoesService.updateMovimentacoes(id,movimentacoesDTO);
        if(updateMovimentacoes != null){
            return ResponseEntity.ok(updateMovimentacoes);
        }else{
            throw new IllegalArgumentException("Nenhuma movimentação foi encontrada!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContainer(@PathVariable UUID id) {
        Optional<Movimentacoes> movimentacoesOptional = movimentacoesService.findByMovimentaooesID(id);
        if (movimentacoesOptional.isPresent()) {
            movimentacoesService.deleteMovimentacoes(movimentacoesOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public ResponseEntity<Page<Movimentacoes>> getAllContainers(Pageable pageable) {
        return ResponseEntity.ok(movimentacoesService.findAllMovimentacoes(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Movimentacoes> getContainerById(@PathVariable UUID id) {
        Optional<Movimentacoes> movimentacoesOptional = movimentacoesService.findByMovimentaooesID(id);
        if (movimentacoesOptional.isPresent()) {
            return ResponseEntity.ok(movimentacoesOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
