package com.testeT2s.T2s.Model;

public class Relatorio {
    private String cliente;
    private String tipodemovimentacao;
    private long totaldeMovimentacao;

    public Relatorio(String cliente, String tipodemovimentacao, int totaldeMovimentacao) {
        this.cliente = cliente;
        this.tipodemovimentacao = tipodemovimentacao;
        this.totaldeMovimentacao = totaldeMovimentacao;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTipodemovimentacao() {
        return tipodemovimentacao;
    }

    public void setTipodemovimentacao(String tipodemovimentacao) {
        this.tipodemovimentacao = tipodemovimentacao;
    }

    public long getTotaldeMovimentacao() {
        return totaldeMovimentacao;
    }

    public void setTotaldeMovimentacao(long totaldeMovimentacao) {
        this.totaldeMovimentacao = totaldeMovimentacao;
    }
}
