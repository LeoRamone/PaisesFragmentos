package com.leonardo_soares_santos.paisesfragmentos.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.leonardo_soares_santos.paisesfragmentos.PaisAdapter;
import com.leonardo_soares_santos.paisesfragmentos.R;
import com.leonardo_soares_santos.paisesfragmentos.model.Pais;

public class ListaPaisesActivity extends Activity {
    public static final String PAIS = "com.leonardo";
    Activity atividade;
    Pais[] paises;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);
        atividade = this;
        Intent intent = getIntent();

        paises = (Pais[]) intent.getSerializableExtra(MainActivity.PAISES);

        ListView listView = (ListView) findViewById(R.id.lista_paises);
        PaisAdapter adapter = new PaisAdapter(paises, this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // manda para a tela de detalhe
                Intent intent = new Intent(atividade, DetalhePaisActivity.class);
                intent.putExtra(PAIS, paises[position]);

                startActivity(intent);

            }

        });
    }
}
