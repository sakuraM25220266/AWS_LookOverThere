package main.java.jp.co.sfrontier.ss3.app.game;

/**
 * あっちむいてほいの勝敗判定を行うクラス
 */
public class Judge {
	public String decideWinner(Direction player, Direction cpu) {
		if (player == cpu) {
			return "プレイヤーの勝ち";
		} else {
			return "CPUの勝ち";
		}
	}
}
