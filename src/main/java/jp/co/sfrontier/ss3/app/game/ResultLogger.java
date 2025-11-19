package main.java.jp.co.sfrontier.ss3.app.game;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 対戦結果を記録するクラス
 */
public class ResultLogger {

	private static final String FILE_NAME = "result.csv";

	public void writeToFile(Direction player, Direction cpu, String result) {
		File file = new File(FILE_NAME);
		boolean fileExists = file.exists();

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
			// ファイルが存在しなければヘッダーを書く
			if (!fileExists) {
				writer.write("プレイヤーの方向,CPUの方向,勝敗");
				writer.newLine();
			}

			// 対戦結果を出力する
			writer.write(player + "," + cpu + "," + result);
			writer.newLine();

		} catch (IOException e) {
			System.out.println("CSVファイルへの書き込みに失敗しました。");
			e.printStackTrace();
		}
	}
}
