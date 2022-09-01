package com.csvproblem.project;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.io.FileUtils;

import com.opencsv.CSVWriter;

public class CsvRunner {

	public static void main(String[] args) throws Exception{
			
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mapping","root","79284");
			 Statement st = con.createStatement();
			 ResultSet rs =  st.executeQuery("select * from map");
			 
			 CSVWriter writer= new CSVWriter(new FileWriter("D:\\apache poi\\created files\\csvproject.csv"));
			 PrintWriter pw =new PrintWriter("D:\\apache poi\\created files\\csvproject.csv");	
			// StringBuilder sb =new StringBuilder();
			 String str1=new String("id|action|role|status|authorized|submitted|update_record_version|inactive_previous_record|last_configuration_action|insert_record_into_audit|insert_record_into_basetable|mapping_status|copy_record_from_base_table");
			 
			 pw.write(str1);
			 pw.write("\n");
			 String str=new String("|");
			 int r=1;
		     while(rs.next()) {
		    	 String id=rs.getString("id");
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
		    	 
		         pw.write(id);
		         pw.write(str);
		         pw.write(ac);
		         pw.write(str);
		         pw.write(role);
		         pw.write(str);
		         pw.write(status);
		         pw.write(str);
		         pw.write(authorized);
		         pw.write(str);
		         pw.write(submitted);
		         pw.write(str);
		         pw.write(urv);
		         pw.write(str);
		         pw.write(ipr);
		         pw.write(str);
		         pw.write(lca);
		         pw.write(str);
		         pw.write(iria);
		         pw.write(str);
		         pw.write(irib);
		         pw.write(str);
		         pw.write(ms);
		         pw.write(str);
		         pw.write(crfbt);
		         pw.write("\n"); 		
		    	 
		    	 
		     }
		    // pw.flush();
         pw.close();
         System.out.println("well done sir you have done it!");
         File source = new File("D:\\\\apache poi\\\\created files\\\\csvproject.csv");
         File dest = new File("C:\\Users\\lenovo\\created files\\csvproject.csv");
         FileUtils.copyToDirectory(source, dest);	 
	}

}
