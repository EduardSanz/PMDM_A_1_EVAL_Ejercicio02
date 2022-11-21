package com.cieep.ejercicio02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cieep.ejercicio02.databinding.ActivityCrearContacoMatriculaBinding;
import com.cieep.ejercicio02.modelos.ContactoMatricula;

public class CrearContacoMatriculaActivity extends AppCompatActivity {

    private ActivityCrearContacoMatriculaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCrearContacoMatriculaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnCrearCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = binding.txtNombreCrear.getText().toString();
                String telefono = binding.txtTelefonoCrear.getText().toString();

                if (!nombre.isEmpty() && !telefono.isEmpty() && binding.spCiclosCrear.getSelectedItemPosition() != 0) {
                    ContactoMatricula cm = new ContactoMatricula(nombre, (String) binding.spCiclosCrear.getSelectedItem(), telefono);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("CM", cm);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}