package com.dk.strings;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CDPath {
    private String path;
    private List<String> pathStack;

    public CDPath(String path){
        this.path = path;
        pathStack = new Stack<>();
        if(path != null){
            for(String d:path.split("/")){
                pathStack.add(d);
            }
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public CDPath cd(String path){

        if(path != null){
            int size = pathStack.size() - 1;
            if(path.startsWith("../") && path.lastIndexOf("../") == path.length() - 2){
                int len = path.split("/").length;
                int i = size;
                while(len > 0){
                    this.pathStack.remove(i);
                    i--;
                    len--;
                }
            }else if(path.equals("..")){
                this.pathStack.remove(size);
            }else if(path.equals("/")){
                while(!pathStack.isEmpty()){
                    pathStack.remove(size);
                    size--;
                }
                pathStack.add("/");
            }else if((path.startsWith("../") && path.lastIndexOf("../") < path.length() - 2)){
                pathStack.add(path.substring(path.lastIndexOf("../")+2));
            }else if(!path.equals("/") && !path.equals("..") && path.matches("[A-Za-z]")){
                pathStack.add(path);
            }
            return buildNewPath();
        }
        return new CDPath(this.getPath());

    }

    private CDPath buildNewPath(){
        StringBuilder builder = new StringBuilder();

        while(!pathStack.isEmpty()){
            builder.append(pathStack.remove(0)).append("/");
        }
        builder.deleteCharAt(builder.length() - 1);
        return new CDPath(builder.toString());
    }
}