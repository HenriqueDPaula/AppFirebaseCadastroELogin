package com.example.HenriqueDPaula.testeaplicacaofirebase.Acitivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.troli.testeaplicacaofirebase.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HelloActivity extends Activity {

    private FirebaseAuth mAuth;

    private TextView txtLoginUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        mAuth = FirebaseAuth.getInstance();
        loginUsuario = findViewById(R.id.loginUsuario);

    }
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        loginUsuario.setText(currentUser.getEmail());

    }
}
