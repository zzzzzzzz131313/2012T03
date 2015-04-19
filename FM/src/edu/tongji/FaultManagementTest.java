package edu.tongji;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class FaultManagementTest {

	@Test
	public void test() throws IOException {
		
		FaultManagement fm = new FaultManagement();
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");


		//test1
		fm.generateWarningMessage("test");
		String date = dateFormat.format(now);
		String filename = date + ".txt";
		File infile=new File(filename);
		FileReader in;
		try {
			in = new FileReader(infile);
			BufferedReader reader =new BufferedReader(in) ;
			String line=reader.readLine();
			assertEquals(line,date);
			line=reader.readLine();
			assertEquals(line,"MESSAGE:");
			line=reader.readLine();
			assertEquals(line,"test");
			reader.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		//test2
		fm.generateWarningMessage("test2", "./warning/");
		date = dateFormat.format(now);
		filename = date + ".txt";
		infile=new File(filename);
		try {
			in = new FileReader(infile);
			BufferedReader reader =new BufferedReader(in) ;
			String line=reader.readLine();
			assertEquals(line,date);
			line=reader.readLine();
			assertEquals(line,"MESSAGE:");
			line=reader.readLine();
			assertEquals(line,"test2");
			reader.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
