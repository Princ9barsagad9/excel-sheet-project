package com.csvproblem.project;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.opencsv.CSVWriter;

public class CSV2 {

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mapping", "root", "79284");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from map");
			CSVWriter writer = new CSVWriter(new FileWriter("D:\\apache poi\\created files\\csv2.csv"));
			StringBuilder sb =new StringBuilder();
		
		
		} catch (Exception e) {

		}
	}

}
