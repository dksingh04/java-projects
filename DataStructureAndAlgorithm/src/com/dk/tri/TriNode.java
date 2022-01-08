package com.dk.tri;

import java.util.HashMap;

public class TriNode {
    private HashMap<Character, TriNode> children = new HashMap<>();
    private boolean isEndOfWords;

    public HashMap<Character, TriNode> getChildren() {
        return children;
    }

    public void setChildren(HashMap<Character, TriNode> children) {
        this.children = children;
    }

    public boolean isEndOfWords() {
        return isEndOfWords;
    }

    public void setEndOfWords(boolean endOfWords) {
        isEndOfWords = endOfWords;
    }

    public boolean insert(String word){
        TriNode curr = this;
        for(int i = 0;  i < word.length(); i++){
            if(!curr.children.containsKey(word.charAt(i))){
                curr.children.put(word.charAt(i), new TriNode());
                curr = curr.children.get(word.charAt(i));
            }else{
                // handle else part
            }
        }
        return true;
    }

    public boolean search(String word){

        return true;
    }
}
