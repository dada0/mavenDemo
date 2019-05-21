package com.test.data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel {

	///public ReadExcel() {
		// TODO Auto-generated constructor stub
		public static Map<Integer,ArrayList<String>> excel (String path,String sh) throws BiffException, IOException{
			ArrayList list = null ;
			Map<Integer,ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
			Workbook book =Workbook.getWorkbook(new File(path));
			Sheet sheet = book.getSheet(sh);
	        int  rows = sheet.getRows();
	         int column = sheet.getColumns();
	       //  System.out.println(rows+"_"+column);
	       //  System.out.println(sheet.getCell(1, 1).getContents());
	         
	         for (int i=0;i<rows;i++){
	        	 list = new ArrayList();
	        	 for(int j=0;j<column;j++){
	        		 list.add(sheet.getCell(j, i).getContents());
	        		// System.out.println(sheet.getCell(j, i).getContents());
	        	 }
	        	
	        	 	/*
	        		 System.out.println("test "+sheet.getCell(0, i).getContents());
	        			
	        		 System.out.println(list.get(0));
	        	    */
	        	map.put(i, list);
	         }
			
	         	return map;
		}
	//}

}
