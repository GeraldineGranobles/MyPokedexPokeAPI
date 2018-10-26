package com.pokemon.ggranobles.mypokedexpokeapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetPokemonDataService {
    @GET("api/v2/pokemon/{name}/")
    Call<Pokemon> getPokemon(@Path("name") String name);
}
