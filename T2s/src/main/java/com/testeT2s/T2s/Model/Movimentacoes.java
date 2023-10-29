package com.testeT2s.T2s.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
@Entity
@Table(name = "Movimentacoes")
public class Movimentacoes implements Serializable {
    private static final long SerialVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Pattern(regexp = "^(EMBARQUE|DESCARGA|GATE IN|GATE OUT|REPOSICIONAMENTO|PESAGEM|SCANNER)$")
    private String typeMovimentacao;

    private Date dataStart;
    private Date dateFinal;

    @ManyToOne
    private Container container;

    public  Movimentacoes(){}
    public Movimentacoes(UUID id, String typeMovimentacao, Date dataStart, Date dateFinal, Container container) {
        this.id = id;
        this.typeMovimentacao = typeMovimentacao;
        this.dataStart = dataStart;
        this.dateFinal = dateFinal;
        this.container = container;
    }

    public Movimentacoes(String typeMovimentacao, Date dataStart, Date dateFinal, Container container) {
        this.typeMovimentacao = typeMovimentacao;
        this.dataStart = dataStart;
        this.dateFinal = dateFinal;
        this.container = container;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTypeMovimentacao() {
        return typeMovimentacao;
    }

    public void setTypeMovimentacao(String typeMovimentacao) {
        this.typeMovimentacao = typeMovimentacao;
    }

    public Date getDataStart() {
        return dataStart;
    }

    public void setDataStart(Date dataStart) {
        this.dataStart = dataStart;
    }

    public Date getDateFinal() {
        return dateFinal;
    }

    public void setDateFinal(Date dateFinal) {
        this.dateFinal = dateFinal;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }
}
