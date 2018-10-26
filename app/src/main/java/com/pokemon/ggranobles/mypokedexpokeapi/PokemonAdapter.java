package com.pokemon.ggranobles.mypokedexpokeapi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonHolder>{
    private List<String> mPokemonList;
    public PokemonAdapter(List<String> pokemonList ){ mPokemonList = pokemonList;}

    @Override
    public  PokemonHolder onCreateViewHolder(ViewGroup parent, int viewtype) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View pokemonView = inflater.inflate(R.layout.pokemon_list, parent, false);

        PokemonHolder pokemonHolder = new PokemonHolder(pokemonView);

        return pokemonHolder;
    }

    @Override
    public void onBindViewHolder(PokemonAdapter.PokemonHolder pokemonHolder, int position) {
        String poke = mPokemonList.get(position);

        TextView titleTextView = pokemonHolder.pokemonTitleTextView;
        titleTextView.setText(poke);
    }

    public class PokemonHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView pokemonTitleTextView;

        public PokemonHolder(View itemView) {
            super(itemView);
            pokemonTitleTextView = (TextView)itemView.findViewById(R.id.poke_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String news = mPokemonList.get(getLayoutPosition());
            Intent intent = new Intent(itemView.getContext(), PokemonDetail.class);
            intent.putExtra(PokedexActivity.Pokemon_EXTRA, news);
            itemView.getContext().startActivity(intent);
        }
    }
    @Override
    public int getItemCount() {
        return mPokemonList.size();
    }
}