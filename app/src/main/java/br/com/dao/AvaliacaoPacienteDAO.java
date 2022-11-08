package br.com.dao;


import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import br.com.model.AvaliacaoPaciente;

/**
 * Created by lucas on 03/08/17.
 */

public class AvaliacaoPacienteDAO {


    //192.168.0.103 ; Renato=192.168.0.22
    //private static final String URL = "http://192.168.0.103:8080/WsAppSglps/services/AvaliacaoPacienteDAO?wsdl";
    private static final String URL = "http://transportesmandela.com.br/WsAppSglps/services/AvaliacaoPacienteDAO?wsdl";
    private static final String NAMESPACE = "http://dao.webservice.com.br";


    private static final String INSERIRavaliacao = "cadastrarAvaliacao";
    /*private static final String EXCLUIR = "excluirUsuario";
    private static final String ATUALIZAR = "atualizarUsuario";
    private static final String BUSCAR_TODOS = "buscarTodosUsuarios";
    private static final String BUSCAR_POR_ID = "buscarUsuarioPorID";*/


    public boolean cadastrarAvaliacao(AvaliacaoPaciente avaliacaopaciente){

        // nos metodos do SOAP-UI

        // Estrutura para enviar para o metodo inserirUsuario
        // criando objeto SoapObject
        SoapObject cadastrarAvaliacao = new SoapObject(NAMESPACE,INSERIRavaliacao);


        // objeto que representa o usuario
        SoapObject usr = new SoapObject(NAMESPACE,"avaliacaopaciente");

        usr.addProperty("idAvaliacaoPac",avaliacaopaciente.getIdAvaliacaoPac());
        usr.addProperty("cpfPacienteAvaliacaoPac",avaliacaopaciente.getCpfPacienteAvaliacaoPac());
        usr.addProperty("dataAvaliacaoPac",avaliacaopaciente.getDataAvaliacaoPac());
        usr.addProperty("avaliacaoAvaliacaoPac",avaliacaopaciente.getAvaliacaoAvaliacaoPac());
        usr.addProperty("mensagemAvaliacaoPac",avaliacaopaciente.getMensagemAvaliacaoPac());


        //adicionando o usuario dentro do objeto soap
        cadastrarAvaliacao.addSoapObject(usr);


        // criando envelope com a estrutura para enviar webservice
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        // adicionar o metodo de inserção
        envelope.setOutputSoapObject(cadastrarAvaliacao);

        // habilitar a flag implicitTypes para funcionar o envio do objeto
        envelope.implicitTypes = true;

        // envia para o web service o envelope usando a URL
        HttpTransportSE http = new HttpTransportSE(URL);


        try{
            // passando a ação
            http.call("urn:"+ INSERIRavaliacao, envelope);

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