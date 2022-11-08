package br.com.model;

/**
 * Created by lucas on 03/08/17.
 */

public class SolicitacaoPaciente {

    private int idSolicitacaoPacApp;
    private String cpfPacienteSolicitacaoPacApp;
    private String dataSolicitacaoPacApp;
    private String horaSolicitacaoPacApp;
    private String necessidadeAcompanhanteSolicitacaoPacApp;



    public SolicitacaoPaciente(){

    }



    public SolicitacaoPaciente(int idSolicitacaoPacApp, String cpfPacienteSolicitacaoPacApp, String dataSolicitacaoPacApp,
                               String horaSolicitacaoPacApp, String necessidadeAcompanhanteSolicitacaoPacApp) {
        super();
        this.idSolicitacaoPacApp = idSolicitacaoPacApp;
        this.cpfPacienteSolicitacaoPacApp = cpfPacienteSolicitacaoPacApp;
        this.dataSolicitacaoPacApp = dataSolicitacaoPacApp;
        this.horaSolicitacaoPacApp = horaSolicitacaoPacApp;
        this.necessidadeAcompanhanteSolicitacaoPacApp = necessidadeAcompanhanteSolicitacaoPacApp;
    }



    public int getIdSolicitacaoPacApp() {
        return idSolicitacaoPacApp;
    }



    public void setIdSolicitacaoPacApp(int idSolicitacaoPacApp) {
        this.idSolicitacaoPacApp = idSolicitacaoPacApp;
    }



    public String getCpfPacienteSolicitacaoPacApp() {
        return cpfPacienteSolicitacaoPacApp;
    }



    public void setCpfPacienteSolicitacaoPacApp(String cpfPacienteSolicitacaoPacApp) {
        this.cpfPacienteSolicitacaoPacApp = cpfPacienteSolicitacaoPacApp;
    }



    public String getDataSolicitacaoPacApp() {
        return dataSolicitacaoPacApp;
    }



    public void setDataSolicitacaoPacApp(String dataSolicitacaoPacApp) {
        this.dataSolicitacaoPacApp = dataSolicitacaoPacApp;
    }



    public String getHoraSolicitacaoPacApp() {
        return horaSolicitacaoPacApp;
    }



    public void setHoraSolicitacaoPacApp(String horaSolicitacaoPacApp) {
        this.horaSolicitacaoPacApp = horaSolicitacaoPacApp;
    }



    public String getNecessidadeAcompanhanteSolicitacaoPacApp() {
        return necessidadeAcompanhanteSolicitacaoPacApp;
    }



    public void setNecessidadeAcompanhanteSolicitacaoPacApp(String necessidadeAcompanhanteSolicitacaoPacApp) {
        this.necessidadeAcompanhanteSolicitacaoPacApp = necessidadeAcompanhanteSolicitacaoPacApp;
    }


    @Override
    public String toString() {
        return "SolicitacaoPaciente{" +
                "idSolicitacaoPacApp=" + idSolicitacaoPacApp +
                ", cpfPacienteSolicitacaoPacApp=" + cpfPacienteSolicitacaoPacApp +
                ", dataSolicitacaoPacApp='" + dataSolicitacaoPacApp + '\'' +
                ", horaSolicitacaoPacApp='" + horaSolicitacaoPacApp + '\'' +
                ", necessidadeAcompanhanteSolicitacaoPacApp='" + necessidadeAcompanhanteSolicitacaoPacApp + '\'' +
                '}';
    }
}