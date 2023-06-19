package jp.co.f1.jdbc.test;

import java.util.ArrayList;

public class StudentList {

	public static void main(String[] args) {

		// selectAllメソッドを呼び出す
		ArrayList<Student> studentList = new StudentDAO().selectAll();

		// 各Studentオブジェクトの情報を出力する
		for (int i = 0; i < studentList.size(); i++) {
			Student student = studentList.get(i);
			System.out.println(
					"学生 " + student.getName() + " の id は " + student.getId() + " 、成績は " + student.getScore() + " 点");
		}

	}

}
