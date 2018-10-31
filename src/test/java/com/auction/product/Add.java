package com.auction.product;

import java.beans.Statement;

import java.io.BufferedReader;

import java.io.FileReader;

import java.io.IOException;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

public class Add {



	    public static void main(String[] args) {

	        BufferedReader br = null;

	        Connection conn = null;

	        Statement stmt = null;

	        String url = "jdbc:oracle:thin:@localhost:1521:xe";

	        String user = "ict";

	        String password = "12345678";

	        try {

	            Class.forName("oracle.jdbc.driver.OracleDriver");

	            conn = DriverManager.getConnection(url, user, password);

	            stmt = (Statement) conn.createStatement();

	            br = new BufferedReader(new FileReader("./data/zipcode.csv"));

	            String line = null;

	            int result = 0;

	            while ((line = br.readLine()) != null) {

	                String[] lines = line.split(",");

	                String zipcode = lines[0];

	                String sido = lines[1];

	                String gugun = lines[2];

	                String dong = lines[3];

	                String ri = lines[4] == null ? "" : lines [4];

	                String bunji = lines[5] == null ? "" : lines [5];

	              

	                String sql = String.format("insert into zipcode values ('%s', '%s', '%s', '%s', '%s', '%s', %s)"

	                , zipcode, sido, gugun, dong, ri, bunji);

	                System.out.println(line);

	                result += ((java.sql.Statement) stmt).executeUpdate(sql);

	            }

	            System.out.println("[결과] : " + result);

	        } catch (ClassNotFoundException e) {

	            System.out.println("[에러] : " + e.getMessage());

	        } catch (SQLException e) {

	            System.out.println("[에러] : " + e.getMessage());

	        } catch (IOException e) {

	            System.out.println("[에러] : " + e.getMessage());

	        } finally {

	            if (stmt != null) try { ((Connection) stmt).close(); } catch(SQLException e) {}

	            if (conn != null) try { conn.close(); } catch(SQLException e) {}

	            if (br != null) try { br.close(); } catch(IOException e) {}

	        }

	    }

	}

