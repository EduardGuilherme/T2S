package com.testeT2s.T2s.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;
import java.util.UUID;
@Entity
@Table(name = "Container")
public class Container implements Serializable {
    private static final long SerialVersionID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String cliente;
    @Pattern(regexp = "^[A-Z]{4}[0-9]{7}$")
    private String numberContainer;
    @Pattern(regexp = "^(20|40)$")
    private String typeContainer;
    @Pattern(regexp = "^(CHEIO|VAZIO)$")
    private String statusContainer;
    @Pattern(regexp = "^(EXPORTAÇÃO|IMPORTAÇÃO)")
    private String categoriaContainer;

    public Container(){

    }
    public Container(UUID id, String cliente, String numberContainer, String typeContainer, String statusContainer, String categoriaContainer) {
        this.id = id;
        this.cliente = cliente;
        this.numberContainer = numberContainer;
        this.typeContainer = typeContainer;
        this.statusContainer = statusContainer;
        this.categoriaContainer = categoriaContainer;
    }

    public long getSerialVersionID() {
        return SerialVersionID;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {this.cliente = cliente;}

    public String getNumberContainer() {
        return numberContainer;
    }

    public void setNumberContainer(String numberContainer) {
        this.numberContainer = numberContainer;
    }

    public String getTypeContainer() {
        return typeContainer;
    }

    public void setTypeContainer(String typeContainer) {
        this.typeContainer = typeContainer;
    }

    public String getStatusContainer() {
        return statusContainer;
    }

    public void setStatusContainer(String statusContainer) {
        this.statusContainer = statusContainer;
    }

    public String getCategoriaContainer() {
        return categoriaContainer;
    }

    public void setCategoriaContainer(String categoriaContainer) {
        this.categoriaContainer = categoriaContainer;
    }
}
