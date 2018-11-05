package com.dk.graph.bfs.webcrawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.attribute.AclEntry.Builder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
	private Queue<String> queue;
	List<String> discoveredWebsites = new ArrayList<>();
	public WebCrawler() {
	    this.queue = new LinkedList<>();
		this.discoveredWebsites = new ArrayList<>();
	}
	
	public void crawlWeb(String website) {
		this.queue.add(website);
		this.discoveredWebsites.add(website);
		
		while(!this.queue.isEmpty()) {
			String v = queue.remove();
			String rawHTML = readHTMLFromURL(v);
			String regex = "http://(\\w+\\.)*(\\w+)";
			
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(rawHTML);
			while(matcher.find()) {
				String actualURL = matcher.group();
				
				if(!discoveredWebsites.contains(actualURL)) {
					discoveredWebsites.add(actualURL);
					queue.add(actualURL);
					System.out.println("Website URL found: "+actualURL);
				}
			}
			
		}
		
	}
	
	public String readHTMLFromURL(String url) {
		BufferedReader bufReader = null;
		StringBuilder builder = new StringBuilder();
		try {
			
			URL u = new URL(url);
			bufReader = new BufferedReader(new InputStreamReader(u.openStream()));
			
			bufReader.lines().forEach(line->{
				builder.append(line);
			});
			bufReader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return builder.toString();
	}

}
