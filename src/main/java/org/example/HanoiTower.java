package org.example;//Don't change anything in this file

import java.util.Scanner;

/**
 * The class <b>HanoiTower</b> is the class that implements the actual Hanoi Tower 
 * Game. The class controls how a two players will play. It also asks the players 
 * if they wants to continue playing once each player played one game.
 * This class will be used as test for the playing the game between two players.
 * This class will be invoked from the command prompt: java HanoiTower args1 args2 ...
 */

public class HanoiTower {

    public static void main(String[] args) {
        HanoiTowerGame game;
        int disks=3;
        
        // check the arguments and use the correct value
        if (args.length > 0) {
            disks=Math.max(Integer.valueOf(args[0]),1);
            if (args.length > 1)
                System.out.println("Too many arguments. Only the first one is used.");
        }

        Scanner scanner = new Scanner(System.in);
        String userInput;

        Player[] players = { new HumanPlayer(), new HumanPlayer() };
        do {
            System.out.println("\nPlayer 1 turn------->");
            game = new HanoiTowerGame(disks);
            players[0].play(game); // calls play from HumanPlayer 1

            System.out.println("\nPlayer 2 turn------->");
            game = new HanoiTowerGame(disks);
            players[1].play(game); // calls play from HumanPlayer 2

            
            System.out.println("Player 1 score: "+players[0].getScore());
            System.out.println("Player 2 score: "+players[1].getScore());
            disks++;
            System.out.println("Do you want to play again?! enter y or Y");
            System.out.println("Number of disks will be increased by 1!!");
            userInput = scanner.nextLine().trim();
        } while (userInput.equalsIgnoreCase("y"));
        scanner.close();
    }

}
