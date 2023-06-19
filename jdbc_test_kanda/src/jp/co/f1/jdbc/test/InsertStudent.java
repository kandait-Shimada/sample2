package jp.co.f1.jdbc.test;

import java.util.Scanner;
import java.util.ArrayList;

public class InsertStudent {

	public static void main(String[] args) {

		// 変数の宣言
		ArrayList<Student>  studentsArrayList = null;
		StudentDAO objStu = new StudentDAO();
		Scanner sc = new Scanner(System.in);

		try {
			// 変数の宣言
			int sid = 0;
			String name = null;
			int id = 0;
			int score = 0;

			Student student = new Student();

			// 生徒一覧の取得
			studentsArrayList = new StudentDAO().selectAll();

			// キーボード入力された文字列をint型にキャストしてsidに格納
			System.out.print("sid を入力＞");
			String inputSid = sc.nextLine();
			sid = Integer.parseInt(inputSid);
			student.setSid(sid);

			// キーボード入力された文字列をnameに格納
			System.out.print("name を入力＞");
			name = sc.nextLine();
			student.setName(name);

			// キーボード入力された文字列をint型にキャストしてidに格納
			System.out.print("id を入力＞");
			String inputId = sc.nextLine();
			id = Integer.parseInt(inputId);
			student.setId(id);

			// キーボード入力された文字列をint型にキャストしてscoreに格納
			System.out.print("score を入力＞");
			String inputScore = sc.nextLine();
			score = Integer.parseInt(inputScore);
			student.setScore(score);

			// insertメソッドの呼び出し
			int count = objStu.insert(student);

			System.out.println(count + "件の登録が完了しました。");


		}catch(Exception e){
			System.out.println("エラー発生!\n" + e);
		}



	}

}
