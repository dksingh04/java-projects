package com.dk.codeproblems;

import java.util.HashMap;
import java.util.Map;

public class WorkOfUnitsPerformed {
    public static void main(String ...args){
        System.out.println(findNumberOfWorksUnit(new int []{1,2,1,1,5,6,1}, 4));
        // 1, 2, _, _, _, 1,_, _, _,_, 1, 5, 6, _, _, 1

        System.out.println(findNumberOfWorksUnit(new int []{1,2,3,1}, 4));
        // 1, 2, 3, _, _, 1

        System.out.println(findNumberOfWorksUnit(new int []{1,2,2,1}, 3));
        // 1, 2, _, _, _, 2, 1
    }

    public static int findNumberOfWorksUnit(int [] tasks, int units){
        Map<Integer, Integer> taskMap = new HashMap<>();
        int noOfUnitsWorked = 0;
        for(int i = 0; i < tasks.length; i++){
            if(taskMap.get(tasks[i]) == null) {
                taskMap.put(tasks[i], i);
                noOfUnitsWorked++;
            }else{
                int prvTaskPos = taskMap.get(tasks[i]);
                int gapsOfUnit = i - prvTaskPos;
                if(gapsOfUnit >= units){
                    noOfUnitsWorked++;
                }else if(gapsOfUnit < units){
                    noOfUnitsWorked += (units - (gapsOfUnit - 1));
                    //plus the task
                    noOfUnitsWorked++;
                }
                taskMap.put(tasks[i], i);
            }
        }
        return noOfUnitsWorked;
    }


}
