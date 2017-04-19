package com.example.echo.filmes_at_cinema1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.GregorianCalendar;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // ArrayList, estrutura de dados contendo os Filmes vistos
    // Filme é uma Classe ??????
    ArrayList<Filme> alFilmes;
    // ArrayAdapter é um adaptador para vincular arrays e views,
    // Pode ser usado com List Views e Spinners
    ArrayAdapter<Filme> aaListaFilmes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Cria o ArrayList de Objetos da Classe Filme
        alFilmes = new ArrayList<Filme>();

        // Cria o Filme
        Filme Filme1 = new Filme("O Poderoso Chefão", "UCI", "Ação", 2016, 30, 12);
        Filme Filme2 = new Filme("Emanuelle", "Cime Band Prive", "Adulto", 2001, 22, 15);
        Filme Filme3 = new Filme("Constantine", "K7", "Terror", 1998, 30, 12);
        Filme Filme4 = new Filme("Madrugada Muito Louca", "DVD", "Comédia", 2004, 01, 02);

        // Adiciona Filmes para popupar a Base
        alFilmes.add(Filme1);
        alFilmes.add(Filme2);
        alFilmes.add(Filme3);
        alFilmes.add(Filme4);

        // Associar o elemento da UI com a variável
        ListView lvListaFilmes = (ListView) findViewById(R.id.lvListaFilmes);
        // Corelaciona o ArrayAdapter com ListView
        aaListaFilmes = new ArrayAdapter<Filme>(this, android.R.layout.simple_list_item_1, alFilmes);
        // Mostra a ListView de Filmes e seta
        lvListaFilmes.setAdapter(aaListaFilmes);
        // Usará o retorno do toString para Determinar o Texto que será exibido

        // VER !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // criar um listener para os eventos de onClick nos items da listview
        lvListaFilmes.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view, int posicao, long id) {
                        // Exemplo de uso do toast para exibir pequenas mensagens
                        String s = ((TextView) view).getText() + " - " + posicao;
                        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                        // aqui chamaria outra activity usando intents (startActivity)
                        // para mostrar os detalhes de data, comentários etc do filme em questão
                        // simulando a exibição com o toast
                    }
                }
        );
    }


    public void onClickAdicionar (View view){
        // aqui chamaria um outra activity usando intents (startActivityForResult)
        // na função onActivityResult que pega o retorno, teria  que criar o objeto
        // filme a ser adicionado com os campos do retorno
        // simulado com as duas linhas a seguir
        String nome = "Filme Teste " + alFilmes.size();

        // Cria um Novo Filme
        Filme FilmeN = new Filme(nome, "DVD", "Comédia", new GregorianCalendar());
        // Adiciona o Novo Filme
        alFilmes.add(FilmeN);

        // avisa o Adaptador que os dados mudaram, logo a view que mostra os dados precisa ser atualizada
        aaListaFilmes.notifyDataSetChanged();
        Toast.makeText(getApplicationContext(), "Adicionado " + nome, Toast.LENGTH_SHORT).show();

    }


}
