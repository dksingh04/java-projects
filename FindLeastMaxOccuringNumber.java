package com.spi.global.programme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindLeastMaxOccuringNumber {

	public static void main(String[] args) {
		int data [] = {27, 15, 15, 11, 27, 11, 11, 15, 15, 11, 8, 8, 8, 8};
		int count [] = new int[101];
		
		
		for (int i = 0; i < data.length; i++) {
			count[data[i]] = count[data[i]] + 1;
			
		}
		
		List<DataInfo> actualData = new ArrayList<DataInfo>();
		
		for(int i =0; i < count.length; i++){
			if(count[i]!=0){
				DataInfo dataInfo = new DataInfo();
				dataInfo.count = count[i];
				dataInfo.number = i;
				actualData.add(dataInfo);
			}
			
		}
		
		Collections.sort(actualData, new Comparator<DataInfo>() {

			@Override
			public int compare(DataInfo arg0, DataInfo arg1) {
				// TODO Auto-generated method stub
				return (arg0.count < arg1.count )? 1: -1;
			}
		});
		
		System.out.println(actualData);
		
		int maxOccurrenceNum = actualData.get(0).number;
		
		int maxCount = actualData.get(0).count;
		for (int i = 1; i < actualData.size(); i++) {
			if(maxCount == actualData.get(i).count && maxOccurrenceNum > actualData.get(i).number){
				maxOccurrenceNum = actualData.get(i).number;
			}
		}
		
		System.out.println(maxOccurrenceNum);
		
		
		
	}
	
	private static class DataInfo{
		int count;
		int number;
		@Override
		public String toString() {
			return "DataInfo [count=" + count + ", number=" + number + "]";
		}
		
		
	}

}
