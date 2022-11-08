package br.com.dao;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import br.com.model.SolicitacaoPaciente;

/**
 * Created by lucas on 03/07/17.
 */

public class SolicitacaoPacienteDAO {



    //192.168.0.106 ; Renato=192.168.0.22
    // private static final String URL = "http://192.168.0.103:8080/WsAppSglps/services/SolicitacaoPacienteDAO?wsdl";
    private static final String URL = "http://transportesmandela.com.br/WsAppSglps/services/SolicitacaoPacienteDAO?wsdl";
    private static final String NAMESPACE = "http://dao.webservice.com.br";


    private static final String INSERIRsolicitacao = "cadastrarSolicitacao";
    /*private static final String EXCLUIR = "excluirUsuario";
    private static final String ATUALIZAR = "atualizarUsuario";
    private static final String BUSCAR_TODOS = "buscarTodosUsuarios";
    private static final String BUSCAR_POR_ID = "buscarUsuarioPorID";*/


    public boolean cadastrarSolicitacao(SolicitacaoPaciente solicitacaopaciente){

        // nos metodos do SOAP-UI

        // Estrutura para enviar para o metodo inserirUsuario
        // criando objeto SoapObject
        SoapObject cadastrarSolicitacao = new SoapObject(NAMESPACE,INSERIRsolicitacao);


        // objeto que representa o usuario
        SoapObject usr = new SoapObject(NAMESPACE,"solicitacaopaciente");

        usr.addProperty("idSolicitacaoPacApp",solicitacaopaciente.getIdSolicitacaoPacApp());
        usr.addProperty("cpfPacienteSolicitacaoPacApp",solicitacaopaciente.getCpfPacienteSolicitacaoPacApp());
        usr.addProperty("dataSolicitacaoPacApp",solicitacaopaciente.getDataSolicitacaoPacApp());
        usr.addProperty("horaSolicitacaoPacApp",solicitacaopaciente.getHoraSolicitacaoPacApp());
        usr.addProperty("necessidadeAcompanhanteSolicitacaoPacApp",solicitacaopaciente.getNecessidadeAcompanhanteSolicitacaoPacApp());


        //adicionando o usuario dentro do objeto soap
        cadastrarSolicitacao.addSoapObject(usr);


        // criando envelope com a estrutura para enviar webservice
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        // adicionar o metodo de inserção
        envelope.setOutputSoapObject(cadastrarSolicitacao);

        // habilitar a flag implicitTypes para funcionar o envio do objeto
        envelope.implicitTypes = true;

        // envia para o web service o envelope usando a URL
        HttpTransportSE http = new HttpTransportSE(URL);


        try{
            // passando a ação
            http.call("urn:"+ INSERIRsolicitacao, envelope);

            // retorno do web service em true or false
            // colocando a resposta no objeto SoapPrimitive
            SoapPrimitive resposta = (SoapPrimitive) envelope.getResponse();

            return Boolean.parseBoolean(resposta.toString());


        } catch (HttpResponseException e) {
            e.printStackTrace();
            return false;

        } catch (IOException e) {
            e.printStackTrace();
            return false;

        } catch (XmlPullParserException e) {
            e.printStackTrace();
            return false;
        }


    }















}