package com.java.Projects.TicTacToe;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel(); // to hold titles
    JPanel button_panel = new JPanel(); // to hold buttons
    JLabel testified = new JLabel(); // to display msg
    JButton[] buttons = new JButton[9]; // 9 buttons
    boolean player1_turn;

    TicTacToe() {
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,20, 1000,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());

        testified.setBackground(new Color(25,25,25));
        testified.setForeground(new Color(25,255,0));
        testified.setFont(new Font("Ink Free", Font.BOLD, 75));
        testified.setHorizontalAlignment(JLabel.CENTER);
        testified.setText("Tic-Tac-Toe");
        testified.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(testified);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        testified.setText("O turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        testified.setText("X turn");
                    }
                }

            }

        }
    }
    public void firstTurn() {

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(random.nextInt(2)==0) {
            player1_turn = true;
            testified.setText("O turn");
        }
        else {
            player1_turn = false;
            testified.setText("X turn");
        }
    }
    public void check(){

            if((buttons[0].getText()=="X") &&
                    (buttons[1].getText()=="X") &&
                    (buttons[2].getText()=="X")){
                xWins(0,1,2);
            }
            if((buttons[3].getText()=="X") &&
                    (buttons[4].getText()=="X") &&
                    (buttons[5].getText()=="X")){
                xWins(3,4,5);
            }
            if((buttons[6].getText()=="X") &&
                    (buttons[7].getText()=="X") &&
                    (buttons[8].getText()=="X")){
                xWins(6,7,8);
            }
            if((buttons[0].getText()=="X") &&
                    (buttons[3].getText()=="X") &&
                    (buttons[6].getText()=="X")){
                xWins(0,3,6);
            }
            if((buttons[1].getText()=="X") &&
                    (buttons[4].getText()=="X") &&
                    (buttons[7].getText()=="X")){
                xWins(1,4,7);
            }
            if((buttons[2].getText()=="X") &&
                    (buttons[5].getText()=="X") &&
                    (buttons[8].getText()=="X")){
                xWins(2,5,8);
            }
            if((buttons[0].getText()=="X") &&
                    (buttons[4].getText()=="X") &&
                    (buttons[8].getText()=="X")){
                xWins(0,4,8);
            }
            if((buttons[2].getText()=="X") &&
                    (buttons[4].getText()=="X") &&
                    (buttons[6].getText()=="X")){
                xWins(2,4,6);
            }

            if((buttons[0].getText()=="O") &&
                    (buttons[1].getText()=="O") &&
                    (buttons[2].getText()=="O")){
                oWins(0,1,2);
            }
            if((buttons[3].getText()=="O") &&
                    (buttons[4].getText()=="O") &&
                    (buttons[5].getText()=="O")){
                oWins(3,4,5);
            }
            if((buttons[6].getText()=="O") &&
                    (buttons[7].getText()=="O") &&
                    (buttons[8].getText()=="O")){
                oWins(6,7,8);
            }
            if((buttons[0].getText()=="O") &&
                    (buttons[3].getText()=="O") &&
                    (buttons[6].getText()=="O")){
                oWins(0,3,6);
            }
            if((buttons[1].getText()=="O") &&
                    (buttons[4].getText()=="O") &&
                    (buttons[7].getText()=="O")){
                oWins(1,4,7);
            }
            if((buttons[2].getText()=="O") &&
                    (buttons[5].getText()=="O") &&
                    (buttons[8].getText()=="O")){
                oWins(2,5,8);
            }
            if((buttons[0].getText()=="O") &&
                    (buttons[4].getText()=="O") &&
                    (buttons[8].getText()=="O")){
                oWins(0,4,8);
            }
            if((buttons[2].getText()=="O") &&
                    (buttons[4].getText()=="O") &&
                    (buttons[6].getText()=="O")){
                oWins(2,4,6);
            }
        }

    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        testified.setText("X wins");
    }

    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        testified.setText("O wins");
    }
}