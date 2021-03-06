package com.example.dbraga.proyecto3.adapters;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.dbraga.proyecto3.views.activities.MainActivity;
import com.example.dbraga.proyecto3.R;
import com.example.dbraga.proyecto3.views.fragments.PerfilFragment;
import com.example.dbraga.proyecto3.views.fragments.RecyclerViewFragment;
import com.example.dbraga.proyecto3.pojo.Mascota;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dbraga on 22/07/17.
 */

public class MascotaRecyclerViewAdapter extends RecyclerView.Adapter<MascotaRecyclerViewAdapter.MascotaReclyclerViewHolder> {

    private List<Mascota> mascotas;
    private Activity activity;
    private Fragment fragment;

    public MascotaRecyclerViewAdapter(List<Mascota> mascotas, Activity activity, Fragment fragment) {
        this.mascotas = mascotas;
        this.activity=activity;
        this.fragment=fragment;
    }

    @Override
    public MascotaReclyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v=null;
        if((fragment instanceof RecyclerViewFragment )|| fragment==null) {
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_view_item, parent, false);
        }if (fragment instanceof PerfilFragment){
            v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_view_grid_item, parent, false);
        }

        return new MascotaReclyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaReclyclerViewHolder holder,  int position) {
        final Mascota mascota=mascotas.get(position);


        if (fragment instanceof RecyclerViewFragment || fragment == null) {
            holder.imageViewFotoMascota.setImageResource(mascota.getImageRef());
            holder.textViewPetName.setText(mascota.getName());
        } else{
           // holder.imageViewFotoMascota.setImageResource(mascota.getUrlImage());
            Picasso.with(activity).load(mascota.getUrlImage())
                    .placeholder(R.drawable.perro)
                    .into(holder.imageViewFotoMascota);
        }
        holder.textViewLikes.setText(String.valueOf(mascota.getNumeroLikes()));

        final int thisPosition=position;

        if( activity instanceof MainActivity
                && (fragment instanceof RecyclerViewFragment
                || fragment == null)
        ) {
            holder.imageButtonHuesoLikes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Dbra", "onclik");
                    ((RecyclerViewFragment) fragment)
                            .onMascotaIsRated(mascotas.get(thisPosition));
                    mascotas.get(thisPosition)
                            .setNumeroLikes(mascotas.get(thisPosition).getNumeroLikes()+1);

                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaReclyclerViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageViewFotoMascota;
        private TextView textViewPetName;
        private TextView textViewLikes;
        private ImageButton imageButtonHuesoLikes;



        public MascotaReclyclerViewHolder(View itemView) {
            super(itemView);

            imageViewFotoMascota=(ImageView) itemView.findViewById(R.id.imageViewFotoMascota);
            textViewPetName=(TextView) itemView.findViewById(R.id.textViewNamePet);
            textViewLikes= (TextView) itemView.findViewById(R.id.textViewLikes);
            imageButtonHuesoLikes=(ImageButton) itemView.findViewById(R.id.imageButtonHuesoLikes);
        }
    }
}
