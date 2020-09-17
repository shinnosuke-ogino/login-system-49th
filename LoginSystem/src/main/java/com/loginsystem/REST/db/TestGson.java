package com.loginsystem.REST.db;

import java.sql.SQLException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class TestGson {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Gson gson = new GsonBuilder().disableHtmlEscaping().create();

		//0
		System.out.println(gson.toJson(100));
		System.out.println(gson.fromJson("100", int.class));
		System.out.println(gson.fromJson("String", String.class));
		System.out.println();

		//1
		String [] stringArray = {"alpha", "bravo", "charlie"};
		System.out.println(gson.toJson(stringArray));
		System.out.println();

		//2
		int currentUserId = 1000003;
		UserInfo testUser = new UserInfo();
		try {
			testUser.selectFromDb(currentUserId);
			String jstrUser = gson.toJson(testUser);
			System.out.println(jstrUser);
		} catch (SQLException ex) {
			System.out.println("SQLException");
		}
		System.out.println();

		//3
		String jstrUser = "{\"id\":1008,\"pw\":\"testpassword\",\"name\":\"名前1010\",\"deptNo\":1001,\"registerDate\":\"2020-09-17\"}";
		UserInfo testUser3 = gson.fromJson(jstrUser, UserInfo.class);
		System.out.println(gson.toJson(testUser3));
		try {
			testUser3.insertIntoDb();
		} catch (SQLException ex) {
			System.out.println("fail");
		}
	}
}
