package com.cieep.ejercicio02.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.cieep.ejercicio02.R;
import com.cieep.ejercicio02.modelos.ContactoMatricula;

import java.util.List;

public class ContactoMatriculasAdapter extends RecyclerView.Adapter<ContactoMatriculasAdapter.CMVH> {

    private List<ContactoMatricula> objects;
    private int resource;
    private Context context;

    public ContactoMatriculasAdapter(List<ContactoMatricula> objects, int resource, Context context) {
        this.objects = objects;
        this.resource = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public CMVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cmView = LayoutInflater.from(context).inflate(resource, null);
        cmView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new CMVH(cmView);
    }

    @Override
    public void onBindViewHolder(@NonNull CMVH holder, int position) {
        ContactoMatricula cm = objects.get(position);
        holder.lblNombre.setText(cm.getNombreAlumno());
        holder.lblTelefono.setText(cm.getTelefono());
        holder.lblCiclo.setText(cm.getCiclo());

        holder.btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDelete(cm, holder.getAdapterPosition()).show();
            }
        });
    }

    private AlertDialog confirmDelete(ContactoMatricula cm, int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle("SEGURO");
        builder.setCancelable(false);
        builder.setNegativeButton("CANCELAR", null);
        builder.setPositiveButton("ELIMINAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                objects.remove(cm);
                notifyItemRemoved(position);
            }
        });

        return builder.create();
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class CMVH extends RecyclerView.ViewHolder {

        TextView lblNombre, lblCiclo, lblTelefono;
        ImageButton btnEliminar;

        public CMVH(@NonNull View itemView) {
            super(itemView);

            lblNombre = itemView.findViewById(R.id.lblNombreCard);
            lblCiclo = itemView.findViewById(R.id.lblCicloCard);
            lblTelefono = itemView.findViewById(R.id.lblTelefonoCard);
            btnEliminar = itemView.findViewById(R.id.btnDeleteCard);
        }
    }
}
