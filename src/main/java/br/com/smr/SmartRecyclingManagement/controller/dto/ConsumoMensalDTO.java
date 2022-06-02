package br.com.smr.SmartRecyclingManagement.controller.dto;

import br.com.smr.SmartRecyclingManagement.domain.TipoReciclagem;

public class ConsumoMensalDTO {

    private Double plastico;
    private Double papel;
    private Double vidro;
    private Double metal;
    private Double organico;
    private Double naoReciclavel;
    private Double gastoMensal;

    public ConsumoMensalDTO(Double plastico, Double papel, Double vidro, Double metal, Double organico, Double naoReciclavel, Double gastoMensal) {
        this.plastico = plastico;
        this.papel = papel;
        this.vidro = vidro;
        this.metal = metal;
        this.organico = organico;
        this.naoReciclavel = naoReciclavel;
        this.gastoMensal = gastoMensal;
    }

    public ConsumoMensalDTO() {
    }

    public Double getPlastico() {
        return plastico;
    }

    public void setPlastico(Double plastico) {
        this.plastico = plastico;
    }

    public Double getPapel() {
        return papel;
    }

    public void setPapel(Double papel) {
        this.papel = papel;
    }

    public Double getVidro() {
        return vidro;
    }

    public void setVidro(Double vidro) {
        this.vidro = vidro;
    }

    public Double getMetal() {
        return metal;
    }

    public void setMetal(Double metal) {
        this.metal = metal;
    }

    public Double getOrganico() {
        return organico;
    }

    public void setOrganico(Double organico) {
        this.organico = organico;
    }

    public Double getNaoReciclavel() {
        return naoReciclavel;
    }

    public void setNaoReciclavel(Double naoReciclavel) {
        this.naoReciclavel = naoReciclavel;
    }

    public Double getGastoMensal() {
        return gastoMensal;
    }

    public void setGastoMensal(Double gastoMensal) {
        this.gastoMensal = gastoMensal;
    }

    @Override
    public String toString() {
        return "ConsumoMensalDTO{" +
                "plastico=" + plastico +
                ", papel=" + papel +
                ", vidro=" + vidro +
                ", metal=" + metal +
                ", organico=" + organico +
                ", naoReciclavel=" + naoReciclavel +
                ", gastoMensal=" + gastoMensal +
                '}';
    }
}
