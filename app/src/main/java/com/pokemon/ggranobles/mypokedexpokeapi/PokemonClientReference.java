package com.pokemon.ggranobles.mypokedexpokeapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonClientReference {
    public static Retrofit retrofit;
    public static Retrofit getRetrofitInstance()
    {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://pokeapi.co")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
