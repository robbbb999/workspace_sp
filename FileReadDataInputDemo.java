package com.input.output;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class FileReadDataInputDemo {
	 static final int EOF=-1;
	public static void main(String[] args) {
		FileReadDataInputDemo frdi=new FileReadDataInputDemo();
		frdi.run();
		
	}
	private void run() {
		char lineSep=System.getProperty("line.separator").charAt(0);
		try {
			
			DataInputStream ind=new DataInputStream(new FileInputStream("fatturaNonchar.txt"));
			double d;
			int i;
			//double total;
			char chr=' ';
			StringBuilder s =new StringBuilder();
			while(true) {
				if(chr==EOF) {
					break;
				}
				d=ind.readDouble();
				i=ind.readInt();
				
				while((chr=ind.readChar())!=lineSep) {
					s.append(chr);
					
				}
				
				System.out.println(d+" "+i+" "+s);
				s =new StringBuilder();
				
				
			}
			//ind.close();
		}catch(Exception e) {
			e.getMessage();
		}
	}
}
