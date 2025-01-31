package com.example.contador.taco;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contador.R;

import java.util.List;

public class AlimentoAdapter extends RecyclerView.Adapter<AlimentoAdapter.AlimentoViewHolder> {

    private List<Alimento> listaAlimentos;

    public AlimentoAdapter(List<Alimento> listaAlimentos) {
        this.listaAlimentos = listaAlimentos;
    }

    @NonNull
    @Override
    public AlimentoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alimento, parent, false);
        return new AlimentoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlimentoViewHolder holder, int position) {
        Alimento alimento = listaAlimentos.get(position);
        holder.tvNome.setText(alimento.getNome());
        holder.tvEnergia.setText(alimento.getEnergia() + " kcal");
    }

    @Override
    public int getItemCount() {
        return listaAlimentos.size();
    }

    public void filtrarLista(List<Alimento> listaFiltrada) {
        this.listaAlimentos = listaFiltrada;
        notifyDataSetChanged();
    }


    static class AlimentoViewHolder extends RecyclerView.ViewHolder {
        TextView tvNome, tvEnergia;

        public AlimentoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNome = itemView.findViewById(R.id.tvNome);
            tvEnergia = itemView.findViewById(R.id.tvEnergia);
        }
    }
}
