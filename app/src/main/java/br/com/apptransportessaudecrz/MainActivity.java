package br.com.apptransportessaudecrz;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnSolicitacao, btnOuvidoria, btnAvaliacao, btnLoginMotorista ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        iniciarComponentes();
    }



    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnSolicitacao:

                startActivity(new Intent(this, SolicitacaoActivity.class));

                break;

            case R.id.btnOuvidoria:

                startActivity(new Intent(this, OuvidoriaActivity.class));

                break;

            case R.id.btnAvaliacao:

                startActivity(new Intent(this, AvaliacaoActivity.class));

                break;

            case R.id.btnLoginMotorista:

                ExibeDialog();

                break;

        }
    }


    /******************************************************************************/


    private void iniciarComponentes(){

        btnSolicitacao = (ImageButton) findViewById(R.id.btnSolicitacao);
        btnSolicitacao.setOnClickListener(this);

        btnOuvidoria = (ImageButton) findViewById(R.id.btnOuvidoria);
        btnOuvidoria.setOnClickListener(this);

        btnAvaliacao = (ImageButton) findViewById(R.id.btnAvaliacao);
        btnAvaliacao.setOnClickListener(this);

        btnLoginMotorista = (ImageButton) findViewById(R.id.btnLoginMotorista);
        btnLoginMotorista.setOnClickListener(this);

    }


    /******************************************************************************/

    private void ExibeDialog(){
        final Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.activity_login_motorista);

        //define o título do Dialog
        dialog.setTitle("ÁREA DO MOTORISTA");

        //instancia os objetos que estão no layout customdialog.xml
        final Button confirmar = (Button) dialog.findViewById(R.id.btnConfirmar);
        final Button cancelar = (Button) dialog.findViewById(R.id.btnCancelar);
        final EditText codigo = (EditText) dialog.findViewById(R.id.etValor);



        confirmar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if(codigo.getText().toString().trim().equals("752301") ){
                    Intent it = new Intent(MainActivity.this, MotoristaActivity.class);
                    startActivity(it);
                }


                //finaliza o dialog
                dialog.dismiss();
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //finaliza o dialog
                dialog.dismiss();
            }
        });

        //exibe na tela o dialog
        dialog.show();

    }



}
