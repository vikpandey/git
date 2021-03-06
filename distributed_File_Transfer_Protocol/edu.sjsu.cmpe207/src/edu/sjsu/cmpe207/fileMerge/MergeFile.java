package edu.sjsu.cmpe207.fileMerge;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;


public class MergeFile {
	private static String FILE_NAME;
	
	public MergeFile(String File_Name) {
		
		this.FILE_NAME = File_Name;
	}
	
    public static void merge(String File_Name) {
    	
    	File ofile = new File(FILE_NAME);
		FileOutputStream fos;
		FileInputStream fis;
		byte[] fileBytes;
		int bytesRead = 0;
		List<File> list = new ArrayList<File>();
		list.add(new File(FILE_NAME+".part0"));
		list.add(new File(FILE_NAME+".part1"));
		list.add(new File(FILE_NAME+".part2"));
		list.add(new File(FILE_NAME+".part3"));
		list.add(new File(FILE_NAME+".part4"));
		list.add(new File(FILE_NAME+".part5"));
		list.add(new File(FILE_NAME+".part6"));
		list.add(new File(FILE_NAME+".part7"));
		try {
		    fos = new FileOutputStream(ofile,true);
		    for (File file : list) {
		        fis = new FileInputStream(file);
		        fileBytes = new byte[(int) file.length()];
		        bytesRead = fis.read(fileBytes, 0,(int)  file.length());
		        assert(bytesRead == fileBytes.length);
		        assert(bytesRead == (int) file.length());
		        fos.write(fileBytes);
		        fos.flush();
		        fileBytes = null;
		        fis.close();
		        fis = null;
		    }
		    fos.close();
		    fos = null;
		}catch (Exception exception){
			exception.printStackTrace();
		}	
    }
}