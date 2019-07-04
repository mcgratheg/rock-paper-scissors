package com.example.eibhl.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonRock;
    private Button buttonPaper;
    private Button buttonScissors;
    private Button buttonReset;
    private TextView textYouOutput;
    private TextView textOppOutput;
    private TextView textWinner;
    private TextView textYouWins;
    private TextView textOppWins;
    private int opponentChoice;
    private int yourChoice;
    private int yourWins = 0;
    private int opponentWins = 0;

    public void newGame() {
        opponentChoice = (int) (Math.random()*3 + 1);
        String choice = "";
        if (opponentChoice == 1) {
            choice = "Rock";
            textOppOutput.setText(choice);
        } else if (opponentChoice == 2) {
            choice = "Paper";
            textOppOutput.setText(choice);
        } else if (opponentChoice == 3) {
            choice = "Scissors";
            textOppOutput.setText(choice);
        }
    }

    public void playGame() {
        String winner = "";

            if ((yourChoice == 1 && opponentChoice == 2) || (yourChoice == 2 && opponentChoice == 3) || (yourChoice == 3 && opponentChoice == 1)) {
               winner = "Opponent wins!";
               opponentWins++;
               textWinner.setText(winner);
               textOppWins.setText(opponentWins+"");
            } else if ((opponentChoice == 1 && yourChoice == 2) || (opponentChoice == 2 && yourChoice == 3) || (opponentChoice == 3 && yourChoice == 1)) {
                winner = "You win!";
                yourWins++;
                textWinner.setText(winner);
                textYouWins.setText(yourWins+"");
            } else if (yourChoice == opponentChoice) {
                winner = "Tie!";
                textWinner.setText(winner);
            }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonRock = (Button) findViewById(R.id.buttonRock);
        buttonPaper = (Button) findViewById(R.id.buttonPaper);
        buttonScissors = (Button) findViewById(R.id.buttonScissors);
        buttonReset = (Button) findViewById(R.id.buttonReset);
        textYouOutput = (TextView) findViewById(R.id.textYouOutput);
        textOppOutput = (TextView) findViewById(R.id.textOppOutput);
        textWinner = (TextView) findViewById(R.id.textWinner);
        textYouWins = (TextView) findViewById(R.id.textYouWins);
        textOppWins = (TextView) findViewById(R.id.textOppWins);

        buttonRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame();
                yourChoice = 1;
                textYouOutput.setText("Rock");
                playGame();
            }
        });

        buttonPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame();
                yourChoice = 2;
                textYouOutput.setText("Paper");
                playGame();
            }
        });

        buttonScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame();
                yourChoice = 3;
                textYouOutput.setText("Scissors");
                playGame();
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yourWins = 0;
                opponentWins = 0;
                textYouOutput.setText("-");
                textOppOutput.setText("-");
                textWinner.setText("");
                textYouWins.setText(yourWins+"");
                textOppWins.setText(opponentWins+"");
            }
        });
    }
}
