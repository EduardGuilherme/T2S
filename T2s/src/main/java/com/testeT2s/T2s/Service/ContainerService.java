package com.testeT2s.T2s.Service;

import com.testeT2s.T2s.DTOs.ContainerDTO;
import com.testeT2s.T2s.Model.Container;
import com.testeT2s.T2s.Repository.ContainerRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ContainerService {
    final ContainerRepository containerRepository;

    public ContainerService(ContainerRepository containerRepository) {
        this.containerRepository = containerRepository;
    }

    @Transactional
    public Container SaveContainer(Container container){
        return containerRepository.save(container);
    }

    public Container updateContainer(UUID id, ContainerDTO containerDTO){
        Optional<Container> containers = containerRepository.findById(id);
        if(containers.isPresent()){
            Container existContainer = containers.get();
            existContainer.setCliente(containerDTO.cliente());
            existContainer.setNumberContainer(containerDTO.numberContainer());
            existContainer.setTypeContainer(containerDTO.typeContainer());
            existContainer.setStatusContainer(containerDTO.statusContainer());
            existContainer.setCategoriaContainer(containerDTO.categoriaContainer());

            return containerRepository.save(existContainer);
        }else{
            return null;
        }
    }
    public void deleteContainer(Container container){
        containerRepository.delete(container);
    }
    public Page<Container> findAllContainer(Pageable pageable){
        return containerRepository.findAll(pageable);
    }
    public Optional<Container> findByContainerID(UUID id){
        return containerRepository.findById(id);
    }
}
