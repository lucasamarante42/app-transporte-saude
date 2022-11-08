package br.com.dao;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import br.com.model.OuvidoriaPaciente;

/**
 * Created by lucas on 07/07/17.
 */

public class OuvidoriaPacienteDAO {


    //192.168.0.106 ; Renato=192.168.0.22
    //private static final String URL = "http://192.168.0.103:8080/WsAppSglps/services/OuvidoriaPacienteDAO?wsdl";
    private static final String URL = "http://transportesmandela.com.br/WsAppSglps/services/OuvidoriaPacienteDAO?wsdl";
    private static final String NAMESPACE = "http://dao.webservice.com.br";


    private static final String INSERIRouvidoria = "cadastrarOuvidoria";
   /* private static final String EXCLUIR = "excluirUsuario";
    private static final String ATUALIZAR = "atualizarUsuario";
    private static final String BUSCAR_TODOS = "buscarTodosUsuarios";
    private static final String BUSCAR_POR_ID = "buscarUsuarioPorID";*/


    public boolean cadastrarOuvidoria(OuvidoriaPaciente ouvidoriapaciente){

        // nos metodos do SOAP-UI

        // Estrutura para enviar para o metodo inserirUsuario
        // criando objeto SoapObject
        SoapObject cadastrarOuvidoria = new SoapObject(NAMESPACE,INSERIRouvidoria);


        // objeto que representa o usuario
        SoapObject usr = new SoapObject(NAMESPACE,"ouvidoriapaciente");

        usr.addProperty("idOuvidoriaPac",ouvidoriapaciente.getIdOuvidoriaPac());
        usr.addProperty("cpfPacienteOuvidoriaPac",ouvidoriapaciente.getCpfPacienteOuvidoriaPac());
        usr.addProperty("dataOuvidoriaPac",ouvidoriapaciente.getDataOuvidoriaPac());
        usr.addProperty("tipoOuvidoriaPac",ouvidoriapaciente.getTipoOuvidoriaPac());
        usr.addProperty("descricaoOuvidoriaPac",ouvidoriapaciente.getDescricaoOuvidoriaPac());


        //adicionando o usuario dentro do objeto soap
        cadastrarOuvidoria.addSoapObject(usr);


        // criando envelope com a estrutura para enviar webservice
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        // adicionar o metodo de inserção
        envelope.setOutputSoapObject(cadastrarOuvidoria);

        // habilitar a flag implicitTypes para funcionar o envio do objeto
        envelope.implicitTypes = true;

        // envia para o web service o envelope usando a URL
        HttpTransportSE http = new HttpTransportSE(URL);


        try{
            // passando a ação
            http.call("urn:"+ INSERIRouvidoria, envelope);

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