package com.harshs.braintrainer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView timerTextView;
    TextView scoreTextView;
    TextView sumTextView;
    GridLayout gridLayout;
    Button playAgainButton;
    Button goButton;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAnswer;

    public void goButtonFunction(View view ){

        Log.i("Connection","Successful");
        final MediaPlayer mediaPlayer= MediaPlayer.create(this, R.raw.airhorn);

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

        new CountDownTimer(3000 + 100,1000){
            @Override
            public void onTick(long millisUntilFinished) {

                Log.i("Tik", "Tok");
                String second = Long.toString(millisUntilFinished /1000);

                if(millisUntilFinished < 10){

                    second = "0 " + Long.toString(millisUntilFinished);

                }
                timerTextView.setText("0 : " + second );
            }

            @Override
            public void onFinish() {

             playAgainButton = (Button) findViewById(R.id.playAgainButton);
               Log.i("Finished", "True");
                timerTextView.setText("0 : 00");
                playAgainButton.setVisibility(View.VISIBLE);
                mediaPlayer.start();

            }
        }.start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sumTextView = (TextView) findViewById(R.id.sumTextView);
        Button option1 = (Button) findViewById(R.id.button0);
        Button option2 = (Button) findViewById(R.id.button1);
        Button option3 = (Button) findViewById(R.id.button2);
        Button option4 = (Button) findViewById(R.id.button3);


        int a = new Random().nextInt(21);
        int b = new Random().nextInt(21);

        sumTextView.setText(a+" + "+b);

        locationOfCorrectAnswer = new Random().nextInt(4);

        int incorrectAnswer;

        for (int i = 0 ; i < 4; i++){

            if(i == locationOfCorrectAnswer){

                answers.add(a+b);

            }else {

                incorrectAnswer = new Random().nextInt(51);

                while (incorrectAnswer == a + b){

                    incorrectAnswer = new Random().nextInt(51);
                }

                answers.add(incorrectAnswer);

            }
            }
        option1.setText(Integer.toString(answers.get(0)));
        option2.setText(Integer.toString(answers.get(1)));
        option3.setText(Integer.toString(answers.get(2)));
        option4.setText(Integer.toString(answers.get(3)));




    }
}
