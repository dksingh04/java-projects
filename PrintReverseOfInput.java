package com.spi.global.programme;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PrintReverseOfInput {

	public static void main(String[] args) {

		try {
			Path file = Paths
					.get("C:\\Deepak_Programming\\SPIGlobal\\src\\com\\spi\\global\\programme\\input.txt");
			InputStream is = Files.newInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			String line = null;
			while ((line = br.readLine()) != null) {
				char[] lineData = line.toCharArray();
				
				for(int i = lineData.length-1; i>=0; i--){
					System.out.print(lineData[i]);
					
				}
				System.out.println("");
			}

			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

}
