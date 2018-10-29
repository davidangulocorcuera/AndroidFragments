package com.example.biolizard.fragmentstest;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TextViewFragment extends Fragment {
    public TextViewFragment() {
    }

    public static TextViewFragment newInstance() {
        TextViewFragment textViewFragment = new TextViewFragment();
        return textViewFragment;
    }

    public static final String KEY = "KEY";
    private String str_textForSend;
    @BindView(R.id.textView_firstText)
    TextView tv_firstText;
    @BindView(R.id.textView_secondText)
    TextView tv_secondText;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            str_textForSend = getArguments().getString(KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.text_fragment_layout, container, false);
        ButterKnife.bind(this,view);
        updateView(str_textForSend);
        return view;
    }
    public void updateView(String texto){
        if (texto!=null) {
            tv_firstText.setText(texto);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
