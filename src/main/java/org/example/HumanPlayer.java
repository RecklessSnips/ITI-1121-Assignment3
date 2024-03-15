package org.example;//Student 1 full name:
//Student 2 full name:
//==================================================

import java.util.Scanner;

/**
 * The class <b>HumanPlayer</b> is the class that controls the human's plays.
 * ... some more details here
 * 
 */


public class HumanPlayer implements Player {

    private int score = 0;

    public void play(HanoiTowerGame hanoiTowerGame){
        System.out.println("Your goal is to move 2 disks from tower 1 to 3" +
                Utils.NEW_LINE +
                "Only one simple rule: no large disk on the top of a smaller one!" +
                Utils.NEW_LINE);
        // 打印出所有的塔
        System.out.println(hanoiTowerGame);
        Scanner scanner = new Scanner(System.in);
        while(hanoiTowerGame.getGameState() == GameState.PLAYING) {
            if (hanoiTowerGame.getLevel() > hanoiTowerGame.getMaxLevels()){
                System.out.println("You ran out of chance, restart!");
                return;
            }
            System.out.println("Enter the source and the destination towers each on a single line:" +
                    Utils.NEW_LINE);
            System.out.print("Source tower: " + Utils.NEW_LINE);
            int source = scanner.nextInt();

            System.out.print("Destination tower: " + Utils.NEW_LINE);
            int destination = scanner.nextInt();

            // -1 因为塔的坐标是0 到 2
            hanoiTowerGame.play(source - 1, destination - 1);
            System.out.println(hanoiTowerGame);
            System.out.println("You have moved " + hanoiTowerGame.getLevel()
                    + " times. Max moves: " + hanoiTowerGame.getMaxLevels());
            System.out.println("Game state: " + hanoiTowerGame.getGameState());
        }
        score++;
        System.out.println("Your score is: " + score);
        System.out.println("You win!");
        for (int i = 0; i < 17; i++) {
            System.out.print("=");
        }
        // 这里不能close，scanner.close()一定要在整个程序完全确定关掉之后再关，因为它close的不是当前
        // scanner对象，而是整个 System.in 这个class!!!
//        scanner.close();
    }

    public int getScore(){
        return this.score;
    }
}