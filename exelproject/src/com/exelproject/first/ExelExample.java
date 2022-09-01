package com.exelproject.first;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.sql.*;

public class ExelExample {

	public static void main(String[] args) throws Exception{
		
		
		//databse se connect kerne ke liye
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mapping","root","79284");
		 Statement st = con.createStatement();
		 ResultSet rs =  st.executeQuery("select * from map");
		 
		 
	     //sheet bnane ke liye 
         XSSFWorkbook w=new XSSFWorkbook();
	     XSSFSheet mysheet=w.createSheet("Prince First Sheet");
	  
		 
	     XSSFRow row=mysheet.createRow(0);
	     row.createCell(0).setCellValue("id");
	     row.createCell(1).setCellValue("action");
	     row.createCell(2).setCellValue("role");
	     row.createCell(3).setCellValue("status");
	     row.createCell(4).setCellValue("authorized");
	     row.createCell(5).setCellValue("submitted");
	     row.createCell(6).setCellValue("update_record_version");
	     row.createCell(7).setCellValue("inactive_previous_record");
	     row.createCell(8).setCellValue("last_configuration_action");
	     row.createCell(9).setCellValue("insert_record_into_audit");
	     row.createCell(10).setCellValue("insert_record_into_basetable");
	     row.createCell(11).setCellValue("mapping_status");
	     row.createCell(12).setCellValue("copy_record_from_base_table");
	     int r=1;
	     while(rs.next()) {
	    	 long id=rs.getLong("id");
	    	 String ac=rs.getString("action");
	    	 String role=rs.getString("role");
	    	 String status=rs.getString("status");
	    	 String authorized=rs.getString("authorized");
	    	 String submitted=rs.getString("submitted");
	    	 String urv=rs.getString("update_record_version");
	    	 String ipr=rs.getString("inactive_previous_record");
	    	 String lca=rs.getString("last_configuration_action");
	    	 String iria=rs.getString("insert_record_into_audit");
	    	 String irib=rs.getString("insert_record_into_basetable");
	    	 String ms=rs.getString("mapping_status");
	    	 String crfbt=rs.getString("copy_record_from_base_table");
	    	 
	    	 row=mysheet.createRow(r++);
	    	 row.createCell(0).setCellValue(id);
	    	 row.createCell(1).setCellValue(ac);
	    	 row.createCell(2).setCellValue(role);
	    	 row.createCell(3).setCellValue(status);
	    	 row.createCell(4).setCellValue(authorized);
	    	 row.createCell(5).setCellValue(submitted);
	    	 row.createCell(6).setCellValue(urv);
	    	 row.createCell(7).setCellValue(ipr);
	    	 row.createCell(8).setCellValue(lca);
	    	 row.createCell(9).setCellValue(iria);
	    	 row.createCell(10).setCellValue(irib);
	    	 row.createCell(11).setCellValue(ms);
	    	 row.createCell(12).setCellValue(crfbt);
	     }
	     FileOutputStream fos=new FileOutputStream("D:\\apache poi\\created files\\first.xlsx"); 
	     w.write(fos);
	     
	     w.close();
	     fos.close();
	     con.close();
	     System.out.println("Well Done all Completed!!!");
	}	
}

