package com.br.pedro.bruno.atmconsultoria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.br.pedro.bruno.atmconsultoria.databinding.ActivityMainBinding;

import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               enviarEmail();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal,R.id.nav_servico,R.id.nav_clientes,R.id.nav_contato,R.id.nav_sobre
                )
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    private void enviarEmail() {

        //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:31986773153"));
        //Intent intent = new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto: 31986773153"));
        //intent.putExtra(Intent.EXTRA_TEXT,"Essa mensagem foi enviada pelo meu app");
        //intent.setPackage("com.whatsapp");

        //Intent intent = new Intent(Intent.ACTION_SENDTO);
        Intent intent = new Intent(Intent.ACTION_VIEW);
       // intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"atendimento@atmconsultoria.com.br"});
        //intent.putExtra(Intent.EXTRA_SUBJECT,"Contato pelo app");
        //intent.putExtra(Intent.EXTRA_TEXT,"Mensagem automática");
        //intent.setType("message/rfc822");
        String url = "https://api.whatsapp.com/send?phone=5531986773153"+"&text="+ URLEncoder.encode("Tenho uma proposta :)");
        intent.setPackage("com.whatsapp");
        intent.setData(Uri.parse(url));
        startActivity(Intent.createChooser(intent,"Me contrate"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}