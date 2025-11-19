package main.java.jp.co.sfrontier.ss3.app.game;

import java.util.Scanner;

/**
 * プレイヤーの入力・バリデーション処理を行うクラス
 */
public class Player {

	private Scanner scanner = new Scanner(System.in);

	public Direction chooseDirection() {
		int input;

		while (true) {
			try {
				input = Integer.parseInt(scanner.nextLine());

				if (validate(input)) {
					switch (input) {
					case 8:
						return Direction.UP;
					case 2:
						return Direction.DOWN;
					case 6:
						return Direction.RIGHT;
					case 4:
						return Direction.LEFT;
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("数字で入力してください。");
			}
		}
	}

	private boolean validate(int input) {
		if (input == 2 || input == 4 || input == 6 || input == 8) {
			return true;
		} else {
			System.out.print("入力が正しくありません。もう一度入力してください。(上：8、下：2、右：6、左：4)：");
			return false;
		}
	}
}
