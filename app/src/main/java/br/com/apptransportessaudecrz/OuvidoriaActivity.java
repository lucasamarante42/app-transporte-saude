package br.com.apptransportessaudecrz;

import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.dao.OuvidoriaPacienteDAO;
import br.com.model.OuvidoriaPaciente;


public class OuvidoriaActivity extends AppCompatActivity implements View.OnClickListener{



    private long dataAtualOuvidoria = System.currentTimeMillis();

    SimpleDateFormat sdfo = new SimpleDateFormat("yyyy-MM-dd");
    private String dataAtualOv = sdfo.format(dataAtualOuvidoria);

    //private EditText edOuvidoriaCpf;
    private EditText edOuvidoriaMensagem;

    private Spinner spnOuvidoria;
    private List<String> tiposOuvidoria = new ArrayList<String>();

    private ImageButton btnEnviarOuvidoria;

    //private CheckBox cbOuvidoriaAnonimo;

    //private boolean checkOuvidoriaAnonimo;

    private String valorCpfouAnonimo;

    private String[] vOuvidoriaSolicitado = new String[1];

    //private SharedPreferences sharedPreferences;
    //private SharedPreferences.Editor editor;

    //private static final String PREF_NAME = "ActivityPreferences";

    //private String resultSHPcpf;

    final int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(br.com.apptransportessaudecrz.R.layout.activity_ouvidoria);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        //edOuvidoriaCpf = (EditText) findViewById(R.id.edOuvidoriaCpf);

        //cbOuvidoriaAnonimo = (CheckBox) findViewById(R.id.cbOuvidoriaAnonimo);

        edOuvidoriaMensagem = (EditText) findViewById(R.id.edOuvidoriaMensagem);
        edOuvidoriaMensagem.setSingleLine(false);

        btnEnviarOuvidoria = (ImageButton) findViewById(R.id.btnEnviarOuvidoria);
        btnEnviarOuvidoria.setOnClickListener(this);

        tiposOuvidoria.add("ESCOLHA O TIPO DE OUVIDORIA");
        tiposOuvidoria.add("DENÚNCIA");
        tiposOuvidoria.add("ELOGIOS");
        tiposOuvidoria.add("RECLAMAÇÃO");
        tiposOuvidoria.add("SOLICITAÇÃO");
        tiposOuvidoria.add("SUGESTÃO");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, tiposOuvidoria);

        spnOuvidoria = (Spinner) findViewById(br.com.apptransportessaudecrz.R.id.spOuvidoriaTipo);
        spnOuvidoria.setAdapter(adapter);


        spnOuvidoria.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                vOuvidoriaSolicitado[0] = parent.getItemAtPosition(pos).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });


      /*  sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        resultSHPcpf = sharedPreferences.getString("sp_cpfSalvo", "");

        if(!TextUtils.isEmpty(resultSHPcpf)){
            edOuvidoriaCpf.setText(resultSHPcpf);
        } else{
            //edOuvidoriaCpf.setText("");
            cbOuvidoriaAnonimo.setChecked(true);
        }*/





    } //finish onCreate

//***************************************************************************************************//

    @Override
    public void onClick(View v) {

        //checkOuvidoriaAnonimo = cbOuvidoriaAnonimo.isChecked();


        //if (TextUtils.isEmpty(edOuvidoriaCpf.getText().toString().trim()) &&
        //        !checkOuvidoriaAnonimo){
        //    Toast.makeText(OuvidoriaActivity.this, "Por favor! Preencha os campos corretamente.", Toast.LENGTH_LONG).show();

        //}else {

            //check campos nulos
            if (TextUtils.isEmpty(edOuvidoriaMensagem.getText().toString().trim()) ||
                    vOuvidoriaSolicitado[0].equals("ESCOLHA O TIPO DE OUVIDORIA")) {

                Toast.makeText(OuvidoriaActivity.this, "Por favor! Preencha os campos corretamente.", Toast.LENGTH_LONG).show();

            } else {

                // if (checkOuvidoriaAnonimo && TextUtils.isEmpty(edOuvidoriaCpf.getText().toString().trim())) {
                    valorCpfouAnonimo = "Anônimo";

                //Log.i("Vendo shared pref: ",sharedPreferences.getString("sp_cpfAvaliacao", ""));

                //  ouvidoriaAsyncTask(number, valorCpfouAnonimo, dataAtualOv,
                //          vOuvidoriaSolicitado[0], edOuvidoriaMensagem.getText().toString());

                // } else if(!checkOuvidoriaAnonimo && !TextUtils.isEmpty(edOuvidoriaCpf.getText().toString().trim())) {
                //   valorCpfouAnonimo = edOuvidoriaCpf.getText().toString();


                //Log.i("Vendo shared pref: ",sharedPreferences.getString("sp_cpfAvaliacao", ""));

                    ouvidoriaAsyncTask(number, valorCpfouAnonimo, dataAtualOv,
                            vOuvidoriaSolicitado[0], edOuvidoriaMensagem.getText().toString());


                }
                //else{
                //   Toast.makeText(OuvidoriaActivity.this, "Por favor! Entrada inválida: CPF e Anônimo selecionado juntos.", Toast.LENGTH_LONG).show();
               // }





        //}

    } // finish onClick

//***************************************************************************************************//



    protected void ouvidoriaAsyncTask(Integer ov_id, String ov_cpf,
                                      String ov_dataatual, String ov_tipoouvidoria,
                                      String ov_mensagemouvidoria) {

        //executando AsyncTask
        OuvidoriaActivity.AddOuvidoriaTask ouvidoriatask = new OuvidoriaActivity.AddOuvidoriaTask();

        ouvidoriatask.execute(ov_id, ov_cpf, ov_dataatual, ov_tipoouvidoria, ov_mensagemouvidoria);

        //Log.i("chama async",at_horapartida);
        //Log.i("AsyncTask", "AsyncTask senado chamado Thread: " + Thread.currentThread().getName());
    }

//***************************************************************************************************//

    // classe AsyncTask (gerenciador de threads)
    private class AddOuvidoriaTask extends AsyncTask<Object, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Object... params) {

            Boolean ovresultado = null;

            Integer oiv_id = (Integer) params[0];
            String oiv_cpf = (String) params[1];
            String oiv_data = (String) params[2];
            String oiv_tipoouvidoria = (String) params[3];
            String oiv_mensagemouvidoria = (String) params[4];

            //Log.i("AsyncTask", "Executando insercion Thread: " + Thread.currentThread().getName());

            OuvidoriaPacienteDAO ouvidoriapaciente = new OuvidoriaPacienteDAO();

            ovresultado = ouvidoriapaciente.cadastrarOuvidoria(new OuvidoriaPaciente(oiv_id,oiv_cpf,
                    oiv_data,oiv_tipoouvidoria,oiv_mensagemouvidoria));


            return ovresultado;

        }

        @Override
        protected void onPostExecute(Boolean ovfresult) {

            //Log.i("O resultado", String.valueOf(fresult));

            if (ovfresult) {
                //Log.i("AsyncTask", "Exibindo Bitmap Thread: " + Thread.currentThread().getName());
                Toast.makeText(OuvidoriaActivity.this, "Sua ouvidoria foi enviada com sucesso!", Toast.LENGTH_LONG).show();
                finish();


            } else {
                //Log.i("AsyncTask", "Erro ao baixar a imagem " + Thread.currentThread().getName());
                Toast.makeText(OuvidoriaActivity.this, "Desculpe, erro ao enviar... Tente mais tarde!", Toast.LENGTH_LONG).show();
            }
        }
    }


















}