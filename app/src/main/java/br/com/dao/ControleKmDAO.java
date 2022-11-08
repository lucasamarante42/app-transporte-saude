package br.com.dao;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpResponseException;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import br.com.model.ControleKm;



/**
 * Created by lucas on 06/08/17.
 */

public class ControleKmDAO {


    private static final String URL = "http://transportesmandela.com.br/WsAppSglps/services/ControleKmDAO?wsdl";
    private static final String NAMESPACE = "http://dao.webservice.com.br";


    private static final String INSERIRcontrole = "cadastrarControleKm";


    public boolean cadastrarControle(ControleKm controlekm) {

        // nos metodos do SOAP-UI

        // Estrutura para enviar para o metodo inserirControle
        // criando objeto SoapObject
        SoapObject cadastrarControle = new SoapObject(NAMESPACE, INSERIRcontrole);


        // objeto que representa o usuario
        SoapObject usr = new SoapObject(NAMESPACE, "controlekm");

        usr.addProperty("idControleKm", controlekm.getIdControleKm());
        usr.addProperty("cpfMotoristaControleKm", controlekm.getCpfMotoristaControleKm());
        usr.addProperty("dataControleKm", controlekm.getDataControleKm());
        usr.addProperty("kmSaida", controlekm.getKmSaida());
        usr.addProperty("kmHoraSaida", controlekm.getKmHoraSaida());
        usr.addProperty("kmChegada", controlekm.getKmChegada());
        usr.addProperty("kmHoraChegada" , controlekm.getKmHoraChegada());



        //adicionando o usuario dentro do objeto soap
        cadastrarControle.addSoapObject(usr);

        // criando envelope com a estrutura para enviar webservice
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        // adicionar o metodo de inserção
        envelope.setOutputSoapObject(cadastrarControle);

        // habilitar a flag implicitTypes para funcionar o envio do objeto
        envelope.implicitTypes = true;

        // envia para o web service o envelope usando a URL
        HttpTransportSE http = new HttpTransportSE(URL);


        try{
            // passando a ação
            http.call("urn:"+ INSERIRcontrole, envelope);

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
