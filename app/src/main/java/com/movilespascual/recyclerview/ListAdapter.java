package com.movilespascual.recyclerview;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private List<ListaElementos> misDatos;
    private LayoutInflater myInflater;
    private Context myContext;

    private LinearLayout view_detail;


    public ListAdapter(List<ListaElementos> itemList, Context context) {
        this.misDatos = itemList;
        this.myInflater = LayoutInflater.from(context);
        this.myContext = context;
    }


    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = myInflater.inflate(R.layout.list_element,null);
        return new ListAdapter.ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        holder.bindData(misDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return misDatos.size();
    }

    //public void setItems(List<ListaElementos> items){ misDatos= items;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconImage;
        LinearLayout  view_detail;
        TextView name, city, status, letra;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconImage = itemView.findViewById(R.id.iconoImageView);
            name = itemView.findViewById(R.id.nameTextView);
            city = itemView.findViewById(R.id.cityTextView);
            status = itemView.findViewById(R.id.statusTextView);
            letra = itemView.findViewById(R.id.letra);
            view_detail = itemView.findViewById(R.id.view_detail);
        }

        void bindData(final ListaElementos item){
            Drawable unwrappedDrawable = AppCompatResources.getDrawable(myContext, R.drawable.circle_shape);
            Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);
            DrawableCompat.setTint(wrappedDrawable, Color.parseColor(item.getColor()));
            name.setText(item.getName());
            city.setText(item.getCiudad());
            status.setText(item.getEstado());
            letra.setText(item.getLetra());

            view_detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    detail(item);
                }
            });

        }

        protected void detail(ListaElementos item ) {
            Intent intent = new Intent(myContext, DetailEmail.class);
            intent.putExtra("name",item.getName());
            intent.putExtra("ciudad",item.getCiudad());
            intent.putExtra("estado",item.getEstado());
            myContext.startActivity(intent);
        }

    }

}
