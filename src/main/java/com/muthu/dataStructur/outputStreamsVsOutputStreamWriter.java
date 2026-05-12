package com.muthu.dataStructur;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class outputStreamsVsOutputStreamWriter {

	public static void main(String[] args) throws IOException {
		//outputstream for movie;
//		try {
//			OutputStream os = new FileOutputStream("C:\\Users\\Public\\Videos\\www.1TamilMV.blue - Thalaivan Thalaivii (2025) Tamil WEB-DL - 1080p - AVC - (DD+5.1 - 640Kbps & AAC) - 3.4GB - ESub.mkv"); 
//			BufferedInputStream is = new BufferedInputStream(new FileInputStream("C:\\Users\\Asus\\OneDrive\\Pictures\\Mahavatar Narsimha (2025) Tamil PRE HD   1080p   x264   ~ MR.mkv"));
//			byte[] buffer = new byte[8192]; // 8 KB buffer
//            int bytesRead;
//            while ((bytesRead = is.read(buffer)) != -1) {
//                os.write(buffer, 0, bytesRead);
//            }
//			System.out.println("succeed");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//outputstreamwrite for text
		try {
			OutputStreamWriter osw = new FileWriter("C:\\Users\\Asus\\OneDrive\\Desktop\\testdata.txt");
			InputStreamReader osr = new InputStreamReader(new FileInputStream("C:\\Users\\Asus\\OneDrive\\Desktop\\Price list.txt"));
			while(osr.ready()) {
				osw.append((char) osr.read());
			}
			System.out.println("succeed");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		

	}

}
