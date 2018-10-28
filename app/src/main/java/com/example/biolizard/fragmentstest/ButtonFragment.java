package com.example.biolizard.fragmentstest;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ButtonFragment extends Fragment {
    public ButtonFragment(){}
    private OnFragmentInteractionListener onFragmentInteractionListener;
    private String str_firstText;
    private String str_secondText;
    @BindView(R.id.button_firstText)
    Button btn_firstText;
    @BindView(R.id.button_secondText)
    Button btn_secondText;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        str_firstText = "Hola";
        str_secondText = "¿Qué tal?";
    }
    public interface OnFragmentInteractionListener {
        void changeText(String texto);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.button_fragment_layout, container, false);

        ButterKnife.bind(view);
        return  view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            onFragmentInteractionListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onFragmentInteractionListener = null;
    }
   public void clickListener(){
        btn_firstText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFragmentInteractionListener.changeText(str_firstText);
            }
        });
        btn_secondText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFragmentInteractionListener.changeText(str_secondText);
            }
        });

    }



}
