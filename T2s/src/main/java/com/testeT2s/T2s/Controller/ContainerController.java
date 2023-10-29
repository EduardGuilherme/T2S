package com.testeT2s.T2s.Controller;

import com.testeT2s.T2s.DTOs.ContainerDTO;
import com.testeT2s.T2s.Model.Container;
import com.testeT2s.T2s.Service.ContainerService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("container")
@CrossOrigin(origins = "*")
public class ContainerController {
    final ContainerService containerService;

    public ContainerController(ContainerService containerService) {
        this.containerService = containerService;
    }

    @PostMapping
    public ResponseEntity<Container> createContainer(@RequestBody ContainerDTO containerDTO) {
        var container = new Container();
        BeanUtils.copyProperties(containerDTO, container);
        return ResponseEntity.status(HttpStatus.CREATED).body(containerService.SaveContainer(container));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Container> updateContainer(@PathVariable UUID id, @RequestBody ContainerDTO containerDTO) {
        Container updatedContainer = containerService.updateContainer(id, containerDTO);
        if (updatedContainer != null) {
            return ResponseEntity.ok(updatedContainer);
        } else {
            throw new IllegalArgumentException("Nenhum Container foi encontrado!");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContainer(@PathVariable UUID id) {
        Optional<Container> containerOptional = containerService.findByContainerID(id);
        if (containerOptional.isPresent()) {
            containerService.deleteContainer(containerOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Page<Container>> getAllContainers(Pageable pageable) {
        return ResponseEntity.ok(containerService.findAllContainer(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Container> getContainerById(@PathVariable UUID id) {
        Optional<Container> containerOptional = containerService.findByContainerID(id);
        if (containerOptional.isPresent()) {
            return ResponseEntity.ok(containerOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}