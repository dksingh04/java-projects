package com.dk.codeproblems;

import java.io.*;
import java.util.*;
public class CandidateCode {
    public static void main(String args[] ) throws Exception {

        //Write code here
        Scanner scanner = new Scanner(System.in);
        String vComposition = scanner.nextLine();
        System.out.println(vComposition);
        int noOfPerson = scanner.nextInt();
        System.out.println(noOfPerson);
        List<String> bloodComposition = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for(int i = 0; i <= noOfPerson; i++){
            bloodComposition.add(scanner.nextLine());
        }

        bloodComposition.stream().forEach(bc -> {
            int index = -1;
            for(char ch: bc.toCharArray()){
                index = vComposition.indexOf(ch, index+1);
                //System.out.println("Index: "+index);
                if(index == -1){
                    result.add("NEGATIVE");
                    break;
                }

            }

            if(index > 0){
                result.add("POSITIVE");
            }

        });

        result.stream().forEach(System.out::println);
    }
}
