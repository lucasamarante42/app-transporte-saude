package br.com.model;

/**
 * Created by lucas on 03/08/17.
 */

public class OuvidoriaPaciente {

    private int idOuvidoriaPac;
    private String cpfPacienteOuvidoriaPac;
    private String dataOuvidoriaPac;
    private String tipoOuvidoriaPac;
    private String descricaoOuvidoriaPac;


    public OuvidoriaPaciente(){

    }


    public OuvidoriaPaciente(int idOuvidoriaPac, String cpfPacienteOuvidoriaPac, String dataOuvidoriaPac,
                             String tipoOuvidoriaPac, String descricaoOuvidoriaPac) {
        super();
        this.idOuvidoriaPac = idOuvidoriaPac;
        this.cpfPacienteOuvidoriaPac = cpfPacienteOuvidoriaPac;
        this.dataOuvidoriaPac = dataOuvidoriaPac;
        this.tipoOuvidoriaPac = tipoOuvidoriaPac;
        this.descricaoOuvidoriaPac = descricaoOuvidoriaPac;
    }


    public int getIdOuvidoriaPac() {
        return idOuvidoriaPac;
    }

    public void setIdOuvidoriaPac(int idOuvidoriaPac) {
        this.idOuvidoriaPac = idOuvidoriaPac;
    }

    public String getCpfPacienteOuvidoriaPac() {
        return cpfPacienteOuvidoriaPac;
    }

    public void setCpfPacienteOuvidoriaPac(String cpfPacienteOuvidoriaPac) {
        this.cpfPacienteOuvidoriaPac = cpfPacienteOuvidoriaPac;
    }

    public String getDataOuvidoriaPac() {
        return dataOuvidoriaPac;
    }

    public void setDataOuvidoriaPac(String dataOuvidoriaPac) {
        this.dataOuvidoriaPac = dataOuvidoriaPac;
    }

    public String getTipoOuvidoriaPac() {
        return tipoOuvidoriaPac;
    }

    public void setTipoOuvidoriaPac(String tipoOuvidoriaPac) {
        this.tipoOuvidoriaPac = tipoOuvidoriaPac;
    }

    public String getDescricaoOuvidoriaPac() {
        return descricaoOuvidoriaPac;
    }

    public void setDescricaoOuvidoriaPac(String descricaoOuvidoriaPac) {
        this.descricaoOuvidoriaPac = descricaoOuvidoriaPac;
    }


    @Override
    public String toString() {
        return "OuvidoriaPaciente{" +
                "idOuvidoriaPac=" + idOuvidoriaPac +
                ", cpfPacienteOuvidoriaPac=" + cpfPacienteOuvidoriaPac +
                ", dataOuvidoriaPac='" + dataOuvidoriaPac + '\'' +
                ", tipoOuvidoriaPac='" + tipoOuvidoriaPac + '\'' +
                ", descricaoOuvidoriaPac='" + descricaoOuvidoriaPac + '\'' +
                '}';
    }


}