package br.com.model;

/**
 * Created by lucas on 03/08/17.
 */

public class AvaliacaoPaciente {

    private int idAvaliacaoPac;
    private String cpfPacienteAvaliacaoPac;
    private String dataAvaliacaoPac;
    private String avaliacaoAvaliacaoPac;
    private String mensagemAvaliacaoPac;



    public AvaliacaoPaciente(){

    }



    public AvaliacaoPaciente(int idAvaliacaoPac, String cpfPacienteAvaliacaoPac, String dataAvaliacaoPac,
                             String avaliacaoAvaliacaoPac, String mensagemAvaliacaoPac) {
        super();
        this.idAvaliacaoPac = idAvaliacaoPac;
        this.cpfPacienteAvaliacaoPac = cpfPacienteAvaliacaoPac;
        this.dataAvaliacaoPac = dataAvaliacaoPac;
        this.avaliacaoAvaliacaoPac = avaliacaoAvaliacaoPac;
        this.mensagemAvaliacaoPac = mensagemAvaliacaoPac;
    }



    public int getIdAvaliacaoPac() {
        return idAvaliacaoPac;
    }



    public void setIdAvaliacaoPac(int idAvaliacaoPac) {
        this.idAvaliacaoPac = idAvaliacaoPac;
    }



    public String getCpfPacienteAvaliacaoPac() {
        return cpfPacienteAvaliacaoPac;
    }



    public void setCpfPacienteAvaliacaoPac(String cpfPacienteAvaliacaoPac) {
        this.cpfPacienteAvaliacaoPac = cpfPacienteAvaliacaoPac;
    }



    public String getDataAvaliacaoPac() {
        return dataAvaliacaoPac;
    }



    public void setDataAvaliacaoPac(String dataAvaliacaoPac) {
        this.dataAvaliacaoPac = dataAvaliacaoPac;
    }



    public String getAvaliacaoAvaliacaoPac() {
        return avaliacaoAvaliacaoPac;
    }



    public void setAvaliacaoAvaliacaoPac(String avaliacaoAvaliacaoPac) {
        this.avaliacaoAvaliacaoPac = avaliacaoAvaliacaoPac;
    }



    public String getMensagemAvaliacaoPac() {
        return mensagemAvaliacaoPac;
    }



    public void setMensagemAvaliacaoPac(String mensagemAvaliacaoPac) {
        this.mensagemAvaliacaoPac = mensagemAvaliacaoPac;
    }


    @Override
    public String toString() {
        return "AvaliacaoPaciente{" +
                "idAvaliacaoPac=" + idAvaliacaoPac +
                ", cpfPacienteAvaliacaoPac=" + cpfPacienteAvaliacaoPac +
                ", dataAvaliacaoPac='" + dataAvaliacaoPac + '\'' +
                ", avaliacaoAvaliacaoPac='" + avaliacaoAvaliacaoPac + '\'' +
                ", mensagemAvaliacaoPac='" + mensagemAvaliacaoPac + '\'' +
                '}';
    }
}