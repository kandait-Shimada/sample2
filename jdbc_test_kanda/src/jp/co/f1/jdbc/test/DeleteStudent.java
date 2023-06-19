package jp.co.f1.jdbc.test;

import java.util.Scanner;

public class DeleteStudent {

	public static void main(String[] args) {

		// 変数の宣言
		StudentDAO objStu = new StudentDAO();
		Scanner sc = new Scanner(System.in);

		try {

			// 入力を促す文字列をコンソールに表示
			System.out.print("削除するid を入力＞");

			// キーボード入力された文字列でメソッドの呼び出し
			int id = sc.nextInt();
			int count = objStu.delete(id);

			// 改行
			System.out.println();

			// 削除を行った時と行わなかった時の場合分け
			if (count == 0) {
				System.out.println("id: " + id + "のデータは存在しませんでした。");
			} else {
				System.out.println("id: " + id + "を削除しました。");
			}

			// 例外処理
		} catch (Exception e) {
			System.out.println("エラー発生!\n" + e);
		}

	}

}
