package com.muthu.dataStructur;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class StreamVersesReader {
	public static void main(String[] args) throws IOException {
//		ByteArrayInputStream input = new ByteArrayInputStream("Muthu".getBytes());
//		FileInputStream input = new FileInputStream("C:/Users/Public/springBoot/spring-start-here-learn-what-you-need-and-learn-it-well-2021-laurentiu-spilca.pdf");
//		int data = 0;
//		while(((data =input.read()) != -1)) {
//			System.out.print((char)data);
//		}
		
		InputStreamReader reader = new InputStreamReader(System.in);
		int dataR = reader.read();
		
		while(reader.ready()) {
			System.out.print((char)dataR);
			dataR = reader.read();
		}
	}

}
