package br.com.apptransportessaudecrz;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.dao.SolicitacaoPacienteDAO;
import br.com.model.SolicitacaoPaciente;


public class SolicitacaoActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText edCpf;

    private String stCpf, DataPartidaF, HoraPartidaF;

    private Spinner spnDia, spnMes, spnAno, spnHora, spnMinuto;

    private List<String> lstDia = new ArrayList<String>();
    private List<String> lstMes = new ArrayList<String>();
    private List<String> lstAno = new ArrayList<String>();

    private List<String> lstHora = new ArrayList<String>();
    private List<String> lstMinuto = new ArrayList<String>();

    private String[] selecDia = new String[1];
    private String[] selecMes = new String[1];
    private String[] selecAno = new String[1];

    private String[] selecHora = new String[1];
    private String[] selecMinuto = new String[1];

    private StringBuilder stbDataPartida, stbHoraPartida;

    private ImageButton btnEnviarSolicitacao;

    private CheckBox cbSalvarCpf;
    private CheckBox cbAcompanhante;
    private CheckBox cbResponsavel;

    private boolean checkCpf, checkAcomp, checkResponsavel;

    private String marcaCpf, marcaAcomp;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static final String PREF_NAME = "ActivityPreferences";

    private String resultSHPcpf;

    final int number = 0;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitacao);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        edCpf = (EditText) findViewById(R.id.edCpf);


        cbSalvarCpf = (CheckBox) findViewById(R.id.cbSalvarCpf);


        cbAcompanhante = (CheckBox) findViewById(R.id.cbAcompanhante);

        cbResponsavel = (CheckBox) findViewById(R.id.cbResponsavel);

        btnEnviarSolicitacao = (ImageButton) findViewById(R.id.btnEnviarSolicitacao);
        btnEnviarSolicitacao.setOnClickListener(this);


        lstDia.add("DIA");
        lstDia.add("01");
        lstDia.add("02");
        lstDia.add("03");
        lstDia.add("04");
        lstDia.add("05");
        lstDia.add("06");
        lstDia.add("07");
        lstDia.add("08");
        lstDia.add("09");
        lstDia.add("10");
        lstDia.add("11");
        lstDia.add("12");
        lstDia.add("13");
        lstDia.add("14");
        lstDia.add("15");
        lstDia.add("16");
        lstDia.add("17");
        lstDia.add("18");
        lstDia.add("19");
        lstDia.add("20");
        lstDia.add("21");
        lstDia.add("22");
        lstDia.add("23");
        lstDia.add("24");
        lstDia.add("25");
        lstDia.add("26");
        lstDia.add("27");
        lstDia.add("28");
        lstDia.add("29");
        lstDia.add("30");
        lstDia.add("31");


        ArrayAdapter adapterDia = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lstDia);

        spnDia = (Spinner) findViewById(R.id.spDia);
        spnDia.setAdapter(adapterDia);


        spnDia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parentD, View viewD, int posD, long idD) {

                selecDia[0] = parentD.getItemAtPosition(posD).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });
        /******************************************************************************/


        lstMes.add("MÊS");
        lstMes.add("01");
        lstMes.add("02");
        lstMes.add("03");
        lstMes.add("04");
        lstMes.add("05");
        lstMes.add("06");
        lstMes.add("07");
        lstMes.add("08");
        lstMes.add("09");
        lstMes.add("10");
        lstMes.add("11");
        lstMes.add("12");


        ArrayAdapter adapterMes = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lstMes);

        spnMes = (Spinner) findViewById(R.id.spMes);
        spnMes.setAdapter(adapterMes);


        spnMes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parentMS, View viewMS, int posMS, long idMS) {

                selecMes[0] = parentMS.getItemAtPosition(posMS).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });
        /******************************************************************************/


        lstAno.add("ANO");
        lstAno.add("2017");
        lstAno.add("2018");
        lstAno.add("2019");
        lstAno.add("2020");

        ArrayAdapter adapterAno = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lstAno);

        spnAno = (Spinner) findViewById(R.id.spAno);
        spnAno.setAdapter(adapterAno);


        spnAno.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parentA, View viewA, int posA, long idA) {

                selecAno[0] = parentA.getItemAtPosition(posA).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });
        /******************************************************************************/


        lstHora.add("HORA");
        lstHora.add("00");
        lstHora.add("01");
        lstHora.add("02");
        lstHora.add("03");
        lstHora.add("04");
        lstHora.add("05");
        lstHora.add("06");
        lstHora.add("07");
        lstHora.add("08");
        lstHora.add("09");
        lstHora.add("10");
        lstHora.add("11");
        lstHora.add("12");
        lstHora.add("13");
        lstHora.add("14");
        lstHora.add("15");
        lstHora.add("16");
        lstHora.add("17");
        lstHora.add("18");
        lstHora.add("19");
        lstHora.add("20");
        lstHora.add("21");
        lstHora.add("22");
        lstHora.add("23");


        ArrayAdapter adapterHora = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lstHora);

        spnHora = (Spinner) findViewById(R.id.spHora);
        spnHora.setAdapter(adapterHora);


        spnHora.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parentH, View view, int pos, long id) {

                selecHora[0] = parentH.getItemAtPosition(pos).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });

        /******************************************************************************/

        lstMinuto.add("MINUTO");
        lstMinuto.add("00");
        lstMinuto.add("15");
        lstMinuto.add("30");
        lstMinuto.add("45");


        ArrayAdapter adapterMinuto = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lstMinuto);

        spnMinuto = (Spinner) findViewById(R.id.spMinuto);
        spnMinuto.setAdapter(adapterMinuto);


        spnMinuto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parentM, View viewM, int posM, long idM) {

                selecMinuto[0] = parentM.getItemAtPosition(posM).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });


        /********************************************************************************/

        //edDia.setFilters(new InputFilter[]{ new InputFilterMinMaxTwoDig("1", "31")});
        //edMes.setFilters(new InputFilter[]{ new InputFilterMinMaxTwoDig("1", "12")});


        /********************************************************************************/


        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        resultSHPcpf = sharedPreferences.getString("sp_cpfSalvo", "");
        if (!TextUtils.isEmpty(resultSHPcpf)) {
            edCpf.setText(resultSHPcpf);
        }


    } //finish onCreate


    /*************************************************************************************************/


    //Log.i("AsyncTask", "Elementos de tela criados e atribuidos Thread: " + Thread.currentThread().getName());
    @Override
    public void onClick(View arg0) {

        //Log.i("AsyncTask", "Botão Clicado Thread: " + Thread.currentThread().getName());


        stCpf = edCpf.getText().toString().trim();


        //check campos nulos
        if (TextUtils.isEmpty(stCpf) || selecDia[0].equals("DIA") || selecMes[0].equals("MÊS") ||
                selecAno[0].equals("ANO") || selecHora[0].equals("HORA") ||
                selecMinuto[0].equals("MINUTO")) {

            Toast.makeText(SolicitacaoActivity.this, "Por favor! Preencha os campos corretamente.",
                    Toast.LENGTH_LONG).show();

        } else {

            checkCpf = cbSalvarCpf.isChecked();
            checkAcomp = cbAcompanhante.isChecked();
            checkResponsavel = cbResponsavel.isChecked();

            if (checkResponsavel) {

                if (checkCpf) {
                    marcaCpf = "Sim";

                    sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
                    editor = sharedPreferences.edit();
                    editor.putString("sp_cpfSalvo", edCpf.getText().toString());
                    editor.apply();
                }

                if (checkAcomp) {
                    marcaAcomp = "Sim";
                } else {
                    marcaAcomp = "Não";
                }


                //append
                stbDataPartida = new StringBuilder();

                stbDataPartida.append(selecAno[0]);
                stbDataPartida.append("-");
                stbDataPartida.append(selecMes[0]);
                stbDataPartida.append("-");
                stbDataPartida.append(selecDia[0]);


                DataPartidaF = stbDataPartida.toString();


                //Log.d("Data final da Partida", DataPartidaF);


                stbHoraPartida = new StringBuilder();

                stbHoraPartida.append(selecHora[0]);
                stbHoraPartida.append(":");
                stbHoraPartida.append(selecMinuto[0]);

                HoraPartidaF = stbHoraPartida.toString();
                //Log.d("Hora final da Partida", HoraPartidaF);

                solicitacaoAsyncTask(number, stCpf,
                        DataPartidaF,
                        HoraPartidaF,
                        marcaAcomp);
            } else {

                Toast.makeText(SolicitacaoActivity.this, "Por favor. Clique na caixa de confirmação!", Toast.LENGTH_LONG).show();
            }
        }


    } // finish onClick


//***************************************************************************************************//

    protected void solicitacaoAsyncTask(Integer at_id, String at_cpf,
                                        String at_datapartida, String at_horapartida,
                                        String at_marcaacomp) {

        //executando AsyncTask
        AddUserTask utask = new AddUserTask();
        utask.execute(at_id, at_cpf, at_datapartida, at_horapartida, at_marcaacomp);

        //Log.i("chama async",at_horapartida);
        //Log.i("AsyncTask", "AsyncTask senado chamado Thread: " + Thread.currentThread().getName());
    }

//***************************************************************************************************//

    // classe AsyncTask (gerenciador de threads)
    private class AddUserTask extends AsyncTask<Object, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Object... params) {

            Boolean resultado = null;

            Integer in_id = (Integer) params[0];
            String in_cpf = (String) params[1];
            String in_datapartida = (String) params[2];
            String in_horapartida = (String) params[3];
            String in_marcaacomp = (String) params[4];

            //Log.i("AsyncTask", "Executando insercion Thread: " + Thread.currentThread().getName());

            SolicitacaoPacienteDAO solicitacaopaciente = new SolicitacaoPacienteDAO();

            resultado = solicitacaopaciente.cadastrarSolicitacao(new SolicitacaoPaciente(in_id, in_cpf,
                    in_datapartida, in_horapartida, in_marcaacomp));


            return resultado;

        }

        @Override
        protected void onPostExecute(Boolean fresult) {

            //Log.i("O resultado", String.valueOf(fresult));

            if (fresult) {
                //Log.i("AsyncTask", "Exibindo Bitmap Thread: " + Thread.currentThread().getName());
                Toast.makeText(SolicitacaoActivity.this, "Sua solicitação foi enviada com sucesso!", Toast.LENGTH_LONG).show();
                finish();


            } else {
                //Log.i("AsyncTask", "Erro ao baixar a imagem " + Thread.currentThread().getName());
                Toast.makeText(SolicitacaoActivity.this, "Desculpe, erro ao enviar... Tente mais tarde!", Toast.LENGTH_LONG).show();
            }
        }
    }


}



