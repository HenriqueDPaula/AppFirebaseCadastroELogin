package com.example.HenriqueDPaula.testeaplicacaofirebase.Acitivity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.troli.testeaplicacaofirebase.Classes.Carro;
import com.example.troli.testeaplicacaofirebase.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

	private EditText editLogin;
	private EditText editSenha;

	private EditText editLoginCadastrar;
	private EditText editSenhaCadastrar;

	private FirebaseAuth mAuth;

	private FirebaseDatabase mDatabase;
	private DatabaseReference mRef;

	private ProgressBar progressDB;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editLogin = findViewById(R.id.editLogin);
		editSenha = findViewById(R.id.editSenha);

		editLoginCadastrar = findViewById(R.id.editLoginCadastrar);
		editSenhaCadastrar = findViewById(R.id.editSenhaCadastrar);

		mAuth = FirebaseAuth.getInstance();

		mDatabase = FirebaseDatabase.getInstance();
		mRef = mDatabase.getReference("carros");

		progressDB = findViewById(R.id.progressDB);

	}

	public void logar(View view) {
		String login = editLogin.getText().toString();
		String senha = editSenha.getText().toString();

		mAuth.signInWithEmailAndPassword(login, senha).addOnCompleteListener(this,
				new OnCompleteListener<AuthResult>() {
					@Override
					public void onComplete(@NonNull Task<AuthResult> task) {
						if (task.isSuccessful()) {
							Toast.makeText(MainActivity.this, "Usu�rio logado!", Toast.LENGTH_SHORT).show();
							Intent intent = new Intent(this, HelloActivity.class);
							startActivity(intent);
						} else {
							Toast.makeText(MainActivity.this, "Erro", Toast.LENGTH_SHORT).show();
						}
					}
				});

	}

	public void exibirDadosUsuario(View v) {
		Intent intent = new Intent(this, UserActivity.class);
		startActivity(intent);
	}

	public void cadastrar(View view) {
		String login = editLoginCadastrar.getText().toString();
		String senha = editSenhaCadastrar.getText().toString();

		mAuth.createUserWithEmailAndPassword(login, senha).addOnCompleteListener(this,
				new OnCompleteListener<AuthResult>() {
					@Override
					public void onComplete(@NonNull Task<AuthResult> task) {
						if (task.isSuccessful()) {
							Toast.makeText(MainActivity.this, "Usu�rio criado com sucesso!", Toast.LENGTH_SHORT).show();
						} else {
							Toast.makeText(MainActivity.this, "Erro ao cadastrar.", Toast.LENGTH_SHORT).show();
						}
					}
				});

	}

	public void salvarCarro(View view) {

		Carro carro = new Carro("Fiat", "Uno", 1997);
		progressDB.setVisibility(progressDB.VISIBLE);
		mRef.child("carro1").setValue(carro).addOnCompleteListener(MainActivity.this, new OnCompleteListener<Void>() {
			@Override
			public void onComplete(@NonNull Task<Void> task) {
				if (task.isSuccessful()) {
					Toast.makeText(MainActivity.this, "Carro salvo com sucesso.", Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(MainActivity.this, "Erro ao salvar ", Toast.LENGTH_SHORT).show();
				}
			}
		});
		progressDB.setVisibility(progressDB.GONE);
	}
}
