package com.harshs.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView timerTextView;
    TextView scoreTextView;
    TextView sumTextView;
    GridLayout gridLayout;
    Button playAgainButton;
    Button goButton;

    public void goButtonFunction(View view ){

        Log.i("Connection","Successful");

        timerTextView = (TextView) findViewById(R.id.timerTextView);
        timerTextView.setVisibility(View.VISIBLE);

        scoreTextView = (TextView) findViewById(R.id.scoreTextView);
        scoreTextView.setVisibility(View.VISIBLE);

        sumTextView = (TextView) findViewById(R.id.sumTextView);
        sumTextView.setVisibility(View.VISIBLE);

        gridLayout= (GridLayout) findViewById(R.id.gridLayout);
        gridLayout.setVisibility(View.VISIBLE);

        goButton = (Button) findViewById(R.id.goButton);
        goButton.setVisibility(View.INVISIBLE);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
