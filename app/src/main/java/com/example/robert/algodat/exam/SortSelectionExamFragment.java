package com.example.robert.algodat.exam;


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

public class SortSelectionExamFragment extends Fragment {

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
    private int previous = -1;
    private Button okButton;

    public SortSelectionExamFragment() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.sort_selection_fragment, container, false);


        wrongTextView = (TextView)rootView.findViewById(R.id.wrongTextView);
        wrongTextView.setVisibility(View.INVISIBLE);


        okButton = (Button) rootView.findViewById(R.id.okButton);
        okButton.setText("Choose Number");
        okButton.setEnabled(false);

        for(int i = 0; i < button.length; i++) {
            button[i] = (Button) rootView.findViewById(idArray[i]);
            button[i].setText(String.format("%s", randNums[i]));
            button[i].setBackgroundColor(Color.LTGRAY);
            button[i].setTextSize(17);
            button[i].setPadding(1,0,1,0);
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
                            okButton.setText("Switch " + button[k].getText() + " with " + button[next].getText() + " ?");
                            pos = k;
                            if(previous != -1) {
                                button[k].setBackgroundColor(Color.RED);
                                button[k].setTextColor(Color.WHITE);
                                button[k].setEnabled(false);
                                if(k != previous){
                                    button[previous].setBackgroundColor(Color.LTGRAY);
                                    button[previous].setTextColor(Color.BLACK);
                                    button[previous].setEnabled(true);
                                    previous = k;
                                }
                            }else{
                                button[k].setBackgroundColor(Color.RED);
                                button[k].setTextColor(Color.WHITE);
                                button[k].setEnabled(false);
                                previous = k;
                            }

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
                                        .replace(R.id.exam_view1, new SortSelectionExamFragment())
                                        .commit();
                            }

                            if(sortedNums[next] == Integer.parseInt(button[pos].getText().toString())){
                                help = button[next].getText().toString();
                                button[next].setText(button[pos].getText());
                                button[pos].setText(help);
                                button[next].setEnabled(false);
                                button[next].setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorCorrect));
                                button[++next].setBackgroundColor(Color.RED);
                                button[next].setTextColor(ColorStateList.valueOf(Color.WHITE));
                            }else
                                wrongTextView.setVisibility(View.VISIBLE);

                            okButton.setText("Choose Number");
                            okButton.setEnabled(false);
                            button[previous].setBackgroundColor(Color.LTGRAY);
                            button[previous].setTextColor(Color.BLACK);
                            button[previous].setEnabled(true);
                        }
                    }
            );

        }


        return rootView;
    }
}
