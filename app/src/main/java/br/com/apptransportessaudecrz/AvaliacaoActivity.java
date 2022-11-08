package br.com.apptransportessaudecrz;

import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

import br.com.dao.AvaliacaoPacienteDAO;
import br.com.model.AvaliacaoPaciente;


public class AvaliacaoActivity extends AppCompatActivity implements View.OnClickListener {

    private long dataAtualAvalia = System.currentTimeMillis();

    SimpleDateFormat sdfa = new SimpleDateFormat("yyyy-MM-dd");
    private String dataAtualAv = sdfa.format(dataAtualAvalia);

    //private EditText edAvaliaCpf;
    private EditText edAvaliaMensagem;

    private Spinner spnAvaliacao;
    private List<String> tiposAvaliacao = new ArrayList<String>();

    private ImageButton btnEnviarAvaliacao;

    //private CheckBox cbAvaliaSalvarCpf;

    //private boolean checkAvaliaCpf;

    //private String marcaAvaliaCpf;

    private String[] vAvaliacaoSolicitado = new String[1];

    //private SharedPreferences sharedPreferences;
    //private SharedPreferences.Editor editor;

    //private static final String PREF_NAME = "ActivityPreferences";

    //private String resultSHPcpf;

    private String valorToCpf;

    final int number = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //edAvaliaCpf = (EditText) findViewById(R.id.edAvaliaCpf);

        //cbAvaliaSalvarCpf = (CheckBox) findViewById(R.id.cbAvaliaSalvarCpf);

        edAvaliaMensagem = (EditText) findViewById(R.id.edAvaliaMensagem);
        edAvaliaMensagem.setSingleLine(false);

        btnEnviarAvaliacao = (ImageButton) findViewById(R.id.btnEnviarAvaliacao);
        btnEnviarAvaliacao.setOnClickListener(this);

        tiposAvaliacao.add("ESCOLHA O TIPO DE AVALIAÇÃO");
        tiposAvaliacao.add("ÓTIMO");
        tiposAvaliacao.add("BOM");
        tiposAvaliacao.add("REGULAR");
        tiposAvaliacao.add("RUIM");
        tiposAvaliacao.add("PÉSSIMO");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, tiposAvaliacao);

        spnAvaliacao = (Spinner) findViewById(R.id.spAvaliaTipoAvaliacao);
        spnAvaliacao.setAdapter(adapter);


        spnAvaliacao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                vAvaliacaoSolicitado[0] = parent.getItemAtPosition(pos).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });

       /* sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        resultSHPcpf = sharedPreferences.getString("sp_cpfSalvo", "");
        if(!TextUtils.isEmpty(resultSHPcpf)){
            edAvaliaCpf.setText(resultSHPcpf);
        }*/

    } //finish onCreate




    @Override
    public void onClick(View v) {


        //check campos nulos
        if (//TextUtils.isEmpty(edAvaliaCpf.getText().toString().trim()) ||
                vAvaliacaoSolicitado[0].equals("ESCOLHA O TIPO DE AVALIAÇÃO")

                ) {

            Toast.makeText(AvaliacaoActivity.this, "Por favor! Preencha os campos corretamente.", Toast.LENGTH_LONG).show();

        } else {


            //checkAvaliaCpf = cbAvaliaSalvarCpf.isChecked();

           /* if(checkAvaliaCpf){
                marcaAvaliaCpf="Sim";

                sharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putString("sp_cpfSalvo", edAvaliaCpf.getText().toString());
                editor.apply();

            }*/

            //Log.i("Vendo shared pref: ",sharedPreferences.getString("sp_cpfAvaliacao", ""));

            valorToCpf = "Anônimo";

            avaliacaoAsyncTask(number, valorToCpf, dataAtualAv,
                    vAvaliacaoSolicitado[0], edAvaliaMensagem.getText().toString());

        }

    } // finish onClick

//***************************************************************************************************//

    protected void avaliacaoAsyncTask(Integer av_id, String av_cpf,
                                      String av_dataatual, String av_tipoavaliacao,
                                      String av_mensagemavaliacao) {

        //executando AsyncTask
        AvaliacaoActivity.AddAvaliaTask avaliatask = new AvaliacaoActivity.AddAvaliaTask();
        avaliatask.execute(av_id, av_cpf,av_dataatual,av_tipoavaliacao, av_mensagemavaliacao);

        //Log.i("chama async",at_horapartida);
        //Log.i("AsyncTask", "AsyncTask senado chamado Thread: " + Thread.currentThread().getName());
    }

//***************************************************************************************************//

    // classe AsyncTask (gerenciador de threads)
    private class AddAvaliaTask extends AsyncTask<Object, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Object... params) {

            Boolean avresultado = null;

            Integer iv_id = (Integer) params[0];
            String iv_cpf = (String) params[1];
            String iv_data = (String) params[2];
            String iv_tipoavaliacao = (String) params[3];
            String iv_mensagemavaliacao = (String) params[4];

            //Log.i("AsyncTask", "Executando insercion Thread: " + Thread.currentThread().getName());

            AvaliacaoPacienteDAO avaliacaopaciente = new AvaliacaoPacienteDAO();

            avresultado = avaliacaopaciente.cadastrarAvaliacao(new AvaliacaoPaciente(iv_id,iv_cpf,
                    iv_data,iv_tipoavaliacao,iv_mensagemavaliacao));


            return avresultado;

        }

        @Override
        protected void onPostExecute(Boolean avfresult) {

            //Log.i("O resultado", String.valueOf(fresult));

            if (avfresult) {
                //Log.i("AsyncTask", "Exibindo Bitmap Thread: " + Thread.currentThread().getName());
                Toast.makeText(AvaliacaoActivity.this, "Sua avaliação foi enviada com sucesso.", Toast.LENGTH_LONG).show();
                finish();


            } else {
                //Log.i("AsyncTask", "Erro ao baixar a imagem " + Thread.currentThread().getName());
                Toast.makeText(AvaliacaoActivity.this, "Desculpe, erro ao enviar... Tente mais tarde!", Toast.LENGTH_LONG).show();
            }
        }
    }



















}