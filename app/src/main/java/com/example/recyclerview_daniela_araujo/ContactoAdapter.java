package com.example.recyclerview_daniela_araujo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder> {

    private ArrayList<Contacto> contactos;
    private Context context;

    public ContactoAdapter(Context context, ArrayList<Contacto> contactos) {
        this.context = context;
        this.contactos = contactos;
    }

    @NonNull
    @Override
    public ContactoAdapter.ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContactoViewHolder(LayoutInflater.from(context).inflate(R.layout.item_contacto, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        Contacto contacto = contactos.get(position);
        holder.nombre.setText(contacto.getNombre());
        holder.apellidos.setText(contacto.getApellidos());
        holder.email.setText(contacto.getEmail());
        holder.telefono.setText(contacto.getTelefono());
        holder.foto.setImageResource(contacto.getFoto());
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder {
        ImageView foto;
        TextView nombre, apellidos, email, telefono;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.fotoContacto);
            nombre = itemView.findViewById(R.id.nombreContacto);
            apellidos = itemView.findViewById(R.id.apellidosContacto);
            email = itemView.findViewById(R.id.emailContacto);
            telefono = itemView.findViewById(R.id.telefonoContacto);
        }
    }
}