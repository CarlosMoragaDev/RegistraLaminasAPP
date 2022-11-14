package com.example.registralaminasapp;

import static com.example.registralaminasapp.DBmain.TABLENAME;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>{
    Context context;
    ArrayList<Album> albumArrayList=new ArrayList<>();
    SQLiteDatabase sqLiteDatabase;
    //generate constructor

    public AlbumAdapter(Context context, int singledata, ArrayList<Album> albumArrayList, SQLiteDatabase sqLiteDatabase) {
        this.context = context;
        this.albumArrayList = albumArrayList;
        this.sqLiteDatabase = sqLiteDatabase;
    }

    @NonNull
    @Override
    public AlbumAdapter.AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.singledata,null);
        return new AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumAdapter.AlbumViewHolder holder, int position) {
        final Album album=albumArrayList.get(position);
        holder.txtnombre.setText(album.getNombre());
        holder.txtnormales.setText(album.getNormales());
        holder.txtespeciales.setText(album.getEspeciales());

        //click on button go to main activity
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putInt("id",album.getId());
                bundle.putString("nombre",album.getNombre());
                bundle.putString("normales",album.getNormales());
                bundle.putString("especiales",album.getEspeciales());
                Intent intent=new Intent(context,AlbumActivity.class);
                intent.putExtra("userdata",bundle);
                context.startActivity(intent);
            }
        });
        //delete row
        holder.delete.setOnClickListener(new View.OnClickListener() {
            DBmain dBmain=new DBmain(context);
            @Override
            public void onClick(View v) {
                sqLiteDatabase=dBmain.getReadableDatabase();
                long delele=sqLiteDatabase.delete(TABLENAME,"id="+album.getId(),null);
                if (delele!=-1){
                    Toast.makeText(context, "deleted data successfully", Toast.LENGTH_SHORT).show();
                    albumArrayList.remove(position);
                    notifyDataSetChanged();
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return albumArrayList.size();
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder {
        TextView txtnombre,txtnormales, txtespeciales;
        Button edit,delete;
        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            txtnombre=(TextView)itemView.findViewById(R.id.txtnombre);
            txtnormales=(TextView)itemView.findViewById(R.id.txtnormales);
            txtespeciales=(TextView)itemView.findViewById(R.id.txtespeciales);
            edit=(Button)itemView.findViewById(R.id.txt_btn_edit);
            delete=(Button)itemView.findViewById(R.id.txt_btn_delete);
        }
    }

}
