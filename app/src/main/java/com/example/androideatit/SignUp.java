package com.example.androideatit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

public class SignUp extends AppCompatActivity {

    TextView TextHeaderSignUp;
    MaterialButton BtnSignUp;
    TextInputLayout LayUsername, LayPassword, LayConfirmPassword, LayFirstname, LayLastname, LayNumberPhone;
    TextInputEditText EdtUsername, EdtPassword, EdtConfirmPassword, EdtFirstname, EdtLastname, EdtNumberPhone;
    FloatingActionButton Fab_back;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Pengguna");
    String Username, Firstname, Lastname, NumberPhone, Password, ConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        TextHeaderSignUp = (TextView)findViewById(R.id.textHeaderSignUp);
        LayUsername = (TextInputLayout)findViewById(R.id.layUsername);
        LayFirstname = (TextInputLayout)findViewById(R.id.layFirstname);
        LayLastname = (TextInputLayout)findViewById(R.id.layLastname);
        LayNumberPhone = (TextInputLayout)findViewById(R.id.layNumberPhone);
        LayPassword = (TextInputLayout)findViewById(R.id.layPassword);
        LayConfirmPassword = (TextInputLayout)findViewById(R.id.layConfirmPassword);
        EdtUsername = (TextInputEditText)findViewById(R.id.edtUsername);
        EdtFirstname = (TextInputEditText)findViewById(R.id.edtFirstname);
        EdtLastname = (TextInputEditText)findViewById(R.id.edtLastname);
        EdtNumberPhone = (TextInputEditText)findViewById(R.id.edtNumberPhone);
        EdtPassword = (TextInputEditText)findViewById(R.id.edtPassword);
        EdtConfirmPassword = (TextInputEditText)findViewById(R.id.edtConfirmPassword);
        BtnSignUp = (MaterialButton)findViewById(R.id.btnSignUp);
        Fab_back = (FloatingActionButton)findViewById(R.id.fab_back);
        Fab_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        funHeaderFont();

        funSignUp();
    }

    private void funHeaderFont() {
        Typeface customFont = Typeface.createFromAsset(getAssets(), "fonts/Pacifico-Regular.ttf");
        TextHeaderSignUp.setTypeface(customFont);
    }

    private void funSignUp() {


        BtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Username = EdtUsername.getText().toString();
                        Firstname = EdtFirstname.getText().toString();
                        Lastname = EdtLastname.getText().toString();
                        NumberPhone = EdtNumberPhone.getText().toString();
                        Password = EdtPassword.getText().toString();
                        ConfirmPassword = EdtConfirmPassword.getText().toString();
                        if (Username.isEmpty() && Firstname.isEmpty() && Lastname.isEmpty() && NumberPhone.isEmpty() && Password.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Firstname.isEmpty() && Lastname.isEmpty() && NumberPhone.isEmpty() && Password.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //23456
                            LayUsername.setError(null);
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Username.isEmpty() && Lastname.isEmpty() && NumberPhone.isEmpty() && Password.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //13456
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError(null);
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Username.isEmpty() && Firstname.isEmpty() && NumberPhone.isEmpty() && Password.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //12456
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError(null);
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Username.isEmpty() && Firstname.isEmpty() && Lastname.isEmpty() && Password.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //12356
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError(null);
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Username.isEmpty() && Firstname.isEmpty() && Lastname.isEmpty() && NumberPhone.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //12346
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError(null);
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Username.isEmpty()  && Firstname.isEmpty() && Lastname.isEmpty() && NumberPhone.isEmpty() && Password.isEmpty())
                        {
                            //12345
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError(null);
                        }
                        else if (Username.isEmpty()  && Firstname.isEmpty() && Lastname.isEmpty() && NumberPhone.isEmpty())
                        {
                            //1234
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError(null);
                            LayConfirmPassword.setError(null);
                        }
                        else if (Username.isEmpty() && Firstname.isEmpty() && Lastname.isEmpty() && Password.isEmpty())
                        {
                            //1235
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError(null);
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError(null);
                        }
                        else if(Username.isEmpty() && Firstname.isEmpty() && Lastname.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //1236
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError(null);
                            LayPassword.setError(null);
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Username.isEmpty() && Firstname.isEmpty() && NumberPhone.isEmpty() && Password.isEmpty())
                        {
                            //1245
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError(null);
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError(null);
                        }
                        else if (Username.isEmpty() && Firstname.isEmpty() && NumberPhone.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //1246
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError(null);
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError(null);
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Username.isEmpty() && Firstname.isEmpty() && Password.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //1256
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError(null);
                            LayNumberPhone.setError(null);
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Username.isEmpty() && Lastname.isEmpty() && NumberPhone.isEmpty() && Password.isEmpty())
                        {
                            //1345
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError(null);
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError(null);
                        }
                        else if (Username.isEmpty() && Lastname.isEmpty() && NumberPhone.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //1346
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError(null);
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError(null);
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Username.isEmpty() && Lastname.isEmpty() && Password.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //1356
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError(null);
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError(null);
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Username.isEmpty() && NumberPhone.isEmpty() && Password.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //1456
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError(null);
                            LayLastname.setError(null);
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Firstname.isEmpty() && Lastname.isEmpty() && NumberPhone.isEmpty() && Password.isEmpty())
                        {
                            //2345
                            LayUsername.setError(null);
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError(null);
                        }
                        else if (Firstname.isEmpty() && Lastname.isEmpty() && NumberPhone.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //2346
                            LayUsername.setError(null);
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError(null);
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Firstname.isEmpty() && Lastname.isEmpty() && Password.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //2356
                            LayUsername.setError(null);
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError(null);
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Firstname.isEmpty() && NumberPhone.isEmpty() && Password.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //2456
                            LayUsername.setError(null);
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError(null);
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Lastname.isEmpty() && NumberPhone.isEmpty() && Password.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //3456
                            LayUsername.setError(null);
                            LayFirstname.setError(null);
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        //------
                        else if (Username.isEmpty() && Firstname.isEmpty() && Lastname.isEmpty())
                        {
                            //123
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError(null);
                            LayPassword.setError(null);
                            LayConfirmPassword.setError(null);
                        }
                        else if (Username.isEmpty() && Firstname.isEmpty() && NumberPhone.isEmpty())
                        {
                            //124
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError(null);
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError(null);
                            LayConfirmPassword.setError(null);
                        }
                        else if (Username.isEmpty() && Firstname.isEmpty() && Password.isEmpty())
                        {
                            //125
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError(null);
                            LayNumberPhone.setError(null);
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError(null);
                        }
                        else if (Username.isEmpty() && Firstname.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //126
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError(null);
                            LayNumberPhone.setError(null);
                            LayPassword.setError(null);
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Username.isEmpty() && Lastname.isEmpty() && NumberPhone.isEmpty())
                        {
                            //134
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError(null);
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError(null);
                            LayConfirmPassword.setError(null);
                        }
                        else if (Username.isEmpty() && Lastname.isEmpty() && Password.isEmpty())
                        {
                            //135
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError(null);
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError(null);
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError(null);
                        }
                        else if (Username.isEmpty() && Lastname.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //136
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError(null);
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError(null);
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError(null);
                        }
                        else if (Username.isEmpty() && NumberPhone.isEmpty() && Password.isEmpty())
                        {
                            //145
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError(null);
                            LayLastname.setError(null);
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError(null);
                        }
                        else if (Username.isEmpty() && NumberPhone.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //146
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError(null);
                            LayLastname.setError(null);
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError(null);
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Username.isEmpty() && Password.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //156
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError(null);
                            LayLastname.setError(null);
                            LayNumberPhone.setError(null);
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Firstname.isEmpty() && Lastname.isEmpty() && NumberPhone.isEmpty())
                        {
                            //234
                            LayUsername.setError(null);
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError(null);
                            LayConfirmPassword.setError(null);
                        }
                        else if (Firstname.isEmpty() && Lastname.isEmpty() && Password.isEmpty())
                        {
                            //235
                            LayUsername.setError(null);
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError(null);
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError(null);
                        }
                        else if (Firstname.isEmpty() && Lastname.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //236
                            LayUsername.setError(null);
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError(null);
                            LayPassword.setError(null);
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Firstname.isEmpty() && NumberPhone.isEmpty() && Password.isEmpty())
                        {
                            //245
                            LayUsername.setError(null);
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError(null);
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError(null);
                        }
                        else if (Firstname.isEmpty() && NumberPhone.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //246
                            LayUsername.setError(null);
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError(null);
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError(null);
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Firstname.isEmpty() && Password.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //256
                            LayUsername.setError(null);
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError(null);
                            LayNumberPhone.setError(null);
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Lastname.isEmpty() && NumberPhone.isEmpty() && Password.isEmpty())
                        {
                            //345
                            LayUsername.setError(null);
                            LayFirstname.setError(null);
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError(null);
                        }
                        else if (Lastname.isEmpty() && NumberPhone.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //346
                            LayUsername.setError(null);
                            LayFirstname.setError(null);
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError(null);
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Lastname.isEmpty() && Password.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //356
                            LayUsername.setError(null);
                            LayFirstname.setError(null);
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError(null);
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (NumberPhone.isEmpty() && Password.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //456
                            LayUsername.setError(null);
                            LayFirstname.setError(null);
                            LayLastname.setError(null);
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Username.isEmpty() && Firstname.isEmpty())
                        {
                            //12
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError(null);
                            LayNumberPhone.setError(null);
                            LayPassword.setError(null);
                            LayConfirmPassword.setError(null);
                        }
                        else if (Username.isEmpty() && Lastname.isEmpty())
                        {
                            //13
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError(null);
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError(null);
                            LayPassword.setError(null);
                            LayConfirmPassword.setError(null);
                        }
                        else if (Username.isEmpty() && NumberPhone.isEmpty())
                        {
                            //14
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError(null);
                            LayLastname.setError(null);
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError(null);
                            LayConfirmPassword.setError(null);
                        }
                        else if (Username.isEmpty() && Password.isEmpty())
                        {
                            //15
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError(null);
                            LayLastname.setError(null);
                            LayNumberPhone.setError(null);
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError(null);
                        }
                        else if (Username.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //16
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError(null);
                            LayLastname.setError(null);
                            LayNumberPhone.setError(null);
                            LayPassword.setError(null);
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Firstname.isEmpty() && Lastname.isEmpty())
                        {
                            //23
                            LayUsername.setError(null);
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError(null);
                            LayPassword.setError(null);
                            LayConfirmPassword.setError(null);
                        }
                        else if (Firstname.isEmpty() && NumberPhone.isEmpty())
                        {
                            //24
                            LayUsername.setError(null);
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError(null);
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError(null);
                            LayConfirmPassword.setError(null);
                        }
                        else if (Firstname.isEmpty() && Password.isEmpty())
                        {
                            //25
                            LayUsername.setError(null);
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError(null);
                            LayNumberPhone.setError(null);
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError(null);
                        }
                        else if (Firstname.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //26
                            LayUsername.setError(null);
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError(null);
                            LayNumberPhone.setError(null);
                            LayPassword.setError(null);
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Lastname.isEmpty() && NumberPhone.isEmpty())
                        {
                            //34
                            LayUsername.setError(null);
                            LayFirstname.setError(null);
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError(null);
                            LayConfirmPassword.setError(null);
                        }
                        else if (Lastname.isEmpty() && Password.isEmpty())
                        {
                            //35
                            LayUsername.setError(null);
                            LayFirstname.setError(null);
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError(null);
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError(null);
                        }
                        else if (Lastname.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //36
                            LayUsername.setError(null);
                            LayFirstname.setError(null);
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError(null);
                            LayPassword.setError(null);
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (NumberPhone.isEmpty() && Password.isEmpty())
                        {
                            //45
                            LayUsername.setError(null);
                            LayFirstname.setError(null);
                            LayLastname.setError(null);
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError(null);
                        }
                        else if (NumberPhone.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //46
                            LayUsername.setError(null);
                            LayFirstname.setError(null);
                            LayLastname.setError(null);
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError(null);
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Password.isEmpty() && ConfirmPassword.isEmpty())
                        {
                            //56
                            LayUsername.setError(null);
                            LayFirstname.setError(null);
                            LayLastname.setError(null);
                            LayNumberPhone.setError(null);
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else if (Username.isEmpty())
                        {
                            //1
                            LayUsername.setError("Mohon Username Diisi!");
                            LayFirstname.setError(null);
                            LayLastname.setError(null);
                            LayNumberPhone.setError(null);
                            LayPassword.setError(null);
                            LayConfirmPassword.setError(null);
                        }
                        else if (Firstname.isEmpty())
                        {
                            //2
                            LayUsername.setError(null);
                            LayFirstname.setError("Nama Depan Mohon Diisi!");
                            LayLastname.setError(null);
                            LayNumberPhone.setError(null);
                            LayPassword.setError(null);
                            LayConfirmPassword.setError(null);
                        }
                        else if (Lastname.isEmpty())
                        {
                            //3
                            LayUsername.setError(null);
                            LayFirstname.setError(null);
                            LayLastname.setError("Nama Belakang Mohon Diisi!");
                            LayNumberPhone.setError(null);
                            LayPassword.setError(null);
                            LayConfirmPassword.setError(null);
                        }
                        else if (NumberPhone.isEmpty())
                        {
                            //4
                            LayUsername.setError(null);
                            LayFirstname.setError(null);
                            LayLastname.setError(null);
                            LayNumberPhone.setError("Nomor Telepon Kosong!");
                            LayPassword.setError(null);
                            LayConfirmPassword.setError(null);
                        }
                        else if (Password.isEmpty())
                        {
                            //5
                            LayUsername.setError(null);
                            LayFirstname.setError(null);
                            LayLastname.setError(null);
                            LayNumberPhone.setError(null);
                            LayPassword.setError("Mohon Password Diisi!");
                            LayConfirmPassword.setError(null);
                        }
                        else if (ConfirmPassword.isEmpty())
                        {
                            LayUsername.setError(null);
                            LayFirstname.setError(null);
                            LayLastname.setError(null);
                            LayNumberPhone.setError(null);
                            LayPassword.setError(null);
                            LayConfirmPassword.setError("Mohon Konfirmasi Password Diisi!");
                        }
                        else
                        {
                            LayUsername.setError(null);
                            LayFirstname.setError(null);
                            LayLastname.setError(null);
                            LayNumberPhone.setError(null);
                            LayPassword.setError(null);
                            LayConfirmPassword.setError(null);
                            if (!isPasswordValid(Password))
                            {
                                LayPassword.setError("Password kurang dari 8 digit!");
                            }
                            else
                            {
                                if (dataSnapshot.child(Username).exists())
                                {
                                    LayUsername.setError("User Telah Digunakan");
                                }
                                else
                                {
                                    if (!Password.equals(ConfirmPassword))
                                    {
                                        LayConfirmPassword.setError("Password tidak sama");
                                    }
                                    else
                                    {
                                        ModelPengguna modelPengguna = new ModelPengguna(Firstname, Lastname, Password, NumberPhone);
                                        databaseReference.child(Username).setValue(modelPengguna);
                                        Toast.makeText(SignUp.this, "User baru berhasil dibuat", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(SignUp.this, SignIn.class));
                                    }
                                }
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

    private boolean isPasswordValid(String password) {
        return password != null && password.length() >= 8;
    }


}
