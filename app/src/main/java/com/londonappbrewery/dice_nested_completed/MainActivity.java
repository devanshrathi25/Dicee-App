package com.londonappbrewery.dice_nested_completed;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
   public int number;
   public int integer;
   public TextView myText;
   Toast mToastMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView leftDice = (ImageView)findViewById(R.id.image_leftDice);
        final ImageView rightDice = (ImageView)findViewById(R.id.image_rightDice);

        Button myButton;
        myButton=(Button)findViewById(R.id.rollButton);
        myText=(TextView) findViewById(R.id.textView);




        final int[] diceArray = new int[] {
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        };

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random randomNumberGenerator = new Random();
                 number = randomNumberGenerator.nextInt(6);

                Log.d("Dicee", "The number is " + number );

                leftDice.setImageResource(diceArray[number]);


                integer = randomNumberGenerator.nextInt(6);


                rightDice.setImageResource(diceArray[integer]);

                int sum= number + integer + 2;
                myText.setText("Your Score is: " + String.valueOf(sum));

                if(number==integer){
                   MediaPlayer mediaplayer = MediaPlayer.create(MainActivity.this, R.raw.note2_d);//You Can Put Your File Name Instead Of abc
                    mediaplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.reset();
                            mediaPlayer.release();
                        }
                    });
                    mediaplayer.start();

                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

                     alert.setTitle("Whoopee!!");
                    alert.setMessage("Wanna continue playing?");
                     alert.setCancelable(false);
                    alert.setPositiveButton("Nope!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    alert.setNegativeButton("Yup!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    alert.show();
                }


            }
        });





    }

}
