package br.com.model;

/**
 * Created by lucas on 06/08/17.
 */

public class ControleKm {

    private int idControleKm;
    private String cpfMotoristaControleKm;
    private String dataControleKm;
    private String kmSaida;
    private String kmHoraSaida;
    private String kmChegada;
    private String kmHoraChegada;


    public ControleKm(){

    }


    public ControleKm(int idControleKm, String cpfMotoristaControleKm, String dataControleKm, String kmSaida,
                      String kmHoraSaida, String kmChegada, String kmHoraChegada) {
        super();
        this.idControleKm = idControleKm;
        this.cpfMotoristaControleKm = cpfMotoristaControleKm;
        this.dataControleKm = dataControleKm;
        this.kmSaida = kmSaida;
        this.kmHoraSaida = kmHoraSaida;
        this.kmChegada = kmChegada;
        this.kmHoraChegada = kmHoraChegada;
    }


    public int getIdControleKm() {
        return idControleKm;
    }

    public void setIdControleKm(int idControleKm) {
        this.idControleKm = idControleKm;
    }

    public String getCpfMotoristaControleKm() {
        return cpfMotoristaControleKm;
    }

    public void setCpfMotoristaControleKm(String cpfMotoristaControleKm) {
        this.cpfMotoristaControleKm = cpfMotoristaControleKm;
    }

    public String getDataControleKm() {
        return dataControleKm;
    }

    public void setDataControleKm(String dataControleKm) {
        this.dataControleKm = dataControleKm;
    }

    public String getKmSaida() {
        return kmSaida;
    }

    public void setKmSaida(String kmSaida) {
        this.kmSaida = kmSaida;
    }

    public String getKmHoraSaida() {
        return kmHoraSaida;
    }

    public void setKmHoraSaida(String kmHoraSaida) {
        this.kmHoraSaida = kmHoraSaida;
    }

    public String getKmChegada() {
        return kmChegada;
    }

    public void setKmChegada(String kmChegada) {
        this.kmChegada = kmChegada;
    }

    public String getKmHoraChegada() {
        return kmHoraChegada;
    }

    public void setKmHoraChegada(String kmHoraChegada) {
        this.kmHoraChegada = kmHoraChegada;
    }


    @Override
    public String toString() {
        return "ControleKm{" +
                "idControleKm=" + idControleKm +
                ", cpfMotoristaControleKm='" + cpfMotoristaControleKm + '\'' +
                ", dataControleKm='" + dataControleKm + '\'' +
                ", kmSaida='" + kmSaida + '\'' +
                ", kmHoraSaida='" + kmHoraSaida + '\'' +
                ", kmChegada='" + kmChegada + '\'' +
                ", kmHoraChegada='" + kmHoraChegada + '\'' +
                '}';
    }


}
