package com.example.garage.settings;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.garage.R;
import com.example.garage.WelcomeScreen;
import com.example.garage.user.user;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class settings extends Fragment implements View.OnClickListener {

    FirebaseAuth auth;

    TextView screenTitle;
    ImageButton settingsBtn, backBtn;
    BottomNavigationView navBar;
    Button signoutBtn;

    public settings() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        auth = FirebaseAuth.getInstance();

        screenTitle = getActivity().findViewById(R.id.screenTitle);

        settingsBtn = getActivity().findViewById(R.id.settingsBtn);
        settingsBtn.setVisibility(View.GONE);

        backBtn = getActivity().findViewById(R.id.backBtn);
        backBtn.setOnClickListener(this);
        backBtn.setVisibility(View.VISIBLE);

        signoutBtn = view.findViewById(R.id.signoutBtn);
        signoutBtn.setOnClickListener(this);

        navBar = getActivity().findViewById(R.id.bottomNav);
        navBar.setVisibility(View.INVISIBLE);

        return view;
    }

    @Override
    public void onClick(View view) {

        if (view == backBtn) {
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.frame, new user());
            transaction.addToBackStack(null);
            transaction.commit();
        }

        else if (view == signoutBtn) {
            auth.signOut();
            Intent intent = new Intent(getActivity(), WelcomeScreen.class);
            startActivity(intent);
            getActivity().finish();
        }
    }
}