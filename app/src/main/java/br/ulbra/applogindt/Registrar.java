package br.ulbra.applogindt;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registrar extends AppCompatActivity {
    EditText edNome, edUser, edPas1, edPas2;
    Button btSalvar;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);
        db = new DBHelper(this);

        edNome = (EditText)findViewById(R.id.edNome);
        edUser = (EditText)findViewById(R.id.edLogin);
        edPas1 = (EditText)findViewById(R.id.edSenha1);
        edPas2 = (EditText)findViewById(R.id.edSenha2);


        btSalvar = (Button)findViewById(R.id.btSalvar);

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName = edUser.getText().toString();
                String pas1 = edPas1.getText().toString();
                String pas2 = edPas2.getText().toString();
                if (userName.equals("")) {
                    Toast.makeText(Registrar.this, "Insira o LOGIN DO USUÁRIO", Toast.LENGTH_SHORT).show();
                } else if (pas1.equals("") || pas2.equals("")){
                    Toast.makeText(Registrar.this, "Insira a SENHA DO USUÁRIO", Toast.LENGTH_SHORT).show();
                }else if(!pas1.equals(pas2)){
                    Toast.makeText(Registrar.this, "As senhas não correspondem ao login do usuário", Toast.LENGTH_SHORT).show();
                }else{
                    long res = db.criarUtilizador(userName,pas1);
                    if(res>0){
//nesta parte você poderá chamar a tela principal do sistema autenticado
                        Toast.makeText(Registrar.this, "Resgistro OK", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(Registrar.this, "Senha inválida!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        } );
    }
}

