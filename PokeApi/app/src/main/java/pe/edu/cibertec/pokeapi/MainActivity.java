package pe.edu.cibertec.pokeapi;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        TextInputEditText etPokemon;
        Button btBurcar;
        TextView tvName, tvWeight, tvHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPokemon = findViewById(R.id.etPokemon);
        btBurcar = findViewById(R.id.btBuscar);
        tvName = findViewById(R.id.tvName);
        tvWeight = findViewById(R.id.tvWeight);
        tvHeight = findViewById(R.id.tvHeight);

        btBurcar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String input = etPokemon.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                // retrofit es un servicio web  para llamar http , manejo de hilos
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokemonInterface pokemonInterface = retrofit.create(PokemonInterface.class);

        Call<Pokemon> searchMethod = pokemonInterface.getPokemon(input);

        searchMethod.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                if (response.isSuccessful()){
                    Pokemon pokemon = response.body();
                    tvName.setText(pokemon.getName());
                    tvWeight.setText(String.valueOf(pokemon.getWeight()));
                    tvHeight.setText(String.valueOf(pokemon.getHeight()));

                }
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {

            }
        });

    }
}
