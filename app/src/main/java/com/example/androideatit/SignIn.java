package com.example.androideatit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.androideatit.Common.Common;
import com.example.androideatit.Model.ModelPengguna;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity {

    TextView TextHeaderSignIn;
    MaterialButton BtnLogin;
    TextInputEditText EdtUsername, EdtPassword;
    TextInputLayout LayUsername, LayPassword;
    FloatingActionButton Fab_back;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Pengguna");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        TextHeaderSignIn = (TextView)findViewById(R.id.textHeaderSignIn);
        BtnLogin = (MaterialButton)findViewById(R.id.btnSignIn);
        LayUsername = (TextInputLayout)findViewById(R.id.layUsername);
        LayPassword = (TextInputLayout)findViewById(R.id.layPassword);
        EdtUsername = (TextInputEditText)findViewById(R.id.edtUsername);
        EdtPassword = (TextInputEditText)findViewById(R.id.edtPassword);
        Fab_back = (FloatingActionButton)findViewById(R.id.fab_back);
        Fab_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignIn.this, MainActivity.class));
            }
        });

        funHeaderFont();

        funLogin();
    }

    private void funHeaderFont() {
        Typeface customFont = Typeface.createFromAsset(getAssets(), "fonts/Pacifico-Regular.ttf");
        TextHeaderSignIn.setTypeface(customFont);
    }

    private void funLogin() {
        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (EdtUsername.getText().toString().isEmpty() && EdtPassword.getText().toString().isEmpty())
                        {
                            LayUsername.setError("Username Kosong");
                            LayPassword.setError("Password Kosong");
                        }
                        else if (EdtUsername.getText().toString().isEmpty()){
                            LayUsername.setError("Username Kosong");
                            LayPassword.setError(null);
                        }
                        else if (EdtPassword.getText().toString().isEmpty()){
                            LayPassword.setError("Password Kosong");
                            LayUsername.setError(null);
                        }
                        else {
                            LayUsername.setError(null);
                            LayPassword.setError(null);
                            if (dataSnapshot.child(EdtUsername.getText().toString()).exists())
                            {
                                ModelPengguna modelPengguna = dataSnapshot.child(EdtUsername.getText().toString()).getValue(ModelPengguna.class);
                                modelPengguna.setTelepon(modelPengguna.getTelepon());
                                if (modelPengguna.getSandi().equals(EdtPassword.getText().toString()))
                                {
                                    Common.currentModelPengguna = modelPengguna;
                                    startActivity(new Intent(SignIn.this, Home.class));
                                }else {
                                    LayUsername.setError(null);
                                    LayPassword.setError("Sandi Salah");
                                }
                            }
                            else
                            {
                                LayUsername.setError("Username Belum terdaftar");
                                LayPassword.setError(null);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
