package com.example.garage.chat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.garage.R;
import com.example.garage.home.home;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

public class chat extends Fragment implements View.OnClickListener {

    BottomNavigationView navbar;
    TextView screenTitle;
    ImageButton backBtn, chatbtn;

    public chat() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        navbar = getActivity().findViewById(R.id.bottomNav);
        navbar.setVisibility(View.GONE);

        chatbtn = getActivity().findViewById(R.id.chatBtn);
        chatbtn.setVisibility(View.GONE);

        backBtn = getActivity().findViewById(R.id.backBtn);
        backBtn.setVisibility(View.VISIBLE);
        backBtn.setOnClickListener(this);

        screenTitle = getActivity().findViewById(R.id.screenTitle);
        screenTitle.setText("Chats");

        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    public void onClick(View view) {
        if (view == backBtn) {
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.relative, new home());
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}