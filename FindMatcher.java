package com.merge.sorted.arr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMatcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abbccccdddcc"; //Find location of max occurrences 
		FindMatcher matcher = new FindMatcher();
		List<RepeatedCharProp> listMap = new ArrayList<RepeatedCharProp>();
		StringBuffer repStrBuff = new StringBuffer();
		RepeatedCharProp repObj = matcher.new RepeatedCharProp();
		for(int i = 0; i < str.length()-1; i++){
			
			if(str.charAt(i) == str.charAt(i+1)){
				repStrBuff.append(""+str.charAt(i));
				if(i+1==str.length()-1){
					repStrBuff.append(""+str.charAt(i+1));
					repObj.repeatedChars = repStrBuff.toString();
					repObj.index = i - (repObj.repeatedChars.length() -1);
					repObj.length = repObj.repeatedChars.length();
					listMap.add(repObj);
				}
			}else{
					
				if(i == 0 || (i > 0 && str.charAt(i) != str.charAt(i-1))){
					repStrBuff = new StringBuffer();
					repObj = matcher.new RepeatedCharProp();
					repStrBuff.append(""+str.charAt(i));
					repObj.repeatedChars = repStrBuff.toString();
					repObj.index = i - (repObj.repeatedChars.length() -1);
					repObj.length = repObj.repeatedChars.length();
				}else{
					repStrBuff.append(""+str.charAt(i));
					repObj.repeatedChars = repStrBuff.toString();
					repObj.index = i - (repObj.repeatedChars.length() -1);
					repObj.length = repObj.repeatedChars.length();
				}
				
				listMap.add(repObj);
				repObj = matcher.new RepeatedCharProp();
				repStrBuff = new StringBuffer();
				
			}
		}
		
		Collections.sort(listMap);
		System.out.println(listMap.toString());
		
		

	}
	
	class RepeatedCharProp implements Comparable<RepeatedCharProp>{
		int index;
		String repeatedChars;
		int length;
		public int compareTo(RepeatedCharProp arg0) {
			// TODO Auto-generated method stub
			return (this.length > arg0.length)?1:-1;
		}
		
		public String toString(){
			return "Index: "+index +" RepeatStr: "+repeatedChars+" Length: "+length;
		}
		
	}

}
