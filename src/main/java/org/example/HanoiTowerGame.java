package org.example;//Student 1 full name:
//Student 2 full name:
//==================================================



/**
 * Your documentation for this class ....
 *
 *
 */

import java.lang.Math;
import java.util.Stack;

public class HanoiTowerGame {

	//This will point to the array of three towers (type of towers LinkedStack)
	private Stack<Integer>[] towerValues;

	private int level;

	private int maxLevels;

	private int disks;

	private GameState gameState;
	//your code here

	public HanoiTowerGame(int disks){
		this.disks = disks;
		towerValues = new Stack[this.disks];
		this.maxLevels = 2*((int)Math.pow(2,disks) -1);
		this.gameState = GameState.PLAYING;
		// 第一个stack的初始值为disks数量
		for (int i = 0; i < disks; i++) {
			towerValues[i] = new Stack<>();
		}
		for (int i = disks; i > 0; i--) {
			towerValues[0].push(i);
		}

		// 查看塔初始状态
		for(Stack<Integer> s: towerValues){
			System.out.println(s);
		}
	}

	public int getDisks(){
		return this.disks;
	}

	public int getLevel(){
		return this.level;
	}

	public int getMaxLevels(){
		return this.maxLevels;
	}

	public GameState getGameState(){
		return this.gameState;
	}

	public int getDisksAtTower(int i){
		return towerValues[i].size();
	}

	public void checkWinner(){
		// 赢了
		if (getDisksAtTower(2) == 3){
			gameState = GameState.WINNER;
		}
	}

	public void play(int source, int destination){
		level++;
		// 检查是否在从空的塔里取
		if (!towerValues[source].isEmpty()){
			// 查看是否符合规则， 小的放到大的上，大的不能放到小的上
			if (!towerValues[destination].isEmpty()) {
				if (towerValues[source].peek() > towerValues[destination].peek()) {
					System.out.println("Invalid move!!");
				} else {
					towerValues[destination].push(towerValues[source].pop());
					checkWinner();
				}
			}else {
				towerValues[destination].push(towerValues[source].pop());
			}
		}else{
			System.out.println("There is/are no disks at tower " + source + " !!");
		}
	}

	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < towerValues.length; i++) {
			appendTowerToStringBuilder(towerValues[i], i+1, stringBuilder);
		}
		return stringBuilder.toString();
	}

	public void appendTowerToStringBuilder(Stack<Integer> stack, int tower, StringBuilder string){
		string.append("Tower ").append(tower).append(Utils.NEW_LINE);
		Stack<Integer> s = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		while (!stack.isEmpty()){
			s.push(stack.pop());
		}
		while (!s.isEmpty()){
			int curr = s.pop();
			s2.push(curr);
			// 还原原tower
			stack.push(curr);
		}
		while (!s2.isEmpty()){
			int towerLevel = s2.pop();
			for (int i = 0; i < towerLevel; i++) {
				string.append("-");
			}
			string.append(Utils.NEW_LINE);
		}
	}
}
