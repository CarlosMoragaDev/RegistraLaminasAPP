package com.example.registralaminasapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>{
    private List<Album> items;

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {
        public ImageView portada;
        public TextView lNormales;
        public TextView lEspeciales;
        public Button btnDetail;

        public AlbumViewHolder(View v) {
            super(v);
            portada = (ImageView) v.findViewById(R.id.portada);
            lNormales = (TextView) v.findViewById(R.id.lNormales);
            lEspeciales = (TextView) v.findViewById(R.id.lEspeciales);
            btnDetail = (Button) v.findViewById(R.id.btnDetail);

        }
    }

    public AlbumAdapter(List<Album> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.album_layout, viewGroup, false);
        return new AlbumViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder viewHolder, int i) {
        viewHolder.portada.setImageResource(items.get(i).getPortada());
        viewHolder.lNormales.setText("Laminas normales" + " " + items.get(i).getlNormales());
        viewHolder.lEspeciales.setText("Laminas especiales" + " " +items.get(i).getlEspeciales());
        viewHolder.btnDetail.setText("Ver Detalles" + " " +items.get(i).getBtnDetail());
    }

}
