package com.pokemon.ggranobles.mypokedexpokeapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonDetail extends AppCompatActivity{

    TextView nameTextView;
    TextView idTextView;
    TextView hpTextView;
    TextView categoryTextView;
    TextView attackTextView;
    TextView spaTextView;
    TextView defenseTextView;
    TextView spdTextView;
    TextView speedTextView;
    TextView weightTextView;
    TextView heightTextView;
    ImageView spriteImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);

        idTextView = (TextView)findViewById(R.id.pokemon_id);
        nameTextView = (TextView)findViewById(R.id.pokemon_name);
        hpTextView = (TextView)findViewById(R.id.pokemon_hp);
        categoryTextView = (TextView)findViewById(R.id.pokemon_category);
        attackTextView = (TextView)findViewById(R.id.pokemon_attack);
        spaTextView = (TextView)findViewById(R.id.pokemon_spa);
        defenseTextView = (TextView)findViewById(R.id.pokemon_defense);
        spdTextView = (TextView)findViewById(R.id.pokemon_spd);
        speedTextView = (TextView)findViewById(R.id.pokemon_speed);
        weightTextView = (TextView)findViewById(R.id.pokemon_weight);
        heightTextView = (TextView)findViewById(R.id.pokemon_height);
        spriteImageView = (ImageView)findViewById(R.id.spriteView);


        String pokemon = (String)getIntent().getStringExtra(PokedexActivity.Pokemon_EXTRA);

        GetPokemonDataService pokemonDataService = (GetPokemonDataService) PokemonClientReference.getRetrofitInstance().create(GetPokemonDataService.class);
        Call<Pokemon> call = pokemonDataService.getPokemon(pokemon);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon>  response) {
                idTextView.setText( "#"+ response.body().getID() );
                nameTextView.setText(response.body().getName() );
                hpTextView.setText("HP: " + response.body().getHP());
                attackTextView.setText("Attack: " + response.body().getAttack());
                spaTextView.setText("Spttack: " + response.body().getSPA());
                defenseTextView.setText("Defense " + response.body().getDefense());
                spdTextView.setText("SpDefense: " + response.body().getSPD());
                speedTextView.setText("Speed: " + response.body().getSpeed());
                weightTextView.setText("Weight: " + response.body().getWeight());
                heightTextView.setText("Height: " + response.body().getHeight());
                categoryTextView.setText("Type(s): " + response.body().getCategory());

                Picasso.get().load(response.body().getSprite()).into(spriteImageView);
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                nameTextView.setText(t.getMessage());
            }
        });
    }
}