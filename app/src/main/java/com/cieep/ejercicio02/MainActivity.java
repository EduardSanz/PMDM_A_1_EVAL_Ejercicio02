package com.cieep.ejercicio02;

import android.content.Intent;
import android.os.Bundle;

import com.cieep.ejercicio02.adapters.ContactoMatriculasAdapter;
import com.cieep.ejercicio02.modelos.ContactoMatricula;
import com.google.android.material.snackbar.Snackbar;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;



import com.cieep.ejercicio02.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;

    private ArrayList<ContactoMatricula> contactoMatriculas;
    private ActivityResultLauncher<Intent> launcherCrear;

    private ContactoMatriculasAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        contactoMatriculas = new ArrayList<>();

        adapter = new ContactoMatriculasAdapter(contactoMatriculas, R.layout.contacto_matricula_view_holder, this);
        layoutManager = new GridLayoutManager(this, 1);

        binding.contentMain.contenedor.setLayoutManager(layoutManager);
        binding.contentMain.contenedor.setAdapter(adapter);

        launcherCrear = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            ContactoMatricula cm = (ContactoMatricula) result.getData().getExtras().getSerializable("CM");
                            contactoMatriculas.add(cm);
                            adapter.notifyItemInserted(contactoMatriculas.size()-1);
                        }
                    }
                }
        );

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherCrear.launch(new Intent(MainActivity.this, CrearContacoMatriculaActivity.class));
            }
        });
    }

}