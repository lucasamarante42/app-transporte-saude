package br.com.apptransportessaudecrz;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
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

import br.com.dao.ControleKmDAO;
import br.com.model.ControleKm;


public class MotoristaActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edKmCpf, edKmSaida, edKmChegada;

    private String stKmCpf, stDataKm, stKmSaida, stKmChegada, stHoraSaida, stHoraChegada;

    private Spinner spnKmDia, spnKmMes, spnKmAno, spnKmHoraSaida, spnKmMinutoSaida,
                    spnKmHoraChegada, spnKmMinutoChegada;

    private List<String> lstKmDia = new ArrayList<String>();
    private List<String> lstKmMes = new ArrayList<String>();
    private List<String> lstKmAno = new ArrayList<String>();

    private List<String> lstKmHoraSaida = new ArrayList<String>();
    private List<String> lstKmMinutoSaida = new ArrayList<String>();

    private List<String> lstKmHoraChegada = new ArrayList<String>();
    private List<String> lstKmMinutoChegada = new ArrayList<String>();

    private String[] selecKmDia = new String[1];
    private String[] selecKmMes = new String[1];
    private String[] selecKmAno = new String[1];

    private String[] selecKmHoraSaida = new String[1];
    private String[] selecKmMinutoSaida = new String[1];

    private String[] selecKmHoraChegada = new String[1];
    private String[] selecKmMinutoChegada = new String[1];

    private StringBuilder stbKmData, stbKmHoraSaida, stbKmHoraChegada;

    private ImageButton btnKmEnviarSolicitacao;

    private CheckBox cbKmSalvarCpf;
    private CheckBox cbKmResponsavel;

    private boolean checkKmCpf, checkKmResponsavel;

    private String marcaKmCpf;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static final String PREF_NAME = "ActivityPreferences";

    private String resultSHPkmcpf;

    final int number = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motorista);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        edKmCpf = (EditText) findViewById(R.id.edCpfMotorista);
        edKmSaida = (EditText) findViewById(R.id.edKmSaida);
        edKmChegada = (EditText) findViewById(R.id.edKmChegada);

        cbKmSalvarCpf = (CheckBox) findViewById(R.id.cbSalvarCpfMotorista);

        cbKmResponsavel = (CheckBox) findViewById(R.id.cbResponsavelKm);

        btnKmEnviarSolicitacao = (ImageButton) findViewById(R.id.btnEnviarKm);
        btnKmEnviarSolicitacao.setOnClickListener(this);

        lstKmDia.add("DIA");
        lstKmDia.add("01");
        lstKmDia.add("02");
        lstKmDia.add("03");
        lstKmDia.add("04");
        lstKmDia.add("05");
        lstKmDia.add("06");
        lstKmDia.add("07");
        lstKmDia.add("08");
        lstKmDia.add("09");
        lstKmDia.add("10");
        lstKmDia.add("11");
        lstKmDia.add("12");
        lstKmDia.add("13");
        lstKmDia.add("14");
        lstKmDia.add("15");
        lstKmDia.add("16");
        lstKmDia.add("17");
        lstKmDia.add("18");
        lstKmDia.add("19");
        lstKmDia.add("20");
        lstKmDia.add("21");
        lstKmDia.add("22");
        lstKmDia.add("23");
        lstKmDia.add("24");
        lstKmDia.add("25");
        lstKmDia.add("26");
        lstKmDia.add("27");
        lstKmDia.add("28");
        lstKmDia.add("29");
        lstKmDia.add("30");
        lstKmDia.add("31");


        ArrayAdapter adapterDia = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lstKmDia);

        spnKmDia = (Spinner) findViewById(R.id.spDia);
        spnKmDia.setAdapter(adapterDia);


        spnKmDia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parentD, View viewD, int posD, long idD) {

                selecKmDia[0] = parentD.getItemAtPosition(posD).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });
        /******************************************************************************/


        lstKmMes.add("MÊS");
        lstKmMes.add("01");
        lstKmMes.add("02");
        lstKmMes.add("03");
        lstKmMes.add("04");
        lstKmMes.add("05");
        lstKmMes.add("06");
        lstKmMes.add("07");
        lstKmMes.add("08");
        lstKmMes.add("09");
        lstKmMes.add("10");
        lstKmMes.add("11");
        lstKmMes.add("12");


        ArrayAdapter adapterMes = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lstKmMes);

        spnKmMes = (Spinner) findViewById(R.id.spMes);
        spnKmMes.setAdapter(adapterMes);


        spnKmMes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parentMS, View viewMS, int posMS, long idMS) {

                selecKmMes[0] = parentMS.getItemAtPosition(posMS).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });
        /******************************************************************************/


        lstKmAno.add("ANO");
        lstKmAno.add("2017");
        lstKmAno.add("2018");
        lstKmAno.add("2019");
        lstKmAno.add("2020");

        ArrayAdapter adapterAno = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lstKmAno);

        spnKmAno = (Spinner) findViewById(R.id.spAno);
        spnKmAno.setAdapter(adapterAno);


        spnKmAno.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parentA, View viewA, int posA, long idA) {

                selecKmAno[0] = parentA.getItemAtPosition(posA).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });
        /******************************************************************************/

        lstKmHoraSaida.add("HORA");
        lstKmHoraSaida.add("00");
        lstKmHoraSaida.add("01");
        lstKmHoraSaida.add("02");
        lstKmHoraSaida.add("03");
        lstKmHoraSaida.add("04");
        lstKmHoraSaida.add("05");
        lstKmHoraSaida.add("06");
        lstKmHoraSaida.add("07");
        lstKmHoraSaida.add("08");
        lstKmHoraSaida.add("09");
        lstKmHoraSaida.add("10");
        lstKmHoraSaida.add("11");
        lstKmHoraSaida.add("12");
        lstKmHoraSaida.add("13");
        lstKmHoraSaida.add("14");
        lstKmHoraSaida.add("15");
        lstKmHoraSaida.add("16");
        lstKmHoraSaida.add("17");
        lstKmHoraSaida.add("18");
        lstKmHoraSaida.add("19");
        lstKmHoraSaida.add("20");
        lstKmHoraSaida.add("21");
        lstKmHoraSaida.add("22");
        lstKmHoraSaida.add("23");


        ArrayAdapter adapterHoraSaida = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lstKmHoraSaida);

        spnKmHoraSaida = (Spinner) findViewById(R.id.spHoraSaida);
        spnKmHoraSaida.setAdapter(adapterHoraSaida);


        spnKmHoraSaida.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parentHSA, View viewSA, int posSA, long idSA) {

                selecKmHoraSaida[0] = parentHSA.getItemAtPosition(posSA).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });

        /******************************************************************************/


        lstKmMinutoSaida.add("MINUTO");
        lstKmMinutoSaida.add("00");
        lstKmMinutoSaida.add("15");
        lstKmMinutoSaida.add("30");
        lstKmMinutoSaida.add("45");


        ArrayAdapter adapterMinutoSaida = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lstKmMinutoSaida);

        spnKmMinutoSaida = (Spinner) findViewById(R.id.spMinutoSaida);
        spnKmMinutoSaida.setAdapter(adapterMinutoSaida);


        spnKmMinutoSaida.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parentMSA, View viewMSA, int posMSA, long idMSA) {

                selecKmMinutoSaida[0] = parentMSA.getItemAtPosition(posMSA).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });


        /********************************************************************************/



        lstKmHoraChegada.add("HORA");
        lstKmHoraChegada.add("00");
        lstKmHoraChegada.add("01");
        lstKmHoraChegada.add("02");
        lstKmHoraChegada.add("03");
        lstKmHoraChegada.add("04");
        lstKmHoraChegada.add("05");
        lstKmHoraChegada.add("06");
        lstKmHoraChegada.add("07");
        lstKmHoraChegada.add("08");
        lstKmHoraChegada.add("09");
        lstKmHoraChegada.add("10");
        lstKmHoraChegada.add("11");
        lstKmHoraChegada.add("12");
        lstKmHoraChegada.add("13");
        lstKmHoraChegada.add("14");
        lstKmHoraChegada.add("15");
        lstKmHoraChegada.add("16");
        lstKmHoraChegada.add("17");
        lstKmHoraChegada.add("18");
        lstKmHoraChegada.add("19");
        lstKmHoraChegada.add("20");
        lstKmHoraChegada.add("21");
        lstKmHoraChegada.add("22");
        lstKmHoraChegada.add("23");


        ArrayAdapter adapterHoraChegada = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lstKmHoraChegada);

        spnKmHoraChegada = (Spinner) findViewById(R.id.spHoraChegada);
        spnKmHoraChegada.setAdapter(adapterHoraChegada);


        spnKmHoraChegada.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parentHCH, View viewCH, int posCH, long idCH) {

                selecKmHoraChegada[0] = parentHCH.getItemAtPosition(posCH).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });

        /******************************************************************************/


        lstKmMinutoChegada.add("MINUTO");
        lstKmMinutoChegada.add("00");
        lstKmMinutoChegada.add("15");
        lstKmMinutoChegada.add("30");
        lstKmMinutoChegada.add("45");


        ArrayAdapter adapterMinutoChegada = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lstKmMinutoChegada);

        spnKmMinutoChegada = (Spinner) findViewById(R.id.spMinutoChegada);
        spnKmMinutoChegada.setAdapter(adapterMinutoChegada);


        spnKmMinutoChegada.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parentMCH, View viewMCH, int posMCH, long idMCH) {

                selecKmMinutoChegada[0] = parentMCH.getItemAtPosition(posMCH).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });


        /********************************************************************************/


        sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        resultSHPkmcpf = sharedPreferences.getString("sp_KmCpfSalvo", "");
        if (!TextUtils.isEmpty(resultSHPkmcpf)) {
            edKmCpf.setText(resultSHPkmcpf);
        }

    } // finish onCreate

    /*************************************************************************************************/

    //Log.i("AsyncTask", "Elementos de tela criados e atribuidos Thread: " + Thread.currentThread().getName());
    @Override
    public void onClick(View arg0) {


    //Log.i("AsyncTask", "Botão Clicado Thread: " + Thread.currentThread().getName());

        stKmCpf = edKmCpf.getText().toString().trim();
        stKmSaida = edKmSaida.getText().toString().trim();
        stKmChegada = edKmChegada.getText().toString().trim();

        //check campos nulos
        if (TextUtils.isEmpty(stKmCpf) || selecKmDia[0].equals("DIA") || selecKmMes[0].equals("MÊS") ||
                selecKmAno[0].equals("ANO") || selecKmHoraSaida[0].equals("HORA") ||
                selecKmMinutoSaida[0].equals("MINUTO") || selecKmHoraChegada[0].equals("HORA") ||
                selecKmMinutoChegada[0].equals("MINUTO") || TextUtils.isEmpty(stKmSaida) ||
                TextUtils.isEmpty(stKmChegada) ) {

            Toast.makeText(MotoristaActivity.this, "Por favor! Preencha os campos corretamente.",
                    Toast.LENGTH_LONG).show();

        } else {

            checkKmCpf = cbKmSalvarCpf.isChecked();
            checkKmResponsavel = cbKmResponsavel.isChecked();

            if (checkKmResponsavel) {

                if (checkKmCpf) {
                    marcaKmCpf = "Sim";

                    sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
                    editor = sharedPreferences.edit();
                    editor.putString("sp_KmCpfSalvo", stKmCpf);
                    editor.apply();
                }

                /********************************************************/
                //append
                stbKmData = new StringBuilder();

                stbKmData.append(selecKmAno[0]);
                stbKmData.append("-");
                stbKmData.append(selecKmMes[0]);
                stbKmData.append("-");
                stbKmData.append(selecKmDia[0]);

                stDataKm = stbKmData.toString();  //Log.d("Data final da Partida", dataKm);

                /********************************************************/
                stbKmHoraSaida = new StringBuilder();

                stbKmHoraSaida.append(selecKmHoraSaida[0]);
                stbKmHoraSaida.append(":");
                stbKmHoraSaida.append(selecKmMinutoSaida[0]);

                stHoraSaida = stbKmHoraSaida.toString(); //Log.d("Hora final da Partida", stHoraSaida);

                /********************************************************/

                stbKmHoraChegada = new StringBuilder();

                stbKmHoraChegada.append(selecKmHoraChegada[0]);
                stbKmHoraChegada.append(":");
                stbKmHoraChegada.append(selecKmMinutoChegada[0]);

                stHoraChegada = stbKmHoraChegada.toString();


                /********************************************************/
                controleAsyncTask(number, stKmCpf, stDataKm, stKmSaida, stHoraSaida, stKmChegada, stHoraChegada);

            } else {

                Toast.makeText(MotoristaActivity.this, "Por favor. Clique na caixa de confirmação!", Toast.LENGTH_LONG).show();
            }

        }

    } //finish onClick


//***************************************************************************************************//

    protected void controleAsyncTask(Integer at_id, String at_cpf,
                                     String at_datakm, String at_kmsaida, String at_horasaida,
                                     String at_kmchegada, String at_horachegada) {

        //executando AsyncTask
        AddUserTask utask = new AddUserTask();
        utask.execute(at_id, at_cpf, at_datakm, at_kmsaida, at_horasaida, at_kmchegada, at_horachegada);

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
            String in_datakm = (String) params[2];
            String in_kmsaida = (String) params[3];
            String in_horasaida = (String) params[4];
            String in_kmchegada = (String) params[5];
            String in_horachegada = (String) params[6];


            //Log.i("AsyncTask", "Executando insercion Thread: " + Thread.currentThread().getName());

            ControleKmDAO controlekm = new ControleKmDAO();

            resultado = controlekm.cadastrarControle(new ControleKm(in_id, in_cpf,
                    in_datakm, in_kmsaida, in_horasaida, in_kmchegada, in_horachegada));


            return resultado;

        }

        @Override
        protected void onPostExecute(Boolean fresult) {

            //Log.i("O resultado", String.valueOf(fresult));

            if (fresult) {
                //Log.i("AsyncTask", "Exibindo Bitmap Thread: " + Thread.currentThread().getName());
                Toast.makeText(MotoristaActivity.this, "Controle de KM foi enviado com sucesso!", Toast.LENGTH_LONG).show();
                finish();


            } else {
                //Log.i("AsyncTask", "Erro ao baixar a imagem " + Thread.currentThread().getName());
                Toast.makeText(MotoristaActivity.this, "Desculpe, erro ao enviar... Tente mais tarde!", Toast.LENGTH_LONG).show();
            }
        }
    }












}
