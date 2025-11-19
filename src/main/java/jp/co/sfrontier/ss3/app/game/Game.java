package main.java.jp.co.sfrontier.ss3.app.game;

import java.util.Scanner;

/**
 * ゲームの進行全体を管理するメインクラス
 */
public class Game {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Player player = new Player();
		Cpu cpu = new Cpu();
		Judge judge = new Judge();
		ResultLogger resultLogger = new ResultLogger();

		System.out.println("あっちむいてほいを始めます。");

		boolean playAgain = true;

		while (playAgain) {
			System.out.print("方向を予想してください。(上：8、下：2、右：6、左：4)：");

			// プレイヤーの方向を取得する
			Direction playerDirection = player.chooseDirection();

			// CPUの方向を取得する
			Direction cpuDirection = cpu.chooseRandomDirection();

			//勝敗を判定する
			String result = judge.decideWinner(playerDirection, cpuDirection);

			// 結果を表示する
			System.out.println("プレイヤーの方向：" + playerDirection);
			System.out.println("CPUの方向：" + cpuDirection);
			System.out.println("結果:" + result);

			// 結果をファイルに書き込む
			resultLogger.writeToFile(playerDirection, cpuDirection, result);

			System.out.print("もう一度対戦しますか？(y/n)：");
			String input = scanner.nextLine().trim().toLowerCase();

			if (!input.equals("y")) {
				playAgain = false;
				System.out.println("ゲームを終了します。");
			}
		}
		scanner.close();
	}

}
