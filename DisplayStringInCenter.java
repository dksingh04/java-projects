package com.merge.sorted.arr;

public class DisplayStringInCenter {

	int screenLen = 80;
	public static void main(String[] args) {
		DisplayStringInCenter disp = new DisplayStringInCenter();
		disp.headline("It's My Birthday");
	}
	
	public void headline(String line){
		String headline = "** "+line;
		
		headline = headline.toUpperCase();
		
		headline = headline.concat(" **");
		int lineLength = headline.length();
		int screenCenter = screenLen/2;
		int spaceCount = screenCenter - lineLength/2;
		StringBuffer strBuff = new StringBuffer();
		for(int i = 0; i < spaceCount; i ++){
			strBuff.append(" ");
		}
		strBuff.append(headline);
		
		for(int i = 0; i < spaceCount; i ++){
			strBuff.append(" ");
		}
		
		
		System.out.println(spaceCount);
		System.out.println(strBuff.toString());
	
	}

}
