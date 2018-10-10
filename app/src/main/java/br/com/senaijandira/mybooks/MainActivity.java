package br.com.senaijandira.mybooks;

import android.app.AlertDialog;
import android.arch.persistence.room.Room;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import br.com.senaijandira.mybooks.adapter.LivroAdapter;
import br.com.senaijandira.mybooks.db.MyBooksDatabase;
import br.com.senaijandira.mybooks.fragments.BibliotecaGeralFragment;
import br.com.senaijandira.mybooks.fragments.LivrosLidosFragment;
import br.com.senaijandira.mybooks.fragments.LivrosParaLerFragment;
import br.com.senaijandira.mybooks.model.Livro;

public class MainActivity extends AppCompatActivity {



    TabLayout tab_menu;

    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();

        //** Código para o TAB MENU **/
        TabLayout tab_menu = findViewById(R.id.tab_menu);

        abrirBibliotecaGeral();

        abrirLivrosLidos();

        abrirLivrosParaLer();

        tab_menu.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            //Quando seleciona
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if (tab.getPosition() == 0){
                   abrirBibliotecaGeral();
                }

                if (tab.getPosition() == 1){
                    abrirLivrosLidos();
                }

                if (tab.getPosition() == 2){
                    abrirLivrosParaLer();
                }
            }

            //Quando deseleciona
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            //Seleciona novamente
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }


    public void abrirBibliotecaGeral() {

        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.frame_layout, new BibliotecaGeralFragment());

        ft.commit();
    }

    public void abrirLivrosLidos() {

        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.frame_layout, new LivrosLidosFragment());

        ft.commit();
    }

    public void abrirLivrosParaLer() {

        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.frame_layout, new LivrosParaLerFragment());

        ft.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }


    public void abrirCadastro(View v){
        startActivity(new Intent(this,
                CadastroActivity.class));
    }

}
