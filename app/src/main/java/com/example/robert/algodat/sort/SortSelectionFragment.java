package com.example.robert.algodat.sort;


import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.robert.algodat.R;


public class SortSelectionFragment extends Fragment {

    private static final int[] idArray ={ R.id.button0, R.id.button1,
                                        R.id.button2, R.id.button3, R.id.button4,
                                        R.id.button5, R.id.button6 };
    private Button[] button = new Button[idArray.length];
    TextView wrongTextView;
    private int pos;
    private int next = 0;
    private String help;
    final int[] randNums = {21, 23, 7, 9, 2, 3, 4};
    final int[] sortedNums = {2, 3, 4, 7, 9, 21, 23};

    public SortSelectionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.sort_selection_fragment, container, false);


        wrongTextView = (TextView)rootView.findViewById(R.id.wrongTextView);
        wrongTextView.setVisibility(View.INVISIBLE);


        final Button okButton = (Button) rootView.findViewById(R.id.okButton);
        okButton.setText("Choose Number");
        okButton.setEnabled(false);

        for(int i = 0; i < button.length; i++) {
            button[i] = (Button) rootView.findViewById(idArray[i]);
            button[i].setText(String.format("%s", randNums[i]));
        }

        button[next].setBackgroundColor(Color.RED);
        button[next].setTextColor(ColorStateList.valueOf(Color.WHITE));

        for(int l = 0; l < button.length && l <= next; l++) {
            for (int i = 0; i < button.length; i++) {
                final int k = i;

                button[k].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (k > next) {
                            wrongTextView.setVisibility(View.INVISIBLE);
                            okButton.setEnabled(true);
                            okButton.setText("Switch with " + button[k].getText() + " ?");
                            pos = k;
                        }
                    }
                });
            }

            okButton.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(next+2 == button.length){
                                getFragmentManager().beginTransaction()
                                        .replace(R.id.sort_selection_content, new SortSelectionFragment())
                                        .commit();
                            }

                            if(sortedNums[next] == Integer.parseInt(button[pos].getText().toString())){
                                help = button[next].getText().toString();
                                button[next].setText(button[pos].getText());
                                button[pos].setText(help);
                                button[next].setEnabled(false);
                                button[next].setBackgroundColor(Color.BLACK);
                                button[next].setTextColor(ColorStateList.valueOf(Color.GREEN));
                                button[++next].setBackgroundColor(Color.RED);
                                button[next].setTextColor(ColorStateList.valueOf(Color.WHITE));

                            }else
                                wrongTextView.setVisibility(View.VISIBLE);

                            okButton.setText("Choose Number");
                            okButton.setEnabled(false);
                        }
                    }
            );

        }


        return rootView;
    }

}
