package com.example.dbraga.proyecto3.views.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dbraga.proyecto3.R;
import com.example.dbraga.proyecto3.presenters.IConfigActivityPresenter;
import com.example.dbraga.proyecto3.presenters.impl.CofigActivityPresenterImpl;
import com.example.dbraga.proyecto3.views.activities.viewmodel.IConfigActivityViewModel;

public class ConfigActivity extends AppCompatActivity implements IConfigActivityViewModel{

    private TextInputEditText nombreUsuarioEditText;
    private Button validarButton;
    private IConfigActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        nombreUsuarioEditText = (TextInputEditText) findViewById(R.id.editTextUsuario);
        validarButton = (Button) findViewById(R.id.validarButton);

        presenter = new CofigActivityPresenterImpl(this,getApplicationContext());


    }

    @Override
    public void onBackPressed() {
        presenter.onBackPresed();
    }

    public void validar() {
        validarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = nombreUsuarioEditText.getText().toString();
                presenter.obtenerID(usuario);

            }
        });
    }

    @Override
    public void setBack() {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
