package org.d3ifcool.halojantung;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.io.StringReader;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editNama, editTinggiBadan, editBeratBadan, editEmail, editPassword;
    private Button buttonRegister;
    private TextView ViewSignin;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);
        buttonRegister = (Button) findViewById(R.id.register);

        editNama = (EditText) findViewById(R.id.nama);
        editTinggiBadan = (EditText) findViewById(R.id.tinggi);
        editBeratBadan = (EditText) findViewById(R.id.berat);
        editEmail = (EditText) findViewById(R.id.email);
        editPassword = (EditText) findViewById(R.id.password);

        ViewSignin = (TextView) findViewById(R.id.ViewSignin);
        buttonRegister.setOnClickListener(this);
        ViewSignin.setOnClickListener(this);
    }

    private void registerUser(){
        String nama = editNama.getText().toString().trim();
        String tinggibadan = editTinggiBadan.getText().toString().trim();
        String beratbadan = editBeratBadan.getText().toString().trim();
        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();

        if(TextUtils.isEmpty(nama)){
            Toast.makeText(this, "Tolong isi kolom Nama ", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(tinggibadan)){
            Toast.makeText(this, "Tolong isi kolom Tinggi Badan ", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(beratbadan)){
            Toast.makeText(this, "Tolong isi kolom Berat Badan ", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Tolong isi kolom Email ", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Tolong isi kolom Password ", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering User..");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                        finish();
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        Toast.makeText(RegisterActivity.this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(RegisterActivity.this, "Registrasi Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        if(view == buttonRegister){
            registerUser();
        }
        if (view == ViewSignin){
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}
