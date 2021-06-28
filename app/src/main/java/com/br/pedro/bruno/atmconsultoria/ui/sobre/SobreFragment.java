package com.br.pedro.bruno.atmconsultoria.ui.sobre;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.br.pedro.bruno.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;


public class SobreFragment extends Fragment {

    public SobreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String descricao = "O app ATM consultoria foi desenvolvido por Pedro Bruno, para aprimorar " +
                "os conhecimentos am java android.";

        Element versao = new Element();
        versao.setTitle("Versão 1.0");
       // return inflater.inflate(R.layout.fragment_sobre, container, false);
        View aboutPage = new AboutPage(getActivity())
                .setImage(R.drawable.logo)
                .setDescription(descricao)
                .addGroup("Entre em Contato")
                .addEmail("pbruno1283@gmail.com","Envie um e=mail")
                .addGroup("Redes sociais")
                .addGitHub("pbfn","GitHub")
                .addInstagram("pedrobrunof","Instagram")
                .addItem(versao)
                .create();
        return aboutPage;
    }
}