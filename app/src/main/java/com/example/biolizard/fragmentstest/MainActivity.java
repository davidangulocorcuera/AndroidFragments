package com.example.biolizard.fragmentstest;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ButtonFragment.OnFragmentInteractionListener {
    private Bundle data;
    private ButtonFragment buttonFragment;
    private TextViewFragment textViewFragment;
    private TextViewFragment textViewFragment2;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(savedInstanceState);
    }

    public void loadFragment(Bundle savedInstanceState) {
        if (findViewById(R.id.fragments_layout) != null) {
            if (savedInstanceState != null) {
                return;
            }
            ButtonFragment buttonFragment = new ButtonFragment();
            buttonFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragments_layout, buttonFragment).commit();
        }
    }

    @Override
    public void changeText(String texto) {
        textViewFragment = (TextViewFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_text);

        if (textViewFragment != null) {
            textViewFragment.updateView(texto);
        } else {
            textViewFragment2 = TextViewFragment.newInstance();
            data = new Bundle();
            data.putString(textViewFragment.KEY, texto);
            textViewFragment2.setArguments(data);

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragments_layout, textViewFragment2);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}
