package main.java.jp.co.sfrontier.ss3.app.game;

import java.util.Random;

/**
 * CPUの方向を決めるクラス
 */
public class Cpu {

	// ランダムでCPUが向く方向を決める
	public Direction chooseRandomDirection() {
		Direction[] directions = Direction.values();

		Random random = new Random();
		Direction randomValue = directions[random.nextInt(directions.length)];
		return randomValue;
	}
}