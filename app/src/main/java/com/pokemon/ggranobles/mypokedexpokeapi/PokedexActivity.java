package com.pokemon.ggranobles.mypokedexpokeapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PokedexActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    public static final String Pokemon_EXTRA = "com.pokemon.android.mypokedex";

    private List<String> pokemonList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.pokemon_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(PokedexActivity.this));

        requestObject();
    }
    private void requestObject(){

        pokemonList.add("bulbasaur");
        pokemonList.add("ivysaur");
        pokemonList.add("venusaur");
        pokemonList.add("squirtle");
        pokemonList.add("wartortle");
        pokemonList.add("blastoise");
        pokemonList.add("charmander");
        pokemonList.add("charmeleon");
        pokemonList.add("charizard");
        pokemonList.add("caterpie");


        PokemonAdapter adapter = new PokemonAdapter(pokemonList);
        mRecyclerView.setAdapter(adapter);
    }
}
