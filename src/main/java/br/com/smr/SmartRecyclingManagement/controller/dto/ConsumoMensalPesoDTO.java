package br.com.smr.SmartRecyclingManagement.controller.dto;

public class ConsumoMensalPesoDTO {


    private Double pesoPlastico;
    private Double pesoPapel;
    private Double pesoVidro;
    private Double pesoMetal;
    private Double pesoOrganico;
    private Double pesoNaoReciclavel;
    private Double pesoTotal;
    private Double pesoTotalMensalEmbalagem;
    private Double pesoTotalMensalLiquido;

    public ConsumoMensalPesoDTO(Double pesoPlastico, Double pesoPapel, Double pesoVidro, Double pesoMetal, Double pesoOrganico, Double pesoNaoReciclavel, Double pesoTotal, Double pesoTotalMensalEmbalagem, Double pesoTotalMensalLiquido) {
        this.pesoPlastico = pesoPlastico;
        this.pesoPapel = pesoPapel;
        this.pesoVidro = pesoVidro;
        this.pesoMetal = pesoMetal;
        this.pesoOrganico = pesoOrganico;
        this.pesoNaoReciclavel = pesoNaoReciclavel;
        this.pesoTotal = pesoTotal;
        this.pesoTotalMensalEmbalagem = pesoTotalMensalEmbalagem;
        this.pesoTotalMensalLiquido = pesoTotalMensalLiquido;
    }

    public ConsumoMensalPesoDTO() {
    }

    public Double getPesoPlastico() {
        return pesoPlastico;
    }

    public void setPesoPlastico(Double pesoPlastico) {
        this.pesoPlastico = pesoPlastico;
    }

    public Double getPesoPapel() {
        return pesoPapel;
    }

    public void setPesoPapel(Double pesoPapel) {
        this.pesoPapel = pesoPapel;
    }

    public Double getPesoVidro() {
        return pesoVidro;
    }

    public void setPesoVidro(Double pesoVidro) {
        this.pesoVidro = pesoVidro;
    }

    public Double getPesoMetal() {
        return pesoMetal;
    }

    public void setPesoMetal(Double pesoMetal) {
        this.pesoMetal = pesoMetal;
    }

    public Double getPesoOrganico() {
        return pesoOrganico;
    }

    public void setPesoOrganico(Double pesoOrganico) {
        this.pesoOrganico = pesoOrganico;
    }

    public Double getPesoNaoReciclavel() {
        return pesoNaoReciclavel;
    }

    public void setPesoNaoReciclavel(Double pesoNaoReciclavel) {
        this.pesoNaoReciclavel = pesoNaoReciclavel;
    }

    public Double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(Double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public Double getPesoTotalMensalEmbalagem() {
        return pesoTotalMensalEmbalagem;
    }

    public void setPesoTotalMensalEmbalagem(Double pesoTotalMensalEmbalagem) {
        this.pesoTotalMensalEmbalagem = pesoTotalMensalEmbalagem;
    }

    public Double getPesoTotalMensalLiquido() {
        return pesoTotalMensalLiquido;
    }

    public void setPesoTotalMensalLiquido(Double pesoTotalMensalLiquido) {
        this.pesoTotalMensalLiquido = pesoTotalMensalLiquido;
    }

    @Override
    public String toString() {
        return "ConsumoMensalPesoDTO{" +
                "pesoPlastico=" + pesoPlastico +
                ", pesoPapel=" + pesoPapel +
                ", pesoVidro=" + pesoVidro +
                ", pesoMetal=" + pesoMetal +
                ", pesoOrganico=" + pesoOrganico +
                ", pesoNaoReciclavel=" + pesoNaoReciclavel +
                ", pesoTotal=" + pesoTotal +
                ", pesoTotalMensalEmbalagem=" + pesoTotalMensalEmbalagem +
                ", pesoTotalMensalLiquido=" + pesoTotalMensalLiquido +
                '}';
    }
}
