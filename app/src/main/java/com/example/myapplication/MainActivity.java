package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClick(View view) {
        Button buttonSelected = (Button) view;
        int celID = 0;
        switch(buttonSelected.getId()){

            case R.id.button1:celID = 1;
            break;
            case R.id.button2:celID = 2;
                break;
            case R.id.button3:celID = 3;
                break;
            case R.id.button4:celID = 4;
                break;
            case R.id.button5:celID = 5;
                break;
            case R.id.button6:celID = 6;
                break;
            case R.id.button7:celID = 7;
                break;
            case R.id.button8:celID = 8;
                break;
            case R.id.button9:celID = 9;
                break;
        }
        playGame(celID, buttonSelected);
    }

    int activePlayer = 1; // 1 for first, 2 for second
    ArrayList<Integer> player1 = new ArrayList<>(); // hold player 1 data
    ArrayList<Integer> player2 = new ArrayList<>(); // hold player 2 data

    void playGame(int celId, Button buttonSelected){
        buttonSelected.setBackgroundColor(Color.RED);

        Log.d("Player:", String.valueOf(celId));

        if (activePlayer == 1){
            buttonSelected.setText("X");
            buttonSelected.setBackgroundColor(Color.GREEN);
            player1.add(celId);
            activePlayer = 2;
            autoPlay();
        }
        else if (activePlayer == 2){
            buttonSelected.setText("O");
            buttonSelected.setBackgroundColor(Color.BLUE);
            player2.add(celId);
            activePlayer = 1;
        }
        buttonSelected.setEnabled(false);
         checkWinner();
    }

    void checkWinner(){
         int winner = -1;
         // first row
         if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1;
         }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2;
        }

        // second row

        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1;
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2;
        }

        // third row

        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1;
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2;
        }

        // first column

        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1;
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2;
        }

        // second row

        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1;
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2;
        }

        // third row

        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1;
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2;
        }

        if (winner != -1){
            // we have a winner
            if (winner == 1){
                Toast.makeText(this, "Player 1 win the game !", Toast.LENGTH_SHORT).show();
            }
            if (winner == 2){
                Toast.makeText(this, "Player 2 win the game !", Toast.LENGTH_SHORT).show();
            }
        }
    }

    void autoPlay(){
        ArrayList<Integer> emptyCells = new ArrayList<>(); // hold all unselected cells

        // find the empty cells

        for (int cellId = 1; cellId < 10; cellId++){
            if (!(player1.contains(cellId) || player2.contains(cellId))){
                emptyCells.add(cellId);
            }
        }
        Random random = new Random();
        int randomIndex = random.nextInt(emptyCells.size() - 0) + 0;
        int cellId = emptyCells.get(randomIndex);

        Button buttonSelected;
        switch(cellId){

            case 1 : buttonSelected = (Button) findViewById(R.id.button1);
                break;
            case 2 : buttonSelected = (Button) findViewById(R.id.button2);
                break;
            case 3 : buttonSelected = (Button) findViewById(R.id.button3);
                break;
            case 4 : buttonSelected = (Button) findViewById(R.id.button4);
                break;
            case 5 : buttonSelected = (Button) findViewById(R.id.button5);
                break;
            case 6 : buttonSelected = (Button) findViewById(R.id.button6);
                break;
            case 7 : buttonSelected = (Button) findViewById(R.id.button7);
                break;
            case 8 : buttonSelected = (Button) findViewById(R.id.button8);
                break;
            case 9 : buttonSelected = (Button) findViewById(R.id.button9);
                break;
            default:
                buttonSelected = (Button) findViewById(R.id.button1);
        }

        playGame(cellId, buttonSelected);
    }
}