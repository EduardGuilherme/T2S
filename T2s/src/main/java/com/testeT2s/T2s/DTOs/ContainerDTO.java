package com.testeT2s.T2s.DTOs;

import com.testeT2s.T2s.Model.Container;
import jakarta.validation.constraints.Pattern;

public record ContainerDTO(
        String cliente,
        String numberContainer,
        String typeContainer,
        String statusContainer,
        String categoriaContainer
){
    public ContainerDTO(Container container){
        this(container.getCliente(),container.getNumberContainer(),container.getTypeContainer(),container.getStatusContainer(),container.getCategoriaContainer());
    }
}
